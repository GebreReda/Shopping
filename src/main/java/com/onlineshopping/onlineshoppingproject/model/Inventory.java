package com.onlineshopping.onlineshoppingproject.model;


import jakarta.persistence.*;
import lombok.*;

@Table(name="t_inventory")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String productName;
    private String skuCode;
    private double price;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Category category;
}
