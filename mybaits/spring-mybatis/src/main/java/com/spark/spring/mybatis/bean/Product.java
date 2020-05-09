package com.spark.spring.mybatis.bean;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/**
 * @description:
 * @author: Spark.tang
 * @create: 2020-05-09 11:28
 **/
public class Product {

    private Integer id;

    private String productName;

    private List<Integer> types;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Integer> getTypes() {
        return types;
    }

    public void setTypes(List<Integer> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
