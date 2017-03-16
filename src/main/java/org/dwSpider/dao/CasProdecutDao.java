package org.dwSpider.dao;

import org.apache.ibatis.annotations.Param;
import org.dwSpider.entity.CasProdecut;

import java.util.List;

/**
 * Created by wenjing on 2017/1/8.
 */
public interface CasProdecutDao {
    /**
     * 查询编号或者名称
     *
     * @param searchArgs
     * @return
     */
    List<CasProdecut> queryByNameAndNo(@Param("searchArgs") String searchArgs, @Param("offet") int offet, @Param("limit") int limit);

    /**
     * 查询所有产品
     *
     * @param offet
     * @param limit
     * @return
     */
    List<CasProdecut> queryAll(@Param("offet") int offet, @Param("limit") int limit);

    int getCasListCount(String searchArgs);



}
