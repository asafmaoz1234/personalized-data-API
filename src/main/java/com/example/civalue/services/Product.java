package com.example.civalue.services;

import com.example.civalue.client.InternalDataClient;
import com.example.civalue.daos.helpers.ProductDAOHelper;
import com.example.civalue.pojos.ProductFilters;
import com.example.civalue.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class Product {
    private String productId;
    private Double relevancyScore;
    private String category; // can be ENUM
    private String brand; // can be ENUM

    InternalDataClient internalDataClient;
    ProductRepository productRepository;

    public Product(InternalDataClient internalDataClient, ProductRepository productRepository) {
        this.internalDataClient = internalDataClient;
        this.productRepository = productRepository;
    }

    public Product(String productId, String category, String brand) {
        this.productId = productId;
        this.category = category;
        this.brand = brand;
    }

    public Product(){}

    public Product(String productId, Double relevancyScore) {
        this.productId = productId;
        this.relevancyScore = relevancyScore;
    }

    public List<Product> getMatchingProducts(ProductFilters productFilters, int limit) {
        return Collections.emptyList();
    }

    public void saveProductMeta(String productId) {
        Product toSave = this.internalDataClient.getProductMeta(productId);
        this.productRepository.save(ProductDAOHelper.convertProductToDAO(toSave));
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(Double relevancyScore) {
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
