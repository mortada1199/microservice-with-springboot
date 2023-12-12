package com.microservice.service;

import com.microservice.entity.Customer;
import com.microservice.entity.CustomerRegistrationRequest;
import com.microservice.repo.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService{
    private final CustomerRepository customerRepository;

//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }  reblace with @AllArgsConstructor

    public void registerCustomer(CustomerRegistrationRequest register) {
        Customer customer = Customer.builder().
                firstName(register.firstName()).
                lastName(register.lastName()).
                email(register.email()).build();

        customerRepository.save(customer);
    }
}
