package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.FiveinsOnefund;

/**
 * 五险一金查询Mapper接口
 * 
 * @author fan
 * @date 2020-04-17
 */
public interface FiveinsOnefundMapper 
{
    /**
     * 查询五险一金查询
     * 
     * @param id 五险一金查询ID
     * @return 五险一金查询
     */
    public FiveinsOnefund selectFiveinsOnefundById(Long id);

    /**
     * 查询五险一金查询列表
     * 
     * @param fiveinsOnefund 五险一金查询
     * @return 五险一金查询集合
     */
    public List<FiveinsOnefund> selectFiveinsOnefundList(FiveinsOnefund fiveinsOnefund);

    /**
     * 新增五险一金查询
     * 
     * @param fiveinsOnefund 五险一金查询
     * @return 结果
     */
    public int insertFiveinsOnefund(FiveinsOnefund fiveinsOnefund);

    /**
     * 修改五险一金查询
     * 
     * @param fiveinsOnefund 五险一金查询
     * @return 结果
     */
    public int updateFiveinsOnefund(FiveinsOnefund fiveinsOnefund);

    /**
     * 删除五险一金查询
     * 
     * @param id 五险一金查询ID
     * @return 结果
     */
    public int deleteFiveinsOnefundById(Long id);

    /**
     * 批量删除五险一金查询
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFiveinsOnefundByIds(String[] ids);
}
