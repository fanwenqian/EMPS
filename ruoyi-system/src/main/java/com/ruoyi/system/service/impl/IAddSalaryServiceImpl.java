package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.FanEmployee;
import com.ruoyi.system.domain.FanSalary;
import com.ruoyi.system.mapper.FanEmployeeMapper;
import com.ruoyi.system.mapper.FanSalaryMapper;
import com.ruoyi.system.service.IAddSalaryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IAddSalaryServiceImpl implements IAddSalaryService {

    @Resource
    private FanSalaryMapper fanSalaryMapper;
    @Resource
    private FanEmployeeMapper fanEmployeeMapper;

    @Override
    public void insertIntoSalary(FanEmployee fanEmployee) {
        List<FanEmployee> fanEmployees = fanEmployeeMapper.selectFanEmployeeList(fanEmployee);
        for(FanEmployee emp:fanEmployees){
            Long empId= emp.getEmpId();
            FanSalary fanSalary = new FanSalary();
            fanSalary.setEmpId(empId);
            fanSalaryMapper.insertFanSalary(fanSalary);
        }
    }
}
