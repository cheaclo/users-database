package com.cheaclo.userdatabase.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Product {
    private String title;
    private double price;
    private double regularPrice;
    private String productUrl;
    private String imageUrl;
    private List<ProductCategory> categories;
    private ProductType type;
    private Shop shop;
}
