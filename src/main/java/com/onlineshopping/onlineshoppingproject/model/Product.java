package com.onlineshopping.onlineshoppingproject.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name="t_product")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String productName;
    private String skuCode;
    private double price;
    private int quantity;
}
