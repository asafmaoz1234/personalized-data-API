package com.example.civalue.daos.helpers;

import com.example.civalue.daos.ShopperProductsDAO;
import com.example.civalue.services.Product;

import java.util.ArrayList;
import java.util.List;

public class ShopperProductsDAOHelper {
    public static List<ShopperProductsDAO> convertShopperProductsToDAO(String shopperId, List<Product> products) {
        List<ShopperProductsDAO> response = new ArrayList<>();
        products.stream()
                .forEach(product-> response.add(new ShopperProductsDAO(product.getProductId(), shopperId, product.getRelevancyScore())));
        return response;
    }
}
