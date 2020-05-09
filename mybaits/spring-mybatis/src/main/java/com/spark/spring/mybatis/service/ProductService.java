package com.spark.spring.mybatis.service;

import com.spark.spring.mybatis.bean.Product;
import com.spark.spring.mybatis.service.dao.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Spark.tang
 * @create: 2020-05-09 13:43
 **/
@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public Product findById(Integer id) {

        return productMapper.selectById(id);
    }

    public void insert(Product product) {
        this.productMapper.insert(product);
    }

}
