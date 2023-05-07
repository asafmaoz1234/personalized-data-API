package com.example.civalue.daos.helpers;

import com.example.civalue.daos.ProductDAO;
import com.example.civalue.services.Product;


public class ProductDAOHelper {
    public static ProductDAO convertProductToDAO(Product product) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.setProductId(product.getProductId());
        productDAO.setBrand(product.getBrand());
        productDAO.setCategory(product.getCategory());
        return productDAO;
    }
}
