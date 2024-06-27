package com.example.resultexample.domain;

sealed public interface Error {
    record InvalidUsername() implements Error {}
    record InvalidPassword() implements Error {}
    record InvalidEmail() implements Error {}
}
