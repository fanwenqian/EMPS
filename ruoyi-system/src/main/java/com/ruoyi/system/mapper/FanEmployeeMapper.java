package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FanEmployee;

/**
 * 查询员工Mapper接口
 * 
 * @author wqfan
 * @date 2020-04-15
 */
public interface FanEmployeeMapper 
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
     * 查询查询员工列表（包括部门信息）
     *
     * @param fanEmployee 查询员工
     * @return 查询员工集合
     */
    public List<FanEmployee> selectFanEmployeeListWithDept(FanEmployee fanEmployee);


    /**
     * 新增查询员工
     *
     * @param fanEmployee 查询员工
     * @return 结果
     */
    public int insertFanEmployee(FanEmployee fanEmployee);

    /**
     * 新增查询员工部门信息
     *
     * @param fanEmployee 查询员工
     * @return 结果
     */
    public int insertFanEmployeeDept(FanEmployee fanEmployee);

    /**
     * 修改查询员工
     * 
     * @param fanEmployee 查询员工
     * @return 结果
     */
    public int updateFanEmployee(FanEmployee fanEmployee);

    /**
     * 修改员工部门
     *
     * @param fanEmployee 员工
     * @return 结果
     */
    public int updateFanEmployeeDept(FanEmployee fanEmployee);

    /**
     * 删除查询员工
     * 
     * @param empId 查询员工ID
     * @return 结果
     */
    public int deleteFanEmployeeById(Long empId);

    /**
     * 删除员工部门信息
     *
     * @param empId 员工ID
     * @return 结果
     */
    public int deleteFanEmployeeDeptById(Long empId);

    /**
     * 批量删除查询员工
     * 
     * @param empIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteFanEmployeeByIds(String[] empIds);

    /**
     * 批量删除员工部门
     *
     * @param empIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteFanEmployeeDeptByIds(String[] empIds);

}
