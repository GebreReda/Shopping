package com.onlineshopping.onlineshoppingproject.controller;

import com.onlineshopping.onlineshoppingproject.dto.OrderRequest;
import com.onlineshopping.onlineshoppingproject.model.Order;
import com.onlineshopping.onlineshoppingproject.model.Product;
import com.onlineshopping.onlineshoppingproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    //Posting a Product
    @PostMapping("/product")
    public void postProduct(@RequestBody Product product){
        orderService.postProduct(product);
    }
    //Get all Product
    @GetMapping("/product")
    public List<Product> getProduct(){
        return orderService.getProduct();
    }

    //Posting an Order
    @PostMapping("/order")
    public String postProduct(@RequestBody OrderRequest orderRequest){
        return orderService.postOrder(orderRequest);
    }
    //Get all Orders
    @GetMapping("/order")
    public List<Order> getOrder(){

        System.out.println(orderService.getOrder());
        return orderService.getOrder();
    }
}
