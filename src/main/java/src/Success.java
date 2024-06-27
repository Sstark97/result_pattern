package src;

import java.util.Objects;

final class Success<T> extends Result<T> {
  Success(T value) {
    super(value, null);
  }

  @Override
  public boolean isSuccess() {
    return true;
  }

  @Override
  public T value() {
    return value;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
    var that = (Success) obj;
    return Objects.equals(this.value, that.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Success[" +
        "value=" + value + ']';
  }

}