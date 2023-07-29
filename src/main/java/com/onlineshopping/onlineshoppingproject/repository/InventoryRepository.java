package com.onlineshopping.onlineshoppingproject.repository;

import com.onlineshopping.onlineshoppingproject.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
