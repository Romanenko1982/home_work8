import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import javax.swing.Popup;

public class CreateProductList {

  public static void main(String[] args) {
    createProductList();
  }

  private static File productList = new File("ProductList.txt");

  public static void createProductList() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(productList, false))) {
    bw.write(new Product(1, "Samsung", Type.MICROWAVE, new Date(), 100).toString() + "\n");
    bw.write(new Product(2, "Samsung", Type.MICROWAVE, new Date(), 100).toString() + "\n");
    bw.write(new Product(3, "Samsung", Type.MICROWAVE, new Date(), 100).toString() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
