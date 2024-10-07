package com.matejgeljic.taskflow.domain.entities;

import com.matejgeljic.taskflow.domain.dto.SalesOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "salesOrder")
public class SalesOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "UUID")
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;


    @OneToMany()
    @JoinColumn(name = "sales_order_id")
    private List<OrderItemEntity> orderItems;

    private SalesOrderStatus status;
    private Double totalPrice;
}