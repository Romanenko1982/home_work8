package exeptions;

public class NotEnoughMoneyInTheAccount extends Exception {

  public NotEnoughMoneyInTheAccount() {
    super();
  }

  public NotEnoughMoneyInTheAccount(String message) {
    super(message);
  }
}
