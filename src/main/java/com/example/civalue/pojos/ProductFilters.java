package com.example.civalue.pojos;

public class ProductFilters {
    private String shopperId;
    private String category;
    private String brand;

    public ProductFilters(String shopperId, String category, String brand) {
        this.shopperId = shopperId;
        this.category = category;
        this.brand = brand;
    }

    public ProductFilters(String shopperId) {
        this(shopperId, null, null);
    }

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
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
