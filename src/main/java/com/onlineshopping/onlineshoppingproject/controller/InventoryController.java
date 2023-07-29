package com.onlineshopping.onlineshoppingproject.controller;

import com.onlineshopping.onlineshoppingproject.model.Inventory;
import com.onlineshopping.onlineshoppingproject.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InventoryController {
    private InventoryService inventoryService;
    @Autowired
    public InventoryController(InventoryService inventoryService){
        this.inventoryService=inventoryService;
    }
    //posting an inentory
    @PostMapping("/inventory")
    public void postInventory(@RequestBody Inventory inventory){
        inventoryService.postInventory(inventory);
    }
    //posting an inentory
    @GetMapping("/inventory")
    public List<Inventory> getInventory(){
        return inventoryService.getInventory();
    }
}
