package com.onlineshopping.onlineshoppingproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="t_address")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String state;
    private String city;
    private String street;
    private String zipcode;
}
