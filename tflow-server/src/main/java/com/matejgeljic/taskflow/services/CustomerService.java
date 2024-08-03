package com.matejgeljic.taskflow.services;

import com.matejgeljic.taskflow.domain.entities.CustomerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService {
    CustomerEntity saveCustomer(CustomerEntity customer);

    Page<CustomerEntity> findAll(Pageable pageable);

    boolean isExists(Long id);

    void deleteCustomer(Long id);
}