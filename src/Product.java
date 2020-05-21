import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Product {

  private final SimpleDateFormat simpleDateFormat;
  private int ID;
  private String name;
  private Type type;
  private Calendar calendar;
  private double cost;

  {
    simpleDateFormat = new SimpleDateFormat("dd.MM.y");
  }


  public Product(int ID, String name, Type type, double cost, Calendar calendar) {
    this.ID = ID;
    this.name = name;
    this.type = type;
    this.calendar = calendar;
    this.cost = cost;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("ID=").append(ID);
    sb.append(", name='").append(name).append('\'');
    sb.append(", type=").append(type.getName());
    sb.append(", cost=").append(cost);
    sb.append(", date=").append(date());
    return sb.toString();
  }

  private String date() {
    return simpleDateFormat.format(calendar.getTime());
  }
}
