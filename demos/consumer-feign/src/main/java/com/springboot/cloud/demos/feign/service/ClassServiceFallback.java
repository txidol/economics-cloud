package com.springboot.cloud.demos.feign.service;

import com.springboot.cloud.common.core.entity.vo.Result;
import com.springboot.cloud.common.core.exception.SystemErrorType;
import com.springboot.cloud.demos.feign.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ClassServiceFallback implements ClassService {
    @Override
    public Result users(String name) {
        return Result.fail(SystemErrorType.SYSTEM_BUSY);
    }

    @Override
    public Result users(Map map) {
        return Result.fail(SystemErrorType.SYSTEM_BUSY);
    }

    @Override
    public Result addUser(Product product) {
        return Result.fail(SystemErrorType.SYSTEM_BUSY);
    }

    @Override
    public Result getUser() {
        return Result.fail(SystemErrorType.SYSTEM_BUSY);
    }
}
