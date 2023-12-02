package com.microservice.service;

import com.microservice.entity.Customer;
import com.microservice.entity.CustomerRegistrationRequest;
import com.microservice.repo.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRegistrationRequest register) {
        Customer customer = Customer.builder().
                firstName(register.firstName()).
                lastName(register.lastName()).
                email(register.email()).build();

        customerRepository.save(customer);
    }
}
