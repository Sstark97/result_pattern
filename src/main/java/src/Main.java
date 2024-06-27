package src;

public class Main {
  public static void main(String[] args) {
    Result<Integer> result = Result.success(42);
    Result<?> result2 = Result.failure(Error.INVALID_INPUT);

    if (result.isSuccess()) {
      System.out.println("Success: " + result.value());
    } else {
      System.out.println("Failure: " + result.error());
    }

    if (result2.isSuccess()) {
      System.out.println("Success: " + result2.value());
    } else {
      System.out.println("Failure: " + result2.error());
    }
  }
}
