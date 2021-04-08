import java.io.*;

public class InsufficientFundsException extends Exception {

  public static void main(String[] args) {}

  private double amount;

  public InsufficientFundsException(double amount) {
    this.amount = amount;
  }

  public double getAmount() {
    return amount;
  }
}
