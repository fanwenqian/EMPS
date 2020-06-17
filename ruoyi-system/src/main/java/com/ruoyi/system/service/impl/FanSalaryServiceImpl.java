package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FanSalaryMapper;
import com.ruoyi.system.domain.FanSalary;
import com.ruoyi.system.service.IFanSalaryService;
import com.ruoyi.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 薪资Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-19
 */
@Service
public class FanSalaryServiceImpl implements IFanSalaryService 
{
    @Resource
    private FanSalaryMapper fanSalaryMapper;

    /**
     * 查询薪资
     * 
     * @param id 薪资ID
     * @return 薪资
     */
    @Override
    public FanSalary selectFanSalaryById(Long id)
    {
        return fanSalaryMapper.selectFanSalaryById(id);
    }

    /**
     * 查询薪资列表
     * 
     * @param fanSalary 薪资
     * @return 薪资
     */
    @Override
    public List<FanSalary> selectFanSalaryList(FanSalary fanSalary)
    {
        return fanSalaryMapper.selectFanSalaryList(fanSalary);
    }

    /**
     * 新增薪资
     * 
     * @param fanSalary 薪资
     * @return 结果
     */
    @Override
    public int insertFanSalary(FanSalary fanSalary)
    {
        return fanSalaryMapper.insertFanSalary(fanSalary);
    }

    /**
     * 修改薪资
     * 
     * @param fanSalary 薪资
     * @return 结果
     */
    @Override
    public int updateFanSalary(FanSalary fanSalary)
    {
        return fanSalaryMapper.updateFanSalary(fanSalary);
    }

    /**
     * 删除薪资对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFanSalaryByIds(String ids)
    {
        return fanSalaryMapper.deleteFanSalaryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除薪资信息
     * 
     * @param id 薪资ID
     * @return 结果
     */
    @Override
    public int deleteFanSalaryById(Long id)
    {
        return fanSalaryMapper.deleteFanSalaryById(id);
    }
}
