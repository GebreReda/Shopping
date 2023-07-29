package com.onlineshopping.onlineshoppingproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="t_bank_account")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int accountNumber;
    private int accountCode;
    private double balance;
}
