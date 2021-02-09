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
        Optional<CustomerDomain> domainCustomer = customerRepository.findByCustomerId(custId);

        if (!domainCustomer.isPresent()) {
            return null;
        }

        Customer modelCustomer = mapDomainToModel(domainCustomer.get());
        return modelCustomer;
    }

    public Customer createCustomer(@Valid Customer body) {
        CustomerDomain domainCustomer = mapModelToDomain(body);
        return mapDomainToModel(customerRepository.save(domainCustomer));
    }

    private CustomerDomain mapModelToDomain(Customer customer) {
        CustomerDomain domainCustomer = new CustomerDomain();
        domainCustomer.setCustomerAddress(customer.getCustomerAddress());
        domainCustomer.setCustomerId(customer.getCustomerId());
        domainCustomer.setCustomerName(customer.getCustomerName());
        return domainCustomer;
    }

    private Customer mapDomainToModel(CustomerDomain domainCustomer) {
        Customer modelCustomer = new Customer();
        modelCustomer.setCustomerAddress(domainCustomer.getCustomerAddress());
        modelCustomer.setCustomerId(domainCustomer.getCustomerId());
        modelCustomer.setCustomerName(domainCustomer.getCustomerName());
        return modelCustomer;
    }

}
