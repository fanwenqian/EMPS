package com.ruoyi.web.controller.system;

import java.util.List;

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
import com.ruoyi.system.domain.FanSalary;
import com.ruoyi.system.service.IFanSalaryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 薪资Controller
 * 
 * @author ruoyi
 * @date 2020-04-19
 */
@Controller
@RequestMapping("/system/salary")
public class FanSalaryController extends BaseController
{
    private String prefix = "system/salary";

    @Autowired
    private IFanSalaryService fanSalaryService;
    @Autowired
    private ISumSalaryService sumSalaryService;

    @RequiresPermissions("system:salary:view")
    @GetMapping()
    public String salary()
    {
        return prefix + "/salary";
    }

    /**
     * 查询薪资列表
     */
    @RequiresPermissions("system:salary:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FanSalary fanSalary)
    {
        startPage();
        List<FanSalary> list = fanSalaryService.selectFanSalaryList(fanSalary);
        sumSalaryService.updateRealSalary(list);
        return getDataTable(list);
    }

    /**
     * 导出薪资列表
     */
    @RequiresPermissions("system:salary:export")
    @Log(title = "薪资", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FanSalary fanSalary)
    {
        List<FanSalary> list = fanSalaryService.selectFanSalaryList(fanSalary);
        ExcelUtil<FanSalary> util = new ExcelUtil<FanSalary>(FanSalary.class);
        return util.exportExcel(list, "salary");
    }

    /**
     * 新增薪资
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存薪资
     */
    @RequiresPermissions("system:salary:add")
    @Log(title = "薪资", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FanSalary fanSalary)
    {
        return toAjax(fanSalaryService.insertFanSalary(fanSalary));
    }

    /**
     * 修改薪资
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FanSalary fanSalary = fanSalaryService.selectFanSalaryById(id);
        mmap.put("fanSalary", fanSalary);
        return prefix + "/edit";
    }

    /**
     * 修改保存薪资
     */
    @RequiresPermissions("system:salary:edit")
    @Log(title = "薪资", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FanSalary fanSalary)
    {
        return toAjax(fanSalaryService.updateFanSalary(fanSalary));
    }

    /**
     * 删除薪资
     */
    @RequiresPermissions("system:salary:remove")
    @Log(title = "薪资", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fanSalaryService.deleteFanSalaryByIds(ids));
    }
}
