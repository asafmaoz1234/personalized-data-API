package com.example.civalue.services;

import com.example.civalue.client.InternalDataClient;
import com.example.civalue.daos.helpers.ShopperProductsDAOHelper;
import com.example.civalue.repositories.ShopperProductRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class Shopper {
    private String shopperId;
    InternalDataClient internalDataClient;
    ShopperProductRepository shopperProductRepository;

    public Shopper(InternalDataClient internalDataClient, ShopperProductRepository shopperProductRepository) {
        this.internalDataClient = internalDataClient;
        this.shopperProductRepository = shopperProductRepository;
    }

    public Shopper() {
    }

    public List<Shopper> getShoppersByProductId(String productId, int limit) {
        return Collections.emptyList();
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
}
