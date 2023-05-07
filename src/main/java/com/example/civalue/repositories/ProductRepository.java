package com.example.civalue.repositories;

import com.example.civalue.daos.ProductDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductDAO, Long> {

    @Query(value = "SELECT * FROM product " +
            "JOIN shopper_product ON shopper_product.product_id = product.product_id " +
            "WHERE shopper_product.shopper_id = :shopperId LIMIT :limit", nativeQuery = true)
    List<ProductDAO> getShopperProducts(String shopperId, int limit); // maybe pass the filter object and build the query here
}
