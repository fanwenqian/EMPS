package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 五险一金查询对象 fiveins_onefund
 * 
 * @author fan
 * @date 2020-04-17
 */
public class FiveinsOnefund extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 五险一金id */
    private Long id;

    /** 员工id */
    @Excel(name = "员工id")
    private Long empId;

    /** 养老保险 */
    @Excel(name = "养老保险")
    private Long endowmentIns;

    /** 医疗保险 */
    @Excel(name = "医疗保险")
    private Long medicalIns;

    /** 失业保险 */
    @Excel(name = "失业保险")
    private Long unemploymentIns;

    /** 工伤保险 */
    @Excel(name = "工伤保险")
    private Long empInjuryIns;

    /** 生育保险 */
    @Excel(name = "生育保险")
    private Long maternityIns;

    /** 住房公积金 */
    @Excel(name = "住房公积金")
    private Long housingFund;

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
    public void setEndowmentIns(Long endowmentIns) 
    {
        this.endowmentIns = endowmentIns;
    }

    public Long getEndowmentIns() 
    {
        return endowmentIns;
    }
    public void setMedicalIns(Long medicalIns) 
    {
        this.medicalIns = medicalIns;
    }

    public Long getMedicalIns() 
    {
        return medicalIns;
    }
    public void setUnemploymentIns(Long unemploymentIns) 
    {
        this.unemploymentIns = unemploymentIns;
    }

    public Long getUnemploymentIns() 
    {
        return unemploymentIns;
    }
    public void setEmpInjuryIns(Long empInjuryIns) 
    {
        this.empInjuryIns = empInjuryIns;
    }

    public Long getEmpInjuryIns() 
    {
        return empInjuryIns;
    }
    public void setMaternityIns(Long maternityIns) 
    {
        this.maternityIns = maternityIns;
    }

    public Long getMaternityIns() 
    {
        return maternityIns;
    }
    public void setHousingFund(Long housingFund) 
    {
        this.housingFund = housingFund;
    }

    public Long getHousingFund() 
    {
        return housingFund;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("empId", getEmpId())
            .append("endowmentIns", getEndowmentIns())
            .append("medicalIns", getMedicalIns())
            .append("unemploymentIns", getUnemploymentIns())
            .append("empInjuryIns", getEmpInjuryIns())
            .append("maternityIns", getMaternityIns())
            .append("housingFund", getHousingFund())
            .toString();
    }
}
