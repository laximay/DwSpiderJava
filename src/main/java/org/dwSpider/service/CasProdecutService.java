package org.dwSpider.service;

import org.apache.ibatis.annotations.Param;
import org.dwSpider.entity.CasProdecut;

import java.util.List;

/**
 * Created by wenjing on 2017/3/14.
 */
public interface CasProdecutService {

    /**
     * 查询编号或者名称
     *
     * @param searchArgs
     * @return
     */
    List<CasProdecut> queryByNameAndNo(String searchArgs, int offet, int limit);

    /**
     * 查询所有产品
     *
     * @param offet
     * @param limit
     * @return
     */
    List<CasProdecut> queryAll(int offet, int limit);

    /**
     * 查询产品列表的总行数
     * @param searchArgs
     * @return
     */
    int getCasListCount(String searchArgs);
}
