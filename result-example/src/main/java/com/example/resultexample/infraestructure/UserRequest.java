package com.example.resultexample.infraestructure;

public record UserRequest(
    String username,
    String password,
    String email
) {
}
