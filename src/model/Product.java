package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Product {

  private final SimpleDateFormat simpleDateFormat;
  private int ID;
  private Name name;
  private Type type;
  private int cost;
  private Calendar releaseDate;

  {
    simpleDateFormat = new SimpleDateFormat("dd.MM.y");
  }

  public Product(int ID, Name name, Type type, int cost, Calendar releaseDate) {
    this.ID = ID;
    this.name = name;
    this.type = type;
    this.releaseDate = releaseDate;
    this.cost = cost;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ID - ").append(ID);
    sb.append(", name - ").append(name);
    sb.append(", type - ").append(type);
    sb.append(", cost - ").append(cost);
    sb.append(", releaseDate - ").append(date());
    return sb.toString();
  }

  private String date() {
    return simpleDateFormat.format(releaseDate.getTime());
  }

  public int getID() {
    return ID;
  }

  public int getCost() {
    return cost;
  }
}
