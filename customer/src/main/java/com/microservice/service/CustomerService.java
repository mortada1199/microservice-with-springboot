package com.microservice.service;

import com.microservice.entity.Customer;
import com.microservice.entity.CustomerRegistrationRequest;
import com.microservice.entity.FraudCheckResponse;
import com.microservice.repo.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }  reblace with @AllArgsConstructor

    public void registerCustomer(CustomerRegistrationRequest register) {
        Customer customer = Customer.builder().
                firstName(register.firstName()).
                lastName(register.lastName()).
                email(register.email())
                .build();

        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }

    }
}
