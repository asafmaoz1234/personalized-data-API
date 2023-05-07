package com.example.civalue.repositories;

import com.example.civalue.daos.ShopperProductsDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperProductRepository extends JpaRepository<ShopperProductsDAO, Long> {
}
