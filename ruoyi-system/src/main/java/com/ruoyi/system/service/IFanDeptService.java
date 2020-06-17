package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FanDept;

/**
 * 部门查询Service接口
 * 
 * @author wqfan
 * @date 2020-04-16
 */
public interface IFanDeptService 
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
     * 批量删除部门查询
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFanDeptByIds(String ids);

    /**
     * 删除部门查询信息
     * 
     * @param deptId 部门查询ID
     * @return 结果
     */
    public int deleteFanDeptById(Long deptId);
}
