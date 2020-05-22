package model;

public class Customer {

  private String login;
  private String password;
  private int amountOfMoney;

  public Customer() {
  }

  public Customer(String login, String password, int amountOfMoney) {
    this.login = login;
    this.password = password;
    this.amountOfMoney = amountOfMoney;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public boolean checkLogin(String login) {
    return this.login.equals(login);
  }

  public boolean checkPassword(String password) {
    return this.password.equals(password);
  }


  public void setPassword(String password) {
    this.password = password;
  }

  public int getAmountOfMoney() {
    return amountOfMoney;
  }

  public void setAmountOfMoney(int amountOfMoney) {
    this.amountOfMoney = amountOfMoney;
  }
}
