package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 奖惩对象 fan_rap
 * 
 * @author fan
 * @date 2020-04-19
 */
public class FanRap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 奖惩id */
    private Long rapId;

    /** 奖惩员工id */
    @Excel(name = "奖惩员工id")
    private Long empId;

    /** 奖惩类型 */
    @Excel(name = "奖惩类型")
    private String rapType;

    /** 奖惩信息 */
    @Excel(name = "奖惩信息")
    private String rapMessage;

    /** 奖惩金额 */
    @Excel(name = "奖惩金额")
    private Long rapMoney;

    public void setRapId(Long rapId) 
    {
        this.rapId = rapId;
    }

    public Long getRapId() 
    {
        return rapId;
    }
    public void setEmpId(Long empId) 
    {
        this.empId = empId;
    }

    public Long getEmpId() 
    {
        return empId;
    }
    public void setRapType(String rapType) 
    {
        this.rapType = rapType;
    }

    public String getRapType() 
    {
        return rapType;
    }
    public void setRapMessage(String rapMessage) 
    {
        this.rapMessage = rapMessage;
    }

    public String getRapMessage() 
    {
        return rapMessage;
    }
    public void setRapMoney(Long rapMoney) 
    {
        this.rapMoney = rapMoney;
    }

    public Long getRapMoney() 
    {
        return rapMoney;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("rapId", getRapId())
            .append("empId", getEmpId())
            .append("rapType", getRapType())
            .append("rapMessage", getRapMessage())
            .append("rapMoney", getRapMoney())
            .toString();
    }
}
