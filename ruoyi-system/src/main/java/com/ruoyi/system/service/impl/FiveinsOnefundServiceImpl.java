package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.FiveinsOnefundMapper;
import com.ruoyi.system.domain.FiveinsOnefund;
import com.ruoyi.system.service.IFiveinsOnefundService;
import com.ruoyi.common.core.text.Convert;

import javax.annotation.Resource;

/**
 * 五险一金查询Service业务层处理
 * 
 * @author fan
 * @date 2020-04-17
 */
@Service
public class FiveinsOnefundServiceImpl implements IFiveinsOnefundService 
{
    @Resource
    private FiveinsOnefundMapper fiveinsOnefundMapper;

    /**
     * 查询五险一金查询
     * 
     * @param id 五险一金查询ID
     * @return 五险一金查询
     */
    @Override
    public FiveinsOnefund selectFiveinsOnefundById(Long id)
    {
        return fiveinsOnefundMapper.selectFiveinsOnefundById(id);
    }

    /**
     * 查询五险一金查询列表
     * 
     * @param fiveinsOnefund 五险一金查询
     * @return 五险一金查询
     */
    @Override
    public List<FiveinsOnefund> selectFiveinsOnefundList(FiveinsOnefund fiveinsOnefund)
    {
        return fiveinsOnefundMapper.selectFiveinsOnefundList(fiveinsOnefund);
    }

    /**
     * 新增五险一金查询
     * 
     * @param fiveinsOnefund 五险一金查询
     * @return 结果
     */
    @Override
    public int insertFiveinsOnefund(FiveinsOnefund fiveinsOnefund)
    {
        return fiveinsOnefundMapper.insertFiveinsOnefund(fiveinsOnefund);
    }

    /**
     * 修改五险一金查询
     * 
     * @param fiveinsOnefund 五险一金查询
     * @return 结果
     */
    @Override
    public int updateFiveinsOnefund(FiveinsOnefund fiveinsOnefund)
    {
        return fiveinsOnefundMapper.updateFiveinsOnefund(fiveinsOnefund);
    }

    /**
     * 删除五险一金查询对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFiveinsOnefundByIds(String ids)
    {
        return fiveinsOnefundMapper.deleteFiveinsOnefundByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除五险一金查询信息
     * 
     * @param id 五险一金查询ID
     * @return 结果
     */
    @Override
    public int deleteFiveinsOnefundById(Long id)
    {
        return fiveinsOnefundMapper.deleteFiveinsOnefundById(id);
    }
}
