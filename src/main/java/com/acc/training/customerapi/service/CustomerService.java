package com.acc.training.customerapi.service;

import java.util.Optional;

import javax.validation.Valid;

import com.acc.training.customerapi.domain.CustomerDomain;
import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(String custId) {

        Optional<CustomerDomain> customer = customerRepository.findByCustomerId(custId);
        if (!customer.isPresent()) {
            return null;
        }
        return customer.get();
    }

    public Customer createCustomer(@Valid Customer body) {
        return body;
    }

}
