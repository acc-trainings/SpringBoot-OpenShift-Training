package com.acc.training.customerapi.repository;

import java.util.HashMap;
import java.util.Map;

import com.acc.training.customerapi.model.Customer;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

    private static final Map<String, Customer> customerMap = new HashMap<>();

    static {
        initCustomer();
    }

    private static void initCustomer() {
        Customer cus1 = new Customer();
        cus1.setCustomerId("12345");
        cus1.setCustomerName("Rahul Anand");
        cus1.setCustomerAddress("Hartford");
        Customer cus2 = new Customer();
        cus2.setCustomerId("23456");
        cus2.setCustomerName("Sandeep Patil");
        cus2.setCustomerAddress("New York");
        Customer cus3 = new Customer();
        cus3.setCustomerId("24567");
        cus3.setCustomerName("Laxmi Rajput");
        cus3.setCustomerAddress("Huntvalley");

        customerMap.put(cus1.getCustomerId(), cus1);
        customerMap.put(cus2.getCustomerId(), cus2);
        customerMap.put(cus3.getCustomerId(), cus3);
    }

    public Customer getCustomer(String cusId) {
        return customerMap.get(cusId);
    }

    public Customer addCustomer(Customer cus) {
        customerMap.put(cus.getCustomerId(), cus);
        return cus;
    }
}
