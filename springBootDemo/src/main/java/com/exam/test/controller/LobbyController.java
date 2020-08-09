package com.exam.test.controller;

import com.exam.test.common.AjaxFilter;
import com.exam.test.service.LobbyService;
import com.exam.test.vo.Menu;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tga")
public class LobbyController {
    @Autowired
    private LobbyService lobbyService;
    RestControllerHelper helper = new RestControllerHelper();
    private static Logger logger = LoggerFactory.getLogger(AjaxFilter.class);

    @RequestMapping(value = "/menus")
    public Object findAllMenu(){
        System.out.println(lobbyService.findAllMenu());
        List<Menu> menu = lobbyService.findAllMenu();
//        logger.info(String.valueOf(menu));
        helper.setCode(RestControllerHelper.SUCCESS);
        helper.setMsg("查找菜单成功");
        helper.setMsg("查找菜单成功");
        helper.setData(menu);
        return helper.toJsonMap();
    }

}
