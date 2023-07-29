package com.onlineshopping.onlineshoppingproject.repository;

import com.onlineshopping.onlineshoppingproject.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
