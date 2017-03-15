package org.dwSpider.service.impl;

import org.apache.ibatis.annotations.Param;
import org.dwSpider.dao.CasProdecutDao;
import org.dwSpider.entity.CasProdecut;
import org.dwSpider.service.CasProdecutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wenjing on 2017/3/14.
 */
@Service
public class CasProdecutServiceImpl implements CasProdecutService {
    //注入Service依赖
    @Autowired
    private CasProdecutDao casProdecutDao;
    @Override
    public List<CasProdecut> queryByNameAndNo(String searchArgs) {
        return casProdecutDao.queryByNameAndNo(searchArgs);
    }

    @Override
    public List<CasProdecut> queryAll(int offet, int limit) {
        return casProdecutDao.queryAll(offet, limit);
    }
}
