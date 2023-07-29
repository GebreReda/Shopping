package com.onlineshopping.onlineshoppingproject.service;

import com.onlineshopping.onlineshoppingproject.model.Customer;
import com.onlineshopping.onlineshoppingproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    //Save a Customer
    public void postCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    //Get all Customers
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }
}
