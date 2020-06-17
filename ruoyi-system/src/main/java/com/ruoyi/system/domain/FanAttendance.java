package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 考勤对象 fan_attendance
 * 
 * @author ruoyi
 * @date 2020-04-19
 */
public class FanAttendance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 奖惩id */
    private Long attendanceId;

    /** 员工id */
    @Excel(name = "员工id")
    private Long empId;

    /** 早退 */
    @Excel(name = "早退")
    private Long early;

    /** 旷工 */
    @Excel(name = "旷工")
    private Long absenteeism;

    /** 请假 */
    @Excel(name = "请假")
    private Long askForLeave;

    /** 迟到 */
    @Excel(name = "迟到")
    private Long late;

    public void setAttendanceId(Long attendanceId) 
    {
        this.attendanceId = attendanceId;
    }

    public Long getAttendanceId() 
    {
        return attendanceId;
    }
    public void setEmpId(Long empId) 
    {
        this.empId = empId;
    }

    public Long getEmpId() 
    {
        return empId;
    }
    public void setEarly(Long early) 
    {
        this.early = early;
    }

    public Long getEarly() 
    {
        return early;
    }
    public void setAbsenteeism(Long absenteeism) 
    {
        this.absenteeism = absenteeism;
    }

    public Long getAbsenteeism() 
    {
        return absenteeism;
    }
    public void setAskForLeave(Long askForLeave) 
    {
        this.askForLeave = askForLeave;
    }

    public Long getAskForLeave() 
    {
        return askForLeave;
    }
    public void setLate(Long late) 
    {
        this.late = late;
    }

    public Long getLate() 
    {
        return late;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("attendanceId", getAttendanceId())
            .append("empId", getEmpId())
            .append("early", getEarly())
            .append("absenteeism", getAbsenteeism())
            .append("askForLeave", getAskForLeave())
            .append("late", getLate())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
