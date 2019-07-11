package com.lcg.servicefeign.controller;

import com.lcg.servicefeign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: licg
 * @Date: 2019/7/9
 * @Description：
 * Feign：
 * 1. 采用基于接口的注解形式
 * 2. 默认集成Ribbon，具有负载均衡
 * 3. 和eureka整合
 */

@RestController
public class FeignController {
    @Autowired
    private FeignService feignService;

    @GetMapping("/a")
    public String getFromClient(){
        return feignService.getFromClientOne();
    }
}