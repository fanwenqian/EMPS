package com.ruoyi.web.controller.system;

import java.util.List;
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
import com.ruoyi.system.domain.FanDept;
import com.ruoyi.system.service.IFanDeptService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 部门查询Controller
 * 
 * @author wqfan
 * @date 2020-04-16
 */
@Controller
@RequestMapping("/system/department")
public class FanDeptController extends BaseController
{
    private String prefix = "system/department";

    @Autowired
    private IFanDeptService fanDeptService;

    @RequiresPermissions("system:department:view")
    @GetMapping()
    public String department()
    {
        return prefix + "/department";
    }

    /**
     * 查询部门查询列表
     */
    @RequiresPermissions("system:department:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FanDept fanDept)
    {
        startPage();
        List<FanDept> list = fanDeptService.selectFanDeptList(fanDept);
        return getDataTable(list);
    }

    /**
     * 导出部门查询列表
     */
    @RequiresPermissions("system:department:export")
    @Log(title = "部门查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FanDept fanDept)
    {
        List<FanDept> list = fanDeptService.selectFanDeptList(fanDept);
        ExcelUtil<FanDept> util = new ExcelUtil<FanDept>(FanDept.class);
        return util.exportExcel(list, "department");
    }

    /**
     * 新增部门查询
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存部门查询
     */
    @RequiresPermissions("system:department:add")
    @Log(title = "部门查询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FanDept fanDept)
    {
        return toAjax(fanDeptService.insertFanDept(fanDept));
    }

    /**
     * 修改部门查询
     */
    @GetMapping("/edit/{deptId}")
    public String edit(@PathVariable("deptId") Long deptId, ModelMap mmap)
    {
        FanDept fanDept = fanDeptService.selectFanDeptById(deptId);
        mmap.put("fanDept", fanDept);
        return prefix + "/edit";
    }

    /**
     * 修改保存部门查询
     */
    @RequiresPermissions("system:department:edit")
    @Log(title = "部门查询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FanDept fanDept)
    {
        return toAjax(fanDeptService.updateFanDept(fanDept));
    }

    /**
     * 删除部门查询
     */
    @RequiresPermissions("system:department:remove")
    @Log(title = "部门查询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fanDeptService.deleteFanDeptByIds(ids));
    }
}
