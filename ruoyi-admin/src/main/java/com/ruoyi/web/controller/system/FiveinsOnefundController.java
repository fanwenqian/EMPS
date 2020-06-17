package com.ruoyi.web.controller.system;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.FiveinsOnefund;
import com.ruoyi.system.service.IFiveinsOnefundService;
import com.ruoyi.system.service.ISumSalaryService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 五险一金查询Controller
 * 
 * @author fan
 * @date 2020-04-17
 */
@Controller
@RequestMapping("/system/onefund")
public class FiveinsOnefundController extends BaseController
{
    private String prefix = "system/onefund";

    @Autowired
    private IFiveinsOnefundService fiveinsOnefundService;
    @Autowired
    private ISumSalaryService sumSalaryService;

    @RequiresPermissions("system:onefund:view")
    @GetMapping()
    public String onefund()
    {
        return prefix + "/onefund";
    }

    /**
     * 查询五险一金查询列表
     */
    @RequiresPermissions("system:onefund:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FiveinsOnefund fiveinsOnefund)
    {
        startPage();
        List<FiveinsOnefund> list = fiveinsOnefundService.selectFiveinsOnefundList(fiveinsOnefund);
        return getDataTable(list);
    }

    /**
     * 导出五险一金查询列表
     */
    @RequiresPermissions("system:onefund:export")
    @Log(title = "五险一金查询", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FiveinsOnefund fiveinsOnefund)
    {
        List<FiveinsOnefund> list = fiveinsOnefundService.selectFiveinsOnefundList(fiveinsOnefund);
        ExcelUtil<FiveinsOnefund> util = new ExcelUtil<FiveinsOnefund>(FiveinsOnefund.class);
        return util.exportExcel(list, "onefund");
    }

    /**
     * 新增五险一金查询
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存五险一金查询
     */
    @RequiresPermissions("system:onefund:add")
    @Log(title = "五险一金查询", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FiveinsOnefund fiveinsOnefund)
    {
        int i = fiveinsOnefundService.insertFiveinsOnefund(fiveinsOnefund);
        sumSalaryService.updateSalaryIns(fiveinsOnefund);
        return toAjax(i);
    }

    /**
     * 修改五险一金查询
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FiveinsOnefund fiveinsOnefund = fiveinsOnefundService.selectFiveinsOnefundById(id);
        mmap.put("fiveinsOnefund", fiveinsOnefund);
        return prefix + "/edit";
    }

    /**
     * 修改保存五险一金查询
     */
    @RequiresPermissions("system:onefund:edit")
    @Log(title = "五险一金查询", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FiveinsOnefund fiveinsOnefund)
    {
        int i = fiveinsOnefundService.updateFiveinsOnefund(fiveinsOnefund);
        sumSalaryService.updateSalaryIns(fiveinsOnefund);
        return toAjax(i);
    }

    /**
     * 删除五险一金查询
     */
    @RequiresPermissions("system:onefund:remove")
    @Log(title = "五险一金查询", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        FiveinsOnefund fiveinsOnefund=new FiveinsOnefund();
        String[] strArray = Convert.toStrArray(ids);
        for (String id:strArray){
            FiveinsOnefund fiveOne =fiveinsOnefundService.selectFiveinsOnefundById(Long.valueOf(id));
            fiveinsOnefund.setEmpId(fiveOne.getEmpId());
            fiveinsOnefund.setEmpInjuryIns(0L);
            fiveinsOnefund.setEndowmentIns(0L);
            fiveinsOnefund.setHousingFund(0L);
            fiveinsOnefund.setMaternityIns(0L);
            fiveinsOnefund.setMedicalIns(0L);
            fiveinsOnefund.setUnemploymentIns(0L);
            sumSalaryService.updateSalaryIns(fiveinsOnefund);
        }
        return toAjax(fiveinsOnefundService.deleteFiveinsOnefundByIds(ids));
    }
}
