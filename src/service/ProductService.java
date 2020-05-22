package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import model.Name;
import model.Product;
import model.Type;

public class ProductService {

  //  private Customer customer;
  private Scanner scanner;
  private File userDataBase;
  private File productList;
  private File productListFromFile;
  private HashMap<Integer, Product> productMap;
  private Product product;


  {
    userDataBase = new File("UserDataBase.txt");
    productList = new File("ProductList.txt");
    productListFromFile = new File("ProductListHand.txt");
  }

  public ProductService() {
    this.scanner = new Scanner(System.in);
  }

  public LinkedList<String> createLinkedListProducts() {
    LinkedList<String> list = new LinkedList<>();
    String var;
    try (BufferedReader br = new BufferedReader(new FileReader(productListFromFile))) {
      while ((var = br.readLine()) != null) {
        list.add(var);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public HashMap<Integer, Product> getProducts() {
    if (productMap == null) {
      productMap = new HashMap<>();
      for (String productString : createLinkedListProducts()) {
        product = parseProduct(productString);
        productMap.put(product.getID(), product);
      }
    }
    return productMap;
  }

  private Product parseProduct(String product) {
    String[] arrayProduct = product.split(", ");
    int var = arrayProduct[0].lastIndexOf(" ");
    int id = (Integer.parseInt(arrayProduct[0].substring(var + 1)));
    var = arrayProduct[1].lastIndexOf(" ");
    Name name = Name.valueOf(arrayProduct[1].substring(var + 1).toUpperCase());
    var = arrayProduct[2].lastIndexOf(" ");
    Type type = Type.valueOf(arrayProduct[2].substring(var + 1).toUpperCase());
    var = arrayProduct[3].lastIndexOf(" ");
    double cost = (Double.parseDouble(arrayProduct[3].substring(var + 1)));
    var = arrayProduct[4].lastIndexOf(" ");
    String[] dateString = arrayProduct[4].substring(var + 1).split("\\.");

    Calendar date = new Calendar.Builder().setDate(Integer.parseInt(dateString[0]),
        Integer.parseInt(dateString[1]), Integer.parseInt(dateString[2])).build();
    return new Product(id, name, type, cost, date);

//    product = new Product(Integer.parseInt(arrayProduct[0].substring(var)));

  }

  public void showProductList() {
    for (String product : createLinkedListProducts()) {
      System.out.println(parseProduct(product));
    }
  }

  public void createOrderProducts() {
    System.out.println("Input ID product.");
    scanner = new Scanner(System.in);
    String product = searchProductByID(scanner.nextInt());
  }

  public String searchProductByID(int id) {
    String var = "";
    try (BufferedReader br = new BufferedReader(new FileReader(productListFromFile))) {
      String[] array;
      while ((var = br.readLine()) != null) {
        array = var.split(", ");
        if (array[0].equals("ID=" + id)) {
          return var;
        } else {
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return var;
  }
// создание списка продуктов и сохранение их в файле, что не совсем удобно. Лучше считать просто с файла.
//  public void createProductList() {
//    try (BufferedWriter bw = new BufferedWriter(new FileWriter(productList, true))) {
//      bw.write(new Product(1, Name.LG, Type.MICROWAVE, 100,
//          new GregorianCalendar(2014, Calendar.DECEMBER, 24)).toString() + "\n");
//      bw.write(new Product(2, Name.PHILLIPS, Type.MICROWAVE, 100,
//          new GregorianCalendar(2014, Calendar.MAY, 24)).toString() + "\n");
//      bw.write(new Product(3, Name.SONY, Type.MICROWAVE, 100,
//          new GregorianCalendar(2014, Calendar.SEPTEMBER, 24)).toString() + "\n");
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }

  public void createPurchaseFile() {

  }

}
