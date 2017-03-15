package org.dwSpider.service.impl;

import org.dwSpider.dao.CasProdecutDao;
import org.dwSpider.entity.CasProdecut;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wenjing on 2017/3/14.
 */
//配置spring和junit整合，junit启动加载springIOC容器，spring-test,junit
@RunWith(SpringJUnit4ClassRunner.class)
//spring配置文件路径
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class CasProdecutServiceImplTest {
    @Resource
    private CasProdecutDao casProdecutDao;
    @Test
    public void queryByNameAndNo() throws Exception {
        List<CasProdecut> casProdecut = casProdecutDao.queryByNameAndNo("%99631%");
        System.out.println(casProdecut);

    }

//    @Test
//    public void queryAll() throws Exception {
//        List<CasProdecut> casProdecuts = casProdecutDao.queryAll(0, 100);
//        casProdecuts.forEach((casProdecut)->System.out.println(casProdecut));
//    }

}