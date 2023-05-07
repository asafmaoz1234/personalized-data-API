package com.example.civalue.services;

import com.example.civalue.client.InternalDataClient;
import com.example.civalue.daos.ShopperProductsDAO;
import com.example.civalue.daos.helpers.ShopperProductsDAOHelper;
import com.example.civalue.repositories.ShopperProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Shopper {
    private String shopperId;
    private int age;
    private Double relevancyScore;

    @Autowired
    InternalDataClient internalDataClient;
    @Autowired
    ShopperProductRepository shopperProductRepository;

    public Shopper() {
    }

    public Shopper(String shopperId, Double relevancyScore) {
        this.shopperId = shopperId;
        this.relevancyScore = relevancyScore;
    }

    public List<Shopper> getShoppersByProductId(String productId, int limit) {
        List<ShopperProductsDAO> shopperProductsDAOS = this.shopperProductRepository.getShoppersByProductId(productId, limit);
        List<Shopper> response = new ArrayList<>();
        shopperProductsDAOS.forEach(shopperProductsDAO ->
                response.add(new Shopper(shopperProductsDAO.getShopperId(),shopperProductsDAO.getRelevancyScore())));
        return response;
    }

    public void saveShopperProducts(String shopperId) {
        List<Product> shopperProducts = internalDataClient.getShopperProductsData(shopperId);
        this.shopperProductRepository.saveAll(ShopperProductsDAOHelper.convertShopperProductsToDAO(shopperId, shopperProducts));
    }

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    @Override
    public String toString() {
        return "Shopper{" +
                "shopperId='" + shopperId + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getRelevancyScore() {
        return relevancyScore;
    }
}
