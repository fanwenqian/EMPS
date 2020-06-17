package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.FanAttendance;

/**
 * 考勤Service接口
 * 
 * @author ruoyi
 * @date 2020-04-19
 */
public interface IFanAttendanceService 
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
    int updateFanAttendance(FanAttendance fanAttendance);

    /**
     * 批量删除考勤
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFanAttendanceByIds(String ids);

    /**
     * 删除考勤信息
     * 
     * @param attendanceId 考勤ID
     * @return 结果
     */
    public int deleteFanAttendanceById(Long attendanceId);
}
