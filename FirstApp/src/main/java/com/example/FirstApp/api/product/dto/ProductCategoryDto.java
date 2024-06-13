package com.example.FirstApp.api.product.dto;

public class ProductCategoryDto {

    String productName;
    String categoryName;

    public ProductCategoryDto(String productName, String categoryName) {
        this.productName = productName;
        this.categoryName = categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
