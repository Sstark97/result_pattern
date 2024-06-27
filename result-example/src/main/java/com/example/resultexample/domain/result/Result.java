package com.example.resultexample.domain.result;

import com.example.resultexample.domain.CreateUserErrors;

public class Result<T> {
  protected final T value;
  protected final CreateUserErrors error;

  protected Result(T value, CreateUserErrors error) {
    this.value = value;
    this.error = error;
  }

  boolean isSuccess() {
    return false;
  }

  boolean isFailure() {
    return false;
  }

  T value() {
    return null;
  }

  CreateUserErrors error() {
    return null;
  }

  public static <T> Result<T> success(T value) {
    return new Success<>(value);
  }

  public static Result<Void> failure(CreateUserErrors error) {
    return new Failure(error);
  }
}
