package com.datababy.service;

import com.datababy.enity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

/**
 * Created by yongma on 2017/2/7.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
}
