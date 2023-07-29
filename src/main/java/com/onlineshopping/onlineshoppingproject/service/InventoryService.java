package com.onlineshopping.onlineshoppingproject.service;

import com.onlineshopping.onlineshoppingproject.model.Inventory;
import com.onlineshopping.onlineshoppingproject.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private InventoryRepository inventoryRepository;
    @Autowired
    public InventoryService(InventoryRepository inventoryRepository){
        this.inventoryRepository=inventoryRepository;
    }
    //Inventory
    //post an inventory
    public void postInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    //get inventory
    public List<Inventory> getInventory() {
        return inventoryRepository.findAll();
    }

}
