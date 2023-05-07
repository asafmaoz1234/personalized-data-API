package com.example.civalue.services;

import com.example.civalue.client.InternalDataClient;
import com.example.civalue.daos.ProductDAO;
import com.example.civalue.daos.helpers.ProductDAOHelper;
import com.example.civalue.pojos.ProductFilters;
import com.example.civalue.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Product {
    private String productId;
    private Double relevancyScore;
    private String category; // can be ENUM
    private String brand; // can be ENUM

    @Autowired
    InternalDataClient internalDataClient;
    @Autowired
    ProductRepository productRepository;

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
        List<ProductDAO> productDAOS = this.productRepository.getShopperProducts(productFilters.getShopperId(), limit);
        List<Product> response = new ArrayList<>();
        productDAOS.forEach(productDAO ->
                response.add(new Product(productDAO.getProductId(), productDAO.getCategory(), productDAO.getBrand())));
        return response;
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
