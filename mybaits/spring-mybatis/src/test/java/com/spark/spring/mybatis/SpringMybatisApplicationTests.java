package com.spark.spring.mybatis;

import com.spark.spring.mybatis.bean.Product;
import com.spark.spring.mybatis.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
@MapperScan("com.spark.spring.mybatis.service.dao")
class SpringMybatisApplicationTests {

    @Autowired
    ProductService productService;

    @Test
    void contextLoads() {

        System.out.println(productService.findById(4));

        Product product = new Product();
        product.setProductName("测试新增1aaa");
        product.setTypes(Arrays.asList(2,3,4));
        productService.insert(product);

        System.out.println(productService.findById(5));
    }

}
