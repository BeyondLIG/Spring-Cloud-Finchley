package com.lcg.servicefeign.service;

import org.springframework.stereotype.Component;

/**
 * @Author: licg
 * @Date: 2019/7/9
 * @Description：
 */

@Component
public class FeignServiceHystrix implements FeignService {
    @Override
    public String getFromClientOne() {
        return "error";
    }
}