package com.example.civalue.repositories;

import com.example.civalue.daos.ShopperProductsDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopperProductRepository extends JpaRepository<ShopperProductsDAO, Long> {

    @Query(value = "SELECT * FROM shopper_product " +
            "WHERE shopper_product.product_id = :productId LIMIT :limit", nativeQuery = true)
    List<ShopperProductsDAO> getShoppersByProductId(String productId, int limit);
}
