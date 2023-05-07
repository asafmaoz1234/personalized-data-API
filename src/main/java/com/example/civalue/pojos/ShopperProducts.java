package com.example.civalue.pojos;

import com.example.civalue.services.Product;

import java.util.List;

public class ShopperProducts {
    private String shopperId;
    private List<Product> shelf;

    public ShopperProducts(String shopperId, List<Product> shelf) {
        this.shopperId = shopperId;
        this.shelf = shelf;
    }

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public List<Product> getShelf() {
        return shelf;
    }

    public void setShelf(List<Product> shelf) {
        this.shelf = shelf;
    }
}
