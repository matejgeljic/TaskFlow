package com.matejgeljic.taskflow.controllers;

import com.matejgeljic.taskflow.domain.dto.CustomerDto;
import com.matejgeljic.taskflow.domain.entities.CustomerEntity;
import com.matejgeljic.taskflow.mappers.Mapper;
import com.matejgeljic.taskflow.services.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "customers")
@RestController
@Tag(name = "Customer")
public class CustomerController {
    private final CustomerService customerService;
    private final Mapper<CustomerEntity, CustomerDto> customerMapper;

    public CustomerController(CustomerService customerService, Mapper<CustomerEntity, CustomerDto> customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        CustomerEntity customerEntity = customerMapper.mapFrom(customerDto);
        CustomerEntity savedCustomerEntity = customerService.saveCustomer(customerEntity);
        return new ResponseEntity<>(customerMapper.mapTo(savedCustomerEntity), HttpStatus.CREATED);
    }

    @GetMapping
    public Page<CustomerDto> getCustomers(Pageable pageable) {
        Page<CustomerEntity> customers = customerService.findAll(pageable);

        return customers.map(customerMapper::mapTo);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CustomerDto> fullUpdateCustomer(
            @PathVariable("id") Long id,
            @Valid @RequestBody CustomerDto customerDto) {
        if(!customerService.isExists(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        customerDto.setId(id);
        CustomerEntity customerEntity = customerMapper.mapFrom(customerDto);

        CustomerEntity savedCustomer = customerService.saveCustomer(customerEntity);
        return new ResponseEntity<>(customerMapper.mapTo(savedCustomer), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
