package com.example.civalue.repositories;

import com.example.civalue.daos.ProductDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDAO, String> {
}
