package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.FanAttendance;
import com.ruoyi.system.mapper.FanAttendanceMapper;
import com.ruoyi.system.service.IFanAttendanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 考勤Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-19
 */
@Service
public class FanAttendanceServiceImpl implements IFanAttendanceService 
{
    @Resource
    private FanAttendanceMapper fanAttendanceMapper;

    /**
     * 查询考勤
     * 
     * @param attendanceId 考勤ID
     * @return 考勤
     */
    @Override
    public FanAttendance selectFanAttendanceById(Long attendanceId)
    {
        return fanAttendanceMapper.selectFanAttendanceById(attendanceId);
    }

    /**
     * 查询考勤列表
     * 
     * @param fanAttendance 考勤
     * @return 考勤
     */
    @Override
    public List<FanAttendance> selectFanAttendanceList(FanAttendance fanAttendance)
    {
        return fanAttendanceMapper.selectFanAttendanceList(fanAttendance);
    }

    /**
     * 新增考勤
     * 
     * @param fanAttendance 考勤
     * @return 结果
     */
    @Override
    public int insertFanAttendance(FanAttendance fanAttendance)
    {
        fanAttendance.setCreateTime(DateUtils.getNowDate());
        return fanAttendanceMapper.insertFanAttendance(fanAttendance);
    }

    /**
     * 修改考勤
     * 
     * @param fanAttendance 考勤
     * @return 结果
     */
    @Override
    public int updateFanAttendance(FanAttendance fanAttendance)
    {
        fanAttendance.setUpdateTime(DateUtils.getNowDate());
        return fanAttendanceMapper.updateFanAttendance(fanAttendance);
    }

    /**
     * 删除考勤对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFanAttendanceByIds(String ids)
    {
        return fanAttendanceMapper.deleteFanAttendanceByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考勤信息
     * 
     * @param attendanceId 考勤ID
     * @return 结果
     */
    @Override
    public int deleteFanAttendanceById(Long attendanceId)
    {
        return fanAttendanceMapper.deleteFanAttendanceById(attendanceId);
    }
}
