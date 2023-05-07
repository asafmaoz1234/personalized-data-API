package com.example.civalue.services;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class Shopper {
    private String shopperId;

    public List<Shopper> getShoppersByProductId(String productId, int limit) {
        return Collections.emptyList();
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
