package com.example.resultexample.application;

public record CreateUserCommand(
    String username,
    String password,
    String email
) {}
