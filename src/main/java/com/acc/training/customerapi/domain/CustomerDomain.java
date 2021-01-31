package com.acc.training.customerapi.domain;

import com.acc.training.customerapi.model.Customer;

import org.springframework.data.mongodb.core.mapping.Document;

import nonapi.io.github.classgraph.json.Id;

@Document(collection = "customer-test")
public class CustomerDomain extends Customer {
    
    @Id
    private String id;


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}
