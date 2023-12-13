package com.microservice.controller;

import com.microservice.entity.FraudCheckResponse;
import com.microservice.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudCheckController {
   private final FraudCheckService fraudCheckService;

//    public FraudCheckController(FraudCheckService fraudCheckService) {
//        this.fraudCheckService = fraudCheckService;
//    }  this constructor  replace by @AllargumentConstructor

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){

        boolean  result = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check yhe customer of id {}",customerId);
        return  new FraudCheckResponse(result);
}


}
