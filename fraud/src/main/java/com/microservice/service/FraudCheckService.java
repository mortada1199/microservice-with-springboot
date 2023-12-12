package com.microservice.service;

import com.microservice.entity.FraudCheckHistory;
import com.microservice.repo.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

//    public FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
//        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
//    }  replace this  constructor   by @AllArgsConstructor


    public boolean isFraudulentCustomer(Integer CustomerId){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(CustomerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return  false;
    }
}
