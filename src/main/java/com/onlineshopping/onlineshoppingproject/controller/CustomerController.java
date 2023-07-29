package com.onlineshopping.onlineshoppingproject.controller;

import com.onlineshopping.onlineshoppingproject.model.Customer;
import com.onlineshopping.onlineshoppingproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }
    //Posting a Customer
    @PostMapping("/customer")
    public void postCustomer(@RequestBody Customer customer){
        customerService.postCustomer(customer);
    }
    //Get all Customers
    @GetMapping("/customer")
    public List<Customer> getCustomer(){
        return customerService.getCustomer();
    }
}
