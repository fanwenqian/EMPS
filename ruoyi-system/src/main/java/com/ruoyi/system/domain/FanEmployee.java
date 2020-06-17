package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工对象 fan_employee
 * 
 * @author wqfan
 * @date 2020-04-15
 */
public class FanEmployee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 员工id */
    @Excel(name = "员工id")
    private Long empId;

    /** 员工姓名 */
    @Excel(name = "员工姓名")
    private String empName;

    /** 身份信息 */
    @Excel(name = "身份信息")
    private String empIdcard;

    /** 性别(0男1女2未知) */
    @Excel(name = "性别(0男1女2未知)")
    private String empGender;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String empPhone;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String empEmail;

    /** 在职状态(0离职，1在职) */
    @Excel(name = "在职状态(0离职，1在职)")
    private String empStatus;

    /** 删除标签（0存在，1删除） */
    @Excel(name = "删除标签", readConverterExp = "0=存在，1删除")
    private String empDelflag;

    /**员工所在部门id*/
    @Excel(name = "所在部门id")
    private Long deptId;

    /**员工所在部门名称*/
    @Excel(name = "所在部门名称")
    private String deptName;

    @Override
    public String toString() {
        return "FanEmployee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empIdcard='" + empIdcard + '\'' +
                ", empGender='" + empGender + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empEmail='" + empEmail + '\'' +
                ", empStatus='" + empStatus + '\'' +
                ", empDelflag='" + empDelflag + '\'' +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setEmpId(Long empId)
    {
        this.empId = empId;
    }

    public Long getEmpId() 
    {
        return empId;
    }
    public void setEmpName(String empName) 
    {
        this.empName = empName;
    }

    public String getEmpName() 
    {
        return empName;
    }
    public void setEmpIdcard(String empIdcard) 
    {
        this.empIdcard = empIdcard;
    }

    public String getEmpIdcard() 
    {
        return empIdcard;
    }
    public void setEmpGender(String empGender) 
    {
        this.empGender = empGender;
    }

    public String getEmpGender() 
    {
        return empGender;
    }
    public void setEmpPhone(String empPhone) 
    {
        this.empPhone = empPhone;
    }

    public String getEmpPhone() 
    {
        return empPhone;
    }
    public void setEmpEmail(String empEmail) 
    {
        this.empEmail = empEmail;
    }

    public String getEmpEmail() 
    {
        return empEmail;
    }
    public void setEmpStatus(String empStatus) 
    {
        this.empStatus = empStatus;
    }

    public String getEmpStatus() 
    {
        return empStatus;
    }


}
