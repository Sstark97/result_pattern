package src;

public class Result<T> {
  protected final T value;
  protected final Error error;

  protected Result(T value, Error error) {
    this.value = value;
    this.error = error;
  }

  boolean isSuccess() {
    return false;
  }

  boolean isFailure() {
    return false;
  }

  <T> T value() {
    return null;
  }

  Error error() {
    return null;
  }

  static <T> Result<T> success(T value) {
    return new Success<>(value);
  }

  static Result<Void> failure(Error error) {
    return new Failure(error);
  }
}
