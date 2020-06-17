package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.FanAttendance;
import com.ruoyi.system.service.IFanSalaryService;
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
import com.ruoyi.system.domain.FanRap;
import com.ruoyi.system.service.IFanRapService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 奖惩Controller
 * 
 * @author fan
 * @date 2020-04-19
 */
@Controller
@RequestMapping("/system/rap")
public class FanRapController extends BaseController
{
    private String prefix = "system/rap";

    @Autowired
    private IFanRapService fanRapService;
    @Autowired
    private ISumSalaryService iSumSalaryService;

    @RequiresPermissions("system:rap:view")
    @GetMapping()
    public String rap()
    {
        return prefix + "/rap";
    }

    /**
     * 查询奖惩列表
     */
    @RequiresPermissions("system:rap:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FanRap fanRap)
    {
        startPage();
        List<FanRap> list = fanRapService.selectFanRapList(fanRap);
        return getDataTable(list);
    }

    /**
     * 导出奖惩列表
     */
    @RequiresPermissions("system:rap:export")
    @Log(title = "奖惩", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FanRap fanRap)
    {
        List<FanRap> list = fanRapService.selectFanRapList(fanRap);
        ExcelUtil<FanRap> util = new ExcelUtil<FanRap>(FanRap.class);
        return util.exportExcel(list, "rap");
    }

    /**
     * 新增奖惩
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存奖惩
     */
    @RequiresPermissions("system:rap:add")
    @Log(title = "奖惩", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FanRap fanRap)
    {
        int i = fanRapService.insertFanRap(fanRap);
        iSumSalaryService.updateSalaryRap(fanRap);
        return toAjax(i);
    }

    /**
     * 修改奖惩
     */
    @GetMapping("/edit/{rapId}")
    public String edit(@PathVariable("rapId") Long rapId, ModelMap mmap)
    {
        FanRap fanRap = fanRapService.selectFanRapById(rapId);
        mmap.put("fanRap", fanRap);
        return prefix + "/edit";
    }

    /**
     * 修改保存奖惩
     */
    @RequiresPermissions("system:rap:edit")
    @Log(title = "奖惩", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FanRap fanRap)
    {
        int i = fanRapService.updateFanRap(fanRap);
        iSumSalaryService.updateSalaryRap(fanRap);
        return toAjax(i);
    }

    /**
     * 删除奖惩
     */
    @RequiresPermissions("system:rap:remove")
    @Log(title = "奖惩", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        int i=0;
        FanRap rap=new FanRap();
        String[] strArray = Convert.toStrArray(ids);
        for (String id:strArray) {
            FanRap fanRap = fanRapService.selectFanRapById(Long.valueOf(id));
            rap.setEmpId(fanRap.getEmpId());
            int j=fanRapService.deleteFanRapByIds(ids);
            iSumSalaryService.updateSalaryRap(fanRap);
            i= i+j;
        }
        return toAjax(i);
    }
}
