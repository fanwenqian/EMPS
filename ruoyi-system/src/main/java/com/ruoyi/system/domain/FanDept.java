package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 部门查询对象 fan_dept
 * 
 * @author wqfan
 * @date 2020-04-16
 */
public class FanDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 部门id */
    @Excel(name = "部门id")
    private Long deptId;

    /** 部门名 */
    @Excel(name = "部门名")
    private String deptName;

    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setDeptName(String deptName) 
    {
        this.deptName = deptName;
    }

    public String getDeptName() 
    {
        return deptName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .toString();
    }
}
