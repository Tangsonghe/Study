package com.spark.spring.mybatis.service.dao;

import com.spark.spring.mybatis.bean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: Spark.tang
 * @create: 2020-05-09 14:14
 **/
@Mapper
public interface ProductMapper {
    Product selectById(@Param("id") Integer id);

    void insert(Product product);
}
