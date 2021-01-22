package com.acc.training.customerapi.controller;

import javax.validation.Valid;

import com.acc.training.customerapi.api.CreateCustomerApi;
import com.acc.training.customerapi.api.CustomerApi;
import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements CustomerApi, CreateCustomerApi {

    @Autowired
    private CustomerService customerService;

    @Override
    public ResponseEntity<Customer> getCustomer(String id) {

        if (!StringUtils.hasText(id)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        Customer customer = customerService.getCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @Override
    public ResponseEntity<Customer> createCustomer(@Valid Customer body) {

        if(null == body){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        Customer customer = customerService.createCustomer(body);
        return ResponseEntity.status(HttpStatus.OK).body(customer);

    }
}
