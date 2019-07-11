package com.lcg.serviceribbon.controller;

import com.lcg.serviceribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: licg
 * @Date: 2019/7/9
 * @Description：
 */

@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;


    @GetMapping("/a")
    public String a(){
        return ribbonService.service();
    }
}