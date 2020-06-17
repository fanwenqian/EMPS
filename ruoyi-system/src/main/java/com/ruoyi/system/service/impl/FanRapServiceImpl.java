package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.FanRap;
import com.ruoyi.system.mapper.FanRapMapper;
import com.ruoyi.system.service.IFanRapService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 奖惩Service业务层处理
 * 
 * @author fan
 * @date 2020-04-19
 */
@Service
public class FanRapServiceImpl implements IFanRapService 
{
    @Resource
    private FanRapMapper fanRapMapper;

    /**
     * 查询奖惩
     * 
     * @param rapId 奖惩ID
     * @return 奖惩
     */
    @Override
    public FanRap selectFanRapById(Long rapId)
    {
        return fanRapMapper.selectFanRapById(rapId);
    }

    /**
     * 查询奖惩列表
     * 
     * @param fanRap 奖惩
     * @return 奖惩
     */
    @Override
    public List<FanRap> selectFanRapList(FanRap fanRap)
    {
        return fanRapMapper.selectFanRapList(fanRap);
    }

    /**
     * 新增奖惩
     * @param fanRap 奖惩
     * @return 结果
     */
    @Override
    public int insertFanRap(FanRap fanRap)
    {
        return fanRapMapper.insertFanRap(fanRap);
    }

    /**
     * 修改奖惩
     * 
     * @param fanRap 奖惩
     * @return 结果
     */
    @Override
    public int updateFanRap(FanRap fanRap)
    {
        return fanRapMapper.updateFanRap(fanRap);
    }

    /**
     * 删除奖惩对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFanRapByIds(String ids)
    {
        return fanRapMapper.deleteFanRapByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除奖惩信息
     * 
     * @param rapId 奖惩ID
     * @return 结果
     */
    @Override
    public int deleteFanRapById(Long rapId)
    {
        return fanRapMapper.deleteFanRapById(rapId);
    }
}
