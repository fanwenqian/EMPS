package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FanDeptMapper;
import com.ruoyi.system.domain.FanDept;
import com.ruoyi.system.service.IFanDeptService;
import com.ruoyi.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 部门查询Service业务层处理
 * 
 * @author wqfan
 * @date 2020-04-16
 */
@Service
public class FanDeptServiceImpl implements IFanDeptService 
{
    @Resource
    private FanDeptMapper fanDeptMapper;

    /**
     * 查询部门查询
     * 
     * @param deptId 部门查询ID
     * @return 部门查询
     */
    @Override
    public FanDept selectFanDeptById(Long deptId)
    {
        return fanDeptMapper.selectFanDeptById(deptId);
    }

    /**
     * 查询部门查询列表
     * 
     * @param fanDept 部门查询
     * @return 部门查询
     */
    @Override
    public List<FanDept> selectFanDeptList(FanDept fanDept)
    {
        return fanDeptMapper.selectFanDeptList(fanDept);
    }

    /**
     * 新增部门查询
     * 
     * @param fanDept 部门查询
     * @return 结果
     */
    @Override
    public int insertFanDept(FanDept fanDept)
    {
        return fanDeptMapper.insertFanDept(fanDept);
    }

    /**
     * 修改部门查询
     * 
     * @param fanDept 部门查询
     * @return 结果
     */
    @Override
    public int updateFanDept(FanDept fanDept)
    {
        return fanDeptMapper.updateFanDept(fanDept);
    }

    /**
     * 删除部门查询对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFanDeptByIds(String ids)
    {
        return fanDeptMapper.deleteFanDeptByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除部门查询信息
     * 
     * @param deptId 部门查询ID
     * @return 结果
     */
    @Override
    public int deleteFanDeptById(Long deptId)
    {
        return fanDeptMapper.deleteFanDeptById(deptId);
    }
}
