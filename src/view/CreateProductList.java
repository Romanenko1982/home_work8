package view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.Name;
import model.Product;
import model.Type;

public class CreateProductList {

  public static File productList = new File("ListProducts.txt");

    public static void createProductList() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(productList, true))) {
      bw.write(new Product(1, Name.LG, Type.MICROWAVE, 100,
          new GregorianCalendar(2014, Calendar.DECEMBER, 24)).toString() + "\n");
      bw.write(new Product(2, Name.PHILLIPS, Type.MICROWAVE, 100,
          new GregorianCalendar(2014, Calendar.MAY, 24)).toString() + "\n");
      bw.write(new Product(3, Name.SONY, Type.MICROWAVE, 100,
          new GregorianCalendar(2014, Calendar.SEPTEMBER, 24)).toString() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
