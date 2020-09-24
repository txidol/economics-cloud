package com.springboot.cloud.demos.feign.rest;

import com.springboot.cloud.common.core.entity.vo.Result;
import com.springboot.cloud.demos.feign.entity.Product;
import com.springboot.cloud.demos.feign.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("/classes")
    public Result hello(@RequestParam String name) {
        return classService.users(name);
    }

    @PostMapping("/classes")
    public Result hello(@RequestBody Map map) {
        return classService.users(map);
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody Product product){
        return classService.addUser(product);
    }

    @GetMapping("/getUser/getAll")
    public Result getUser(){
        return classService.getUser();
    }
}
