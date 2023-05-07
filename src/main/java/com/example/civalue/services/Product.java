package com.example.civalue.services;

import com.example.civalue.pojos.ProductFilters;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class Product {
    private String productId;
    private Long relevancyScore;
    private String category; // can be ENUM
    private String brand; // can be ENUM

    public List<Product> getMatchingProducts(ProductFilters productFilters, int limit) {
        return Collections.emptyList();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Long getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(Long relevancyScore) {
        this.relevancyScore = relevancyScore;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", relevancyScore=" + relevancyScore +
                '}';
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
