package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FanEmployee;

/**
 * 查询员工Service接口
 * 
 * @author wqfan
 * @date 2020-04-15
 */
public interface IFanEmployeeService 
{
    /**
     * 查询查询员工
     * 
     * @param empId 查询员工ID
     * @return 查询员工
     */
    public FanEmployee selectFanEmployeeById(Long empId);

    /**
     * 查询查询员工列表
     * 
     * @param fanEmployee 查询员工
     * @return 查询员工集合
     */
    public List<FanEmployee> selectFanEmployeeList(FanEmployee fanEmployee);

    /**
     * 新增查询员工
     * 
     * @param fanEmployee 查询员工
     * @return 结果
     */
    public int insertFanEmployee(FanEmployee fanEmployee);

    /**
     * 修改查询员工
     * 
     * @param fanEmployee 查询员工
     * @return 结果
     */
    public int updateFanEmployee(FanEmployee fanEmployee);

    /**
     * 批量删除查询员工
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFanEmployeeByIds(String ids);

    /**
     * 删除查询员工信息
     * 
     * @param empId 查询员工ID
     * @return 结果
     */
    public int deleteFanEmployeeById(Long empId);
}
