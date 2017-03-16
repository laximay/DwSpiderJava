package org.dwSpider.web;


import org.dwSpider.dto.CasDto;
import org.dwSpider.entity.CasProdecut;
import org.dwSpider.service.CasProdecutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by wenjing on 2017/2/3.
 */
@Controller
@RequestMapping("/cas")//url:/模块/资源/{id}/细分（方法）
public class CasController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CasProdecutService casProdecutService;

    private int DefLimit = 20;//默认页面显示条目数

    /**
     * 根据名称或者编号查询产品
     *
     * @param searchArgs
     * @return
     */
    @RequestMapping(value = "/findCas", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    //加入produces可以防止乱码！！
    @ResponseBody //自动封装成json
    public CasDto findCas(String searchArgs, int pageNo) {
        String newArgs = "%" + searchArgs + "%";
        int Limit = pageNo * DefLimit;
        int offet = Limit - DefLimit;
        int AllCount = casProdecutService.getCasListCount(newArgs);
        if (Limit > AllCount) {
            return new CasDto(CasDto.FAIL, "bottom！！");
        } else {
            List<CasProdecut> casProdecuts = casProdecutService.queryByNameAndNo(newArgs, offet, DefLimit);
            return new CasDto(CasDto.SUCCESS, "ok", casProdecuts);
        }


    }


}
