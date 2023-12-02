package com.microservice.entity;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}
