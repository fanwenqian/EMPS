package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 薪资对象 fan_salary
 * 
 * @author ruoyi
 * @date 2020-04-19
 */
public class FanSalary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 薪资id */
    private Long id;

    /** 员工id */
    @Excel(name = "员工id")
    private Long empId;

    /** 奖惩金额 */
    @Excel(name = "奖惩金额")
    private Double rapPay;

    /** 考勤扣除 */
    @Excel(name = "考勤扣除")
    private Double attenPay;

    /** 五险扣除 */
    @Excel(name = "五险扣除")
    private Double fiveinsPay;

    /** 基础工资 */
    @Excel(name = "基础工资")
    private Double basePay;

    /** 应发工资 */
    @Excel(name = "应发工资")
    private Double realPay;

    /** 是否发放 */
    @Excel(name = "是否发放")
    private String isPay;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEmpId(Long empId) 
    {
        this.empId = empId;
    }

    public Long getEmpId() 
    {
        return empId;
    }
    public void setRapPay(Double rapPay) 
    {
        this.rapPay = rapPay;
    }

    public Double getRapPay() 
    {
        return rapPay;
    }
    public void setAttenPay(Double attenPay) 
    {
        this.attenPay = attenPay;
    }

    public Double getAttenPay() 
    {
        return attenPay;
    }
    public void setFiveinsPay(Double fiveinsPay) 
    {
        this.fiveinsPay = fiveinsPay;
    }

    public Double getFiveinsPay() 
    {
        return fiveinsPay;
    }
    public void setBasePay(Double basePay) 
    {
        this.basePay = basePay;
    }

    public Double getBasePay() 
    {
        return basePay;
    }
    public void setRealPay(Double realPay) 
    {
        this.realPay = realPay;
    }

    public Double getRealPay() 
    {
        return realPay;
    }
    public void setIsPay(String isPay) 
    {
        this.isPay = isPay;
    }

    public String getIsPay() 
    {
        return isPay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("empId", getEmpId())
            .append("rapPay", getRapPay())
            .append("attenPay", getAttenPay())
            .append("fiveinsPay", getFiveinsPay())
            .append("basePay", getBasePay())
            .append("realPay", getRealPay())
            .append("isPay", getIsPay())
            .toString();
    }
}
