import java.util.Date;

public class Product {

  private int ID;
  private String name;
  private Type type;
  private Date date;
  private double cost;

  public Product(int ID, String name, Type type, Date date, double cost) {
    this.ID = ID;
    this.name = name;
    this.type = type;
    this.date = date;
    this.cost = cost;
  }



  public int getID() {
    return ID;
  }

  public void setID(int ID) {
    this.ID = ID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }
}
