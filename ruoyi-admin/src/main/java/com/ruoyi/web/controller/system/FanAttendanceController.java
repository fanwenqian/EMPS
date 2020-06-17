package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.service.ISumSalaryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.FanAttendance;
import com.ruoyi.system.service.IFanAttendanceService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 考勤Controller
 * 
 * @author fan
 * @date 2020-04-19
 */
@Controller
@RequestMapping("/system/attendance")
public class FanAttendanceController extends BaseController
{
    private String prefix = "system/attendance";

    @Autowired
    private IFanAttendanceService fanAttendanceService;
    @Autowired
    private ISumSalaryService iSumSalaryService;

    @RequiresPermissions("system:attendance:view")
    @GetMapping()
    public String attendance()
    {
        return prefix + "/attendance";
    }

    /**
     * 查询考勤列表
     */
    @RequiresPermissions("system:attendance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FanAttendance fanAttendance)
    {
        startPage();
        List<FanAttendance> list = fanAttendanceService.selectFanAttendanceList(fanAttendance);
        return getDataTable(list);
    }

    /**
     * 导出考勤列表
     */
    @RequiresPermissions("system:attendance:export")
    @Log(title = "考勤", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FanAttendance fanAttendance)
    {
        List<FanAttendance> list = fanAttendanceService.selectFanAttendanceList(fanAttendance);
        ExcelUtil<FanAttendance> util = new ExcelUtil<FanAttendance>(FanAttendance.class);
        return util.exportExcel(list, "attendance");
    }

    /**
     * 新增考勤
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存考勤
     */
    @RequiresPermissions("system:attendance:add")
    @Log(title = "考勤", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FanAttendance fanAttendance)
    {
        int i = fanAttendanceService.insertFanAttendance(fanAttendance);
        iSumSalaryService.updateSalaryAtten(fanAttendance);
        return toAjax(i);
    }

    /**
     * 修改考勤
     */
    @GetMapping("/edit/{attendanceId}")
    public String edit(@PathVariable("attendanceId") Long attendanceId, ModelMap mmap)
    {
        FanAttendance fanAttendance = fanAttendanceService.selectFanAttendanceById(attendanceId);
        mmap.put("fanAttendance", fanAttendance);
        return prefix + "/edit";
    }

    /**
     * 修改保存考勤
     */
    @RequiresPermissions("system:attendance:edit")
    @Log(title = "考勤", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FanAttendance fanAttendance)
    {
        int i = fanAttendanceService.updateFanAttendance(fanAttendance);
        iSumSalaryService.updateSalaryAtten(fanAttendance);
        return toAjax(i);
    }

    /**
     * 删除考勤
     */
    @RequiresPermissions("system:attendance:remove")
    @Log(title = "考勤", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        FanAttendance attendance=new FanAttendance();
        String[] strArray = Convert.toStrArray(ids);
        for (String id:strArray){
            FanAttendance fanAttendance = fanAttendanceService.selectFanAttendanceById(Long.valueOf(id));
            attendance.setEmpId(fanAttendance.getEmpId());
            attendance.setLate(0L);
            attendance.setEarly(0L);
            attendance.setAskForLeave(0L);
            attendance.setAbsenteeism(0L);
            iSumSalaryService.updateSalaryAtten(attendance);
        }
        return toAjax(fanAttendanceService.deleteFanAttendanceByIds(ids));
    }
}
