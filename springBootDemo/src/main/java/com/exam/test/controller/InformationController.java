package com.exam.test.controller;

import com.exam.test.service.InformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/information")
public class InformationController {
    @Autowired
    private InformationService informationService;
    RestControllerHelper helper = new RestControllerHelper();

    @RequestMapping("/select/account")
    public Map<String,Object> findUserById(@RequestParam String projectId) {
        helper.setCode(RestControllerHelper.SUCCESS);
        helper.setMsg("success");
        helper.setData(informationService.selectAcount(projectId)) ;
        return helper.toJsonMap();
    }


}
