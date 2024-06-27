package src;

import java.util.Objects;

final class Failure extends Result<Void> {
  Failure(Error error) {
    super(null, error);
  }

  @Override
  public boolean isFailure() {
    return true;
  }

  @Override
  public Error error() {
    return error;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
    var that = (Failure) obj;
    return Objects.equals(this.error, that.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(error);
  }

  @Override
  public String toString() {
    return "Failure[" +
        "error=" + error + ']';
  }
}