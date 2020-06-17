package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FanAttendance;

/**
 * 考勤Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-19
 */
public interface FanAttendanceMapper 
{
    /**
     * 查询考勤
     * 
     * @param attendanceId 考勤ID
     * @return 考勤
     */
    public FanAttendance selectFanAttendanceById(Long attendanceId);

    /**
     * 查询考勤列表
     * 
     * @param fanAttendance 考勤
     * @return 考勤集合
     */
    public List<FanAttendance> selectFanAttendanceList(FanAttendance fanAttendance);

    /**
     * 新增考勤
     * 
     * @param fanAttendance 考勤
     * @return 结果
     */
    public int insertFanAttendance(FanAttendance fanAttendance);

    /**
     * 修改考勤
     * 
     * @param fanAttendance 考勤
     * @return 结果
     */
    public int updateFanAttendance(FanAttendance fanAttendance);

    /**
     * 删除考勤
     * 
     * @param attendanceId 考勤ID
     * @return 结果
     */
    public int deleteFanAttendanceById(Long attendanceId);

    /**
     * 批量删除考勤
     * 
     * @param attendanceIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteFanAttendanceByIds(String[] attendanceIds);
}
