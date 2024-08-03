package com.matejgeljic.taskflow.domain.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Double rating;
    private Integer stockQuantity;
    private Boolean isTaxable;
    private Boolean isArchived;
}