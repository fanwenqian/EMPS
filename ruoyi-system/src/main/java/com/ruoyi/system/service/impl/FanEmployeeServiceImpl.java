package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.FanEmployee;
import com.ruoyi.system.mapper.FanEmployeeMapper;
import com.ruoyi.system.service.IFanEmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 查询员工Service业务层处理
 * 
 * @author wqfan
 * @date 2020-04-15
 */
@Service
public class FanEmployeeServiceImpl implements IFanEmployeeService 
{
    @Resource
    private FanEmployeeMapper fanEmployeeMapper;

    /**
     * 查询员工
     * 
     * @param empId 查询员工ID
     * @return 员工
     */
    @Override
    public FanEmployee selectFanEmployeeById(Long empId)
    {
        return fanEmployeeMapper.selectFanEmployeeById(empId);
    }

    /**
     * 员工列表
     * 
     * @param fanEmployee 员工
     * @return 查询员工
     */
    @Override
    public List<FanEmployee> selectFanEmployeeList(FanEmployee fanEmployee)
    {
        return fanEmployeeMapper.selectFanEmployeeListWithDept(fanEmployee);
    }

    /**
     * 新增查询员工
     * 
     * @param fanEmployee 员工
     * @return 结果
     */
    @Override
    public int insertFanEmployee(FanEmployee fanEmployee)
    {
        int i = fanEmployeeMapper.insertFanEmployee(fanEmployee);
        int j = fanEmployeeMapper.insertFanEmployeeDept(fanEmployee);
        if (i == j && i > 0){
        return i;
        }
        return 0;
    }

    /**
     * 修改查询员工
     * 
     * @param fanEmployee 查询员工
     * @return 结果
     */
    @Override
    public int updateFanEmployee(FanEmployee fanEmployee)
    {
        int i = fanEmployeeMapper.updateFanEmployee(fanEmployee);
        int j = fanEmployeeMapper.updateFanEmployeeDept(fanEmployee);
        if(i == j && i > 0){
            return i;
        }
        return 0;
    }

    /**
     * 删除查询员工对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFanEmployeeByIds(String ids)
    {
        int i = fanEmployeeMapper.deleteFanEmployeeByIds(Convert.toStrArray(ids));
        int j=fanEmployeeMapper.deleteFanEmployeeDeptByIds(Convert.toStrArray(ids));
        if(i == j && i > 0){
            return i;
        }
        return 0;
    }

    /**
     * 删除查询员工信息
     * 
     * @param empId 查询员工ID
     * @return 结果
     */
    @Override
    public int deleteFanEmployeeById(Long empId)
    {
      int i = fanEmployeeMapper.deleteFanEmployeeDeptById(empId);
      int j = fanEmployeeMapper.deleteFanEmployeeById(empId);
        if(i == j && i > 0){
        return i;
    }
        return 0;
    }
}
