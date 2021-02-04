package com.acc.training.customerapi.service;

import javax.validation.Valid;

import com.acc.training.customerapi.model.Customer;
import com.acc.training.customerapi.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(String custId) {
        return customerRepository.getCustomer(custId);
        
    }

	public Customer createCustomer(@Valid Customer body) {
        customerRepository.addCustomer(body);
		return customerRepository.getCustomer(body.getCustomerId());
    }
    

}
