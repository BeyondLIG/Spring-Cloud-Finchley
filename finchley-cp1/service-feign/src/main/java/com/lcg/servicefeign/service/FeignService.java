package com.lcg.servicefeign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * 断路器 Feign：
 * 1. 实现接口，重写接口方法
 * 2. 添加fallback属性
 */
@FeignClient(value = "service-a", fallback = FeignServiceHystrix.class)
public interface FeignService {
    @GetMapping("/a")
    String getFromClientOne();
}
