package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.FanAttendance;
import com.ruoyi.system.domain.FanRap;
import com.ruoyi.system.domain.FanSalary;
import com.ruoyi.system.domain.FiveinsOnefund;
import com.ruoyi.system.mapper.FanRapMapper;
import com.ruoyi.system.mapper.FanSalaryMapper;
import com.ruoyi.system.service.IFanSalaryService;
import com.ruoyi.system.service.ISumSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class ISumSalaryServiceImpl implements ISumSalaryService {

    @Resource
    private FanSalaryMapper salaryMapper;
    @Resource
    private FanRapMapper fanRapMapper;
    @Autowired
    private IFanSalaryService fanSalaryService;

    @Override
    public void updateSalaryIns(FiveinsOnefund fiveinsOnefund) {
       double sumInsFund = fiveinsOnefund.getEmpInjuryIns()+fiveinsOnefund.getMaternityIns()+
                           fiveinsOnefund.getUnemploymentIns()+fiveinsOnefund.getEndowmentIns()+
                           fiveinsOnefund.getMedicalIns()+fiveinsOnefund.getHousingFund();
       FanSalary fanSalary=new FanSalary();
       fanSalary.setEmpId(fiveinsOnefund.getEmpId());
        List<FanSalary> fanSalaries = salaryMapper.selectFanSalaryList(fanSalary);
        for (FanSalary salary:fanSalaries){
            salary.setFiveinsPay(sumInsFund);
            salaryMapper.updateFanSalary(salary);
        }
    }

    @Override
    public void updateSalaryAtten(FanAttendance fanAttendance) {
            //迟到20，早退20，请假50，旷班100
            double attenPay=fanAttendance.getEarly() * 20 + fanAttendance.getLate() * 20  +
                    fanAttendance.getAskForLeave() * 50 + fanAttendance.getAbsenteeism() * 100;
            FanSalary fanSalary=new FanSalary();
            fanSalary.setEmpId(fanAttendance.getEmpId());
            List<FanSalary> fanSalaries = salaryMapper.selectFanSalaryList(fanSalary);
            for (FanSalary salary:fanSalaries){
                salary.setAttenPay(attenPay);
                salaryMapper.updateFanSalary(salary);
            }
    }

    @Override
    public void updateSalaryRap(FanRap fanRap){
        //获取员工id
        Long empId = fanRap.getEmpId();
        FanRap fanR=new FanRap();
        fanR.setEmpId(empId);
        //获取奖励部分奖金
        fanR.setRapType("1");
        List<FanRap> fanRaps = fanRapMapper.selectFanRapList(fanR);
        double sumR=0;
        for (FanRap raps : fanRaps) {
            sumR += raps.getRapMoney();
        }
        //获取惩罚部分罚金
        fanR.setRapType("0");
        List<FanRap> fanP = fanRapMapper.selectFanRapList(fanR);
        double sumP=0;
        for (FanRap paps : fanP) {
            sumP += paps.getRapMoney();
        }
        //求和
        double result = sumR - sumP;
        //更新薪资表
        FanSalary fanSalary = new FanSalary();
        fanSalary.setEmpId(empId);
        List<FanSalary> fanSalaries = salaryMapper.selectFanSalaryList(fanSalary);
        for (FanSalary iSalary: fanSalaries){
            iSalary.setRapPay(result);
            salaryMapper.updateFanSalary(iSalary);
        }
    }

    @Override
    public void updateRealSalary(List<FanSalary> list) {
        if(list!=null){
            for(FanSalary salary:list){
                if (salary.getBasePay()!=null && salary.getRealPay()==null){
                    double realPay=salary.getBasePay()+salary.getRapPay()-salary.getFiveinsPay()-salary.getAttenPay();
                    salary.setRealPay(realPay);
                    fanSalaryService.updateFanSalary(salary);
                }else if (salary.getBasePay()!=null && salary.getRealPay()!=null &&
                        !salary.getRealPay().equals(salary.getBasePay()+salary.getRapPay()-salary.getFiveinsPay()-salary.getAttenPay())){
                    double realPay=salary.getBasePay()+salary.getRapPay()-salary.getFiveinsPay()-salary.getAttenPay();
                    salary.setRealPay(realPay);
                    fanSalaryService.updateFanSalary(salary);
                }
            }
        }
    }
}
