package com.inn.cafe.wrapper;

import lombok.Data;

import javax.persistence.Id;

@Data
public class ProductWrapper {

    Integer id;

    String name;

    String description;

    Integer price;

    String categoryName;

    Integer categoryId;

    String status;

    public ProductWrapper() {

    }

    public ProductWrapper(Integer id, String name, String description, Integer price, String categoryName, Integer categoryId, String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryName = categoryName;
        this.categoryId = categoryId;
        this.status = status;
    }

    public ProductWrapper(Integer id, String name){
        this.id = id;
        this.name = name;
    }

}
