package com.example.resultexample.domain;

public sealed interface Error {
    record InvalidUsername() implements Error {}
    record InvalidPassword() implements Error {}
    record InvalidEmail() implements Error {}
}
