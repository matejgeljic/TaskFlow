package com.matejgeljic.taskflow.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "orderItem")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderItem_id_seq")
    private Long id;
    private Integer quantity;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}