package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import model.Customer;

public class ProductService {

  private Customer customer;
  private Scanner scanner;
  private File userDataBase;
  private File productList;
  private File productListHand;

  {
    userDataBase = new File("UserDataBase.txt");
    productList = new File("ProductList.txt");
    productListHand = new File("ProductListHand.txt");
  }

  public ProductService() {
    this.scanner = new Scanner(System.in);
  }

  public void createLinkedListProducts() {
    LinkedList<String> list = new LinkedList<>();
    String var;
    try(FileReader fr = new FileReader(productListHand)) {
      BufferedReader br = new BufferedReader(fr);
      while ((var = br.readLine()) != null ) {
        list.add(var);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (String e : list) {
      System.out.println(e);
    }
  }

  public void showProductList() {
    try (BufferedReader br = new BufferedReader(new FileReader(productList))) {
      String var;
      while ((var = br.readLine()) != null) {
        System.out.println(var);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void createOrderProducts() {
    System.out.println("Input ID product.");
    scanner = new Scanner(System.in);
    String product = searchProductByID(scanner.nextInt());
  }

  public String searchProductByID(int id) {
    String var = "";
    try (BufferedReader br = new BufferedReader(new FileReader(productList))) {

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

  public void createPurchaseFile() {
  }

}
