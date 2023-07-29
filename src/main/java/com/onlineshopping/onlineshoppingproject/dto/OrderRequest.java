package com.onlineshopping.onlineshoppingproject.dto;


import com.onlineshopping.onlineshoppingproject.model.Customer;
import com.onlineshopping.onlineshoppingproject.model.Product;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderRequest {

    private Customer customer;
    private List<Product> productList;
}
