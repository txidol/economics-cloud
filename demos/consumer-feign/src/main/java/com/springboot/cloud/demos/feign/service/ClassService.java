package com.springboot.cloud.demos.feign.service;

import com.springboot.cloud.common.core.entity.vo.Result;
import com.springboot.cloud.demos.feign.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 *
 * 降级这里,使用@SentinelResource也是可以的.使用方式:在方法名上添加该注解    @SentinelResource(fallback = "usersFallback")
 * usersFallback为方法降级后调用的方法
 */
@FeignClient(name = "producer", fallback = ClassServiceFallback.class)
public interface ClassService {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    Result users(@RequestParam("name") String name);

    @RequestMapping(value = "/hello/", method = RequestMethod.POST)
    Result users(@RequestBody Map map);


    @PostMapping(value = "/product/add")
    Result addUser(@RequestBody Product product);

    @GetMapping(value = "/product/getAll")
    Result getUser();
}
