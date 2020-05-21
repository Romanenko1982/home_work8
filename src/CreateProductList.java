import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CreateProductList {

  private static File productList = new File("ProductList.txt");

  public static void main(String[] args) {
    createProductList();
  }

  public static void createProductList() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(productList, false))) {
      bw.write(new Product(1, "Samsung", Type.MICROWAVE, 100,
          new GregorianCalendar(2014, Calendar.DECEMBER, 24)).toString() + "\n");
      bw.write(new Product(2, "Samsung", Type.MICROWAVE, 100,
          new GregorianCalendar(2014, Calendar.MAY, 24)).toString() + "\n");
      bw.write(new Product(3, "Samsung", Type.MICROWAVE, 100,
          new GregorianCalendar(2014, Calendar.SEPTEMBER, 24)).toString() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
