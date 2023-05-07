package com.example.civalue.client;

import com.example.civalue.pojos.ShopperProducts;
import com.example.civalue.services.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class InternalDataClient {
    private final RestTemplate restTemplate = new RestTemplate();

    protected String getUrl(String postfix, String id) {
        String baseUrl = "https://api.example.com";
        return baseUrl + "/" + postfix + "/" + id;
    }

    public List<Product> getShopperProductsData(String shopperId) {
        ResponseEntity<ShopperProducts> response = this.restTemplate.
                getForEntity(this.getUrl("shopperData", shopperId),
                        ShopperProducts.class);
        return Objects.requireNonNull(response.getBody())
                .getShelf();
    }

    public Product getProductMeta(String productId) {
        ResponseEntity<Product> response = this.restTemplate.
                getForEntity(this.getUrl("productData", productId),
                        Product.class);
        return response.getBody();
    }
}
