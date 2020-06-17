package com.ruoyi.system.service;

import com.ruoyi.system.domain.FanEmployee;

public interface IAddSalaryService {
    /**
     * 向salary表中添加empId
     * @param fanEmployee
     */
    void insertIntoSalary(FanEmployee fanEmployee);
}
