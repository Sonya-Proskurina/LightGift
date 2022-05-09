package com.example.LightGift.model;

import com.example.LightGift.entity.ProductEntity;

public class Product {
    private Long id;
    private String name;
    private String info;
    private Integer count;
    private String category;


    public Product(Long id, String name, String info, Integer count, String category) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.count = count;
        this.category = category;
    }

    public static Product toModel(ProductEntity product) {
        return new Product(product.getId(),
                product.getName(),
                product.getInfo(),
                product.getCount(),
                product.getCategory().getName()
        );
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
