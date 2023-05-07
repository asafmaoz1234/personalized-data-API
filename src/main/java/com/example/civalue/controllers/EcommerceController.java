package com.example.civalue.controllers;

import com.example.civalue.services.Product;
import com.example.civalue.pojos.ProductFilters;
import com.example.civalue.services.Shopper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
public class EcommerceController {

    Product product;
    Shopper shopper;

    public EcommerceController(Product product, Shopper shopper) {
        this.product = product;
        this.shopper = shopper;
    }

    @GetMapping("products/{shopperId}")
    public ResponseEntity<List<Product>> getProductsByShopper(@PathVariable String shopperId,
                                                              @RequestParam(required = false) String category,
                                                              @RequestParam(required = false) String brand,
                                                              @RequestParam(required = false, defaultValue = "10") int limit){
        ProductFilters productFilters = new ProductFilters(shopperId, category, brand);
        List<Product> response = this.product.getMatchingProducts(productFilters, limit);
        return ResponseEntity.ok()
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .body(response);
    }

    @GetMapping("shoppers/{productId}")
    public ResponseEntity<List<Shopper>> getShoppersByProduct(@PathVariable String productId,
                                                              @RequestParam(required = false, defaultValue = "10") int limit) {
        List<Shopper> response = this.shopper.getShoppersByProductId(productId, limit);
        return ResponseEntity.ok()
                .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .body(response);
    }
}
