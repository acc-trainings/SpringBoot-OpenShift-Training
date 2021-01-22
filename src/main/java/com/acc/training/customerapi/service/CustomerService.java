package com.acc.training.customerapi.service;

import javax.validation.Valid;

import com.acc.training.customerapi.model.Customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer getCustomer(String id) {
        Customer customer = new Customer();
        customer.id("12345");
        customer.setCustomerId("12345");
        customer.setCustomerName("Rahul");
        customer.setCustomerAddress("Hartford, CT");
        return customer;
    }

	public Customer createCustomer(@Valid Customer body) {
		return body;
	}

}
