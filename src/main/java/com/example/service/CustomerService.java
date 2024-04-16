package com.example.service;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer) {
        Customer createdCustomer = customerRepository.save(customer);
        logger.info("Customer created successfully");
        return createdCustomer;
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        logger.info("Customers retrieved successfully");
        return customers;
    }

    // Other CRUD methods (update, delete, etc.)
}