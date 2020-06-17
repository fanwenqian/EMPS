package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.FanSalary;
import com.ruoyi.system.service.IAddSalaryService;
import com.ruoyi.system.service.IFanSalaryService;
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
import com.ruoyi.system.domain.FanEmployee;
import com.ruoyi.system.service.IFanEmployeeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 查询员工Controller
 * 
 * @author wqfan
 * @date 2020-04-15
 */
@Controller
@RequestMapping("/system/employee")
public class FanEmployeeController extends BaseController
{
    private String prefix = "system/employee";

    @Autowired
    private IFanEmployeeService fanEmployeeService;

    @Autowired
    private IAddSalaryService iAddSalaryService;

    @Autowired
    private IFanSalaryService iFanSalaryService;

    @RequiresPermissions("system:employee:view")
    @GetMapping()
    public String employee()
    {
        return prefix + "/employee";
    }

     /**
     * 查询查询员工列表
     */
    @RequiresPermissions("system:employee:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FanEmployee fanEmployee)
    {
        startPage();
        List<FanEmployee> list = fanEmployeeService.selectFanEmployeeList(fanEmployee);
        return getDataTable(list);
    }

    /**
     * 导出查询员工列表
     */
    @RequiresPermissions("system:employee:export")
    @Log(title = "查询员工", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FanEmployee fanEmployee)
    {
        List<FanEmployee> list = fanEmployeeService.selectFanEmployeeList(fanEmployee);
        ExcelUtil<FanEmployee> util = new ExcelUtil<FanEmployee>(FanEmployee.class);
        return util.exportExcel(list, "employee");
    }

    /**
     * 新增员工
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工
     */
    @RequiresPermissions("system:employee:add")
    @Log(title = "查询员工", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FanEmployee fanEmployee)
    {
        int i = fanEmployeeService.insertFanEmployee(fanEmployee);
        iAddSalaryService.insertIntoSalary(fanEmployee);
        return toAjax(i);
    }

    /**
     * 修改员工
     */
    @GetMapping("/edit/{empId}")
    public String edit(@PathVariable("empId") Long empId, ModelMap mmap)
    {
        FanEmployee fanEmployee = fanEmployeeService.selectFanEmployeeById(empId);
        mmap.put("fanEmployee", fanEmployee);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工
     */
    @RequiresPermissions("system:employee:edit")
    @Log(title = "查询员工", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FanEmployee fanEmployee)
    {
        return toAjax(fanEmployeeService.updateFanEmployee(fanEmployee));
    }

    /**
     * 删除员工
     */
    @RequiresPermissions("system:employee:remove")
    @Log(title = "查询员工", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        String[] strArray = Convert.toStrArray(ids);
        for(String empId:strArray){
            FanSalary salary=new FanSalary();
            salary.setEmpId(Long.valueOf(empId));
            List<FanSalary> fanSalaries = iFanSalaryService.selectFanSalaryList(salary);
            for (FanSalary fanSalary:fanSalaries){
                Long id = fanSalary.getId();
                iFanSalaryService.deleteFanSalaryById(id);
            }
        }
        return toAjax(fanEmployeeService.deleteFanEmployeeByIds(ids));
    }
}
