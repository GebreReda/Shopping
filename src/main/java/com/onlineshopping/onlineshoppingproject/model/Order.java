package com.onlineshopping.onlineshoppingproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="t_order")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String orderNumber;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id", referencedColumnName = "id")
    private Customer customer;

    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name="op_fk", referencedColumnName = "id")
    private List<Product> productList;
}
