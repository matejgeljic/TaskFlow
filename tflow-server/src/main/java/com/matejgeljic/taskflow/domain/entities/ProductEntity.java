package com.matejgeljic.taskflow.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private Double rating;
    private Integer stockQuantity;
    private Boolean isArchived;
}