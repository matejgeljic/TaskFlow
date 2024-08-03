package com.matejgeljic.taskflow.domain.entities;

import com.matejgeljic.taskflow.domain.dto.SalesOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "salesOrder")
public class SalesOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salesOrder_id_seq")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;


    @OneToMany()
    @JoinColumn(name = "sales_order_id")
    private List<OrderItemEntity> orderItems;

    private SalesOrderStatus status;
    private Double totalPrice;
}