package exceptions;

public class PrimeNumberException extends Exception {
  public PrimeNumberException(int invalidNumber) {
    super("Ошибка: Число " + invalidNumber + " не является простым.");
  }
}
