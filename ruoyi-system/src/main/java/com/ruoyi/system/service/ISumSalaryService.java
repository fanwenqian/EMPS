package com.ruoyi.system.service;

import com.ruoyi.system.domain.FanAttendance;
import com.ruoyi.system.domain.FanRap;
import com.ruoyi.system.domain.FanSalary;
import com.ruoyi.system.domain.FiveinsOnefund;

import java.util.List;

public interface ISumSalaryService {
    /**
     * 更新薪资(五险一金)
     * 参数：FiveinsOnefund
     */
    void updateSalaryIns(FiveinsOnefund fiveinsOnefund);

    /**
     *更新薪资(考勤信息)
     * 参数：FanAttendance
     */
    void updateSalaryAtten(FanAttendance fanAttendance);

    /**
     * 更新薪资(奖惩信息)
     * @param fanRap
     */
    void updateSalaryRap(FanRap fanRap);

    /**
     * 更新薪资(实发薪资)
     * @param list
     */
    void updateRealSalary(List<FanSalary> list);
}
