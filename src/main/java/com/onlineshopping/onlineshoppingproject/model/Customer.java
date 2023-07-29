package com.onlineshopping.onlineshoppingproject.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name="t_customer")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;

    @OneToOne(targetEntity = com.onlineshopping.onlineshoppingproject.model.Address.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="address_id",referencedColumnName = "id")
    private com.onlineshopping.onlineshoppingproject.model.Address address;

    @OneToOne(targetEntity = com.onlineshopping.onlineshoppingproject.model.BankAccount.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="account_id",referencedColumnName = "id")
    private BankAccount bankAccount;
}
