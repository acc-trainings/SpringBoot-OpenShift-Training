package com.acc.training.customerapi.repository;

import java.util.Optional;

import com.acc.training.customerapi.domain.CustomerDomain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerDomain, String> {

	Optional<CustomerDomain> findByCustomerId(String custId);
}

