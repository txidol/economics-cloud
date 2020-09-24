package com.springboot.cloud.demos.producer.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.cloud.demos.producer.dao.ProductMapper;
import com.springboot.cloud.demos.producer.entity.param.ProductQueryParam;
import com.springboot.cloud.demos.producer.entity.po.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
@RefreshScope
public class ProductService extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public boolean add(Product product) {
        Integer i= productMapper.insert(product);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean update(Product product) {
        return false;
    }

    @Override
    public List<Product> get() {
        ProductQueryParam productQueryParam=new ProductQueryParam();
        Wrapper<Product> queryWrapper =productQueryParam.build();
        List<Product> product = productMapper.selectList(queryWrapper);
        return product;
    }

    @Override
    public List<Product> query(ProductQueryParam productQueryParam) {
        QueryWrapper<Product> queryWrapper = productQueryParam.build();
        queryWrapper.eq("name", productQueryParam.getName());
        return this.list(queryWrapper);
    }
}
