package com.onlineshopping.onlineshoppingproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="t_category")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String category;
}
