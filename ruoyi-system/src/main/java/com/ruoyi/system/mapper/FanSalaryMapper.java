package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FanSalary;

/**
 * 薪资Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-19
 */
public interface FanSalaryMapper 
{
    /**
     * 查询薪资
     * 
     * @param id 薪资ID
     * @return 薪资
     */
    public FanSalary selectFanSalaryById(Long id);

    /**
     * 查询薪资列表
     * 
     * @param fanSalary 薪资
     * @return 薪资集合
     */
    public List<FanSalary> selectFanSalaryList(FanSalary fanSalary);

    /**
     * 新增薪资
     * 
     * @param fanSalary 薪资
     * @return 结果
     */
    public int insertFanSalary(FanSalary fanSalary);

    /**
     * 修改薪资
     * 
     * @param fanSalary 薪资
     * @return 结果
     */
    public int updateFanSalary(FanSalary fanSalary);

    /**
     * 删除薪资
     * 
     * @param id 薪资ID
     * @return 结果
     */
    public int deleteFanSalaryById(Long id);

    /**
     * 批量删除薪资
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFanSalaryByIds(String[] ids);
}
