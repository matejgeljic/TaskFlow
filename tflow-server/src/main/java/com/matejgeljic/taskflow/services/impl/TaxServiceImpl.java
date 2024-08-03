package com.matejgeljic.taskflow.services.impl;

import com.matejgeljic.taskflow.domain.entities.OrderItemEntity;
import com.matejgeljic.taskflow.services.TaxService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxServiceImpl implements TaxService {

//    @Override
//    public double calculateTotalTax(List<OrderItemEntity> orderItems) {
//        double totalTax = 0.0;
//
//        for (OrderItemEntity orderItem : orderItems) {
//            if (!orderItem.getProduct().getIsTaxable()) {
//                double taxRate = 0.1;
//                totalTax += orderItem.getProduct().getPrice() * taxRate;
//            }
//        }
//        return totalTax;
//    }
}