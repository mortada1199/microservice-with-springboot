package com.microservice.controller;

import com.microservice.entity.CustomerRegistrationRequest;
import com.microservice.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customer/")
public class CustomerController {
    private final  CustomerService customerService;

//    public CustomerController(CustomerService customerService) {
//        this.customerService = customerService;
//    }  reblace by @AllargsConstructor

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest ){
        log.info("new customer register {}",customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
