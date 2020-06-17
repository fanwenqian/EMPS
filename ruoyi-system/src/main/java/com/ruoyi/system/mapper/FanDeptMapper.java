package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FanDept;

/**
 * 部门查询Mapper接口
 * 
 * @author wqfan
 * @date 2020-04-16
 */
public interface FanDeptMapper 
{
    /**
     * 查询部门查询
     * 
     * @param deptId 部门查询ID
     * @return 部门查询
     */
    public FanDept selectFanDeptById(Long deptId);

    /**
     * 查询部门查询列表
     * 
     * @param fanDept 部门查询
     * @return 部门查询集合
     */
    public List<FanDept> selectFanDeptList(FanDept fanDept);

    /**
     * 新增部门查询
     * 
     * @param fanDept 部门查询
     * @return 结果
     */
    public int insertFanDept(FanDept fanDept);

    /**
     * 修改部门查询
     * 
     * @param fanDept 部门查询
     * @return 结果
     */
    public int updateFanDept(FanDept fanDept);

    /**
     * 删除部门查询
     * 
     * @param deptId 部门查询ID
     * @return 结果
     */
    public int deleteFanDeptById(Long deptId);

    /**
     * 批量删除部门查询
     * 
     * @param deptIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteFanDeptByIds(String[] deptIds);
}
