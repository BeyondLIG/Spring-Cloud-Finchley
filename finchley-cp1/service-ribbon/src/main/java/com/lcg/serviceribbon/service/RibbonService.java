package com.lcg.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: licg
 * @Date: 2019/7/9
 * @Description：
 */

/**
 * 断路器 Ribbon：
 * 1. 添加失败方法
 * 2. 添加Hystrix注解
 */

@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String service(){
        return restTemplate.getForObject("http://SERVICE-A/a", String.class);
    }

    public String error(){
        return "error";
    }
}