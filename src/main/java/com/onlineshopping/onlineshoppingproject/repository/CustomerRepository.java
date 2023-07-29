package com.onlineshopping.onlineshoppingproject.repository;

import com.onlineshopping.onlineshoppingproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
     //BankAccount findByAccountNumber(int accountNumber);
}
