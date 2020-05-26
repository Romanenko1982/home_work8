package model;

import java.io.Serializable;

public class Customer implements Serializable {

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

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("Login ").append(login);
    sb.append(" Password ").append(password);
    sb.append(" Money ").append(amountOfMoney);
    return sb.toString();
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
