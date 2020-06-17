package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FanRap;

/**
 * 奖惩Mapper接口
 * 
 * @author fan
 * @date 2020-04-19
 */
public interface FanRapMapper 
{
    /**
     * 查询奖惩
     * 
     * @param rapId 奖惩ID
     * @return 奖惩
     */
    public FanRap selectFanRapById(Long rapId);

    /**
     * 查询奖惩列表
     * 
     * @param fanRap 奖惩
     * @return 奖惩集合
     */
    public List<FanRap> selectFanRapList(FanRap fanRap);

    /**
     * 新增奖惩
     * 
     * @param fanRap 奖惩
     * @return 结果
     */
    public int insertFanRap(FanRap fanRap);

    /**
     * 修改奖惩
     * 
     * @param fanRap 奖惩
     * @return 结果
     */
    public int updateFanRap(FanRap fanRap);

    /**
     * 删除奖惩
     * 
     * @param rapId 奖惩ID
     * @return 结果
     */
    public int deleteFanRapById(Long rapId);

    /**
     * 批量删除奖惩
     * 
     * @param rapIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteFanRapByIds(String[] rapIds);
}
