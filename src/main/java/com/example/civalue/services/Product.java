package com.example.civalue.services;

import com.example.civalue.pojos.ProductFilters;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class Product {
    private String productId;

    public List<Product> getMatchingProducts(ProductFilters productFilters, int limit) {
        return Collections.emptyList();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                '}';
    }
}
