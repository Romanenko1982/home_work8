package service;

import exeptions.NotEnoughMoneyInTheAccount;
import exeptions.NotSearchedProductByID;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Customer;
import model.Name;
import model.Product;
import model.Type;
import view.CustomerPurchaseList;

public class ProductService {

  private static HashMap<Integer, Product> mapProducts;
  private HashMap<Integer, Product> mapPurchaseProducts;
  transient private Scanner scanner;

  private File listProductsFromFile;

  {
    listProductsFromFile = new File("ListProductsHand.txt");
    mapPurchaseProducts = new HashMap<>();
  }

  public ProductService(HashMap<Integer, Product> mapPurchaseProducts) {
    this.mapPurchaseProducts = mapPurchaseProducts;
  }

  public ProductService() {
    this.scanner = new Scanner(System.in);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ProductService - ");
    sb.append("mapPurchaseProducts - ").append(mapPurchaseProducts);
    return sb.toString();
  }

  public LinkedList<String> createLinkedListProducts() {
    LinkedList<String> listProducts = new LinkedList<>();
    String var;
    try (BufferedReader br = new BufferedReader(new FileReader(listProductsFromFile))) {
      while ((var = br.readLine()) != null) {
        listProducts.add(var);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return listProducts;
  }

  public HashMap<Integer, Product> createMapProducts() {
    if (mapProducts == null) {
      mapProducts = new HashMap<>();
      for (String productString : createLinkedListProducts()) {
        Product product = parseProduct(productString);
        mapProducts.put(product.getID(), product);
      }
    }
    return mapProducts;
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
    int cost = (Integer.parseInt(arrayProduct[3].substring(var + 1)));
    var = arrayProduct[4].lastIndexOf(" ");
    String[] dateString = arrayProduct[4].substring(var + 1).split("\\.");
    Calendar date = new Calendar.Builder().setDate(Integer.parseInt(dateString[0]),
        Integer.parseInt(dateString[1]), Integer.parseInt(dateString[2])).build();
    return new Product(id, name, type, cost, date);
  }

  public void showProducts() {
    System.out.println("PRODUCTS:\n");
    for (String product : createLinkedListProducts()) {
      System.out.println(parseProduct(product));
    }
    System.out.println();
  }

  public void createOrderProducts() {
    System.out
        .println("Input ID product, if you want to buy same products than write ID with space.");
    scanner = new Scanner(System.in);
    Customer customer = new CustomerService().getCustomer();
    String var = scanner.nextLine();
    String[] array = var.trim().split(" +");
    try {
      List<Product> products = searchProductByID(array);
      if (sumCostProducts(products) > customer.getAmountOfMoney()) {
        throw new NotEnoughMoneyInTheAccount();
      }
      customer.setAmountOfMoney(customer.getAmountOfMoney() - sumCostProducts(products));
      for (Product product : products) {
        createMapProducts().remove(product.getID());
      }
      new CustomerService().getCustomers().replace(customer.getLogin(), customer);
      for (Product product : products) {
        mapPurchaseProducts.put(product.getID(), product);
      }
      new CustomerPurchaseList(customer, mapPurchaseProducts).createSerializationPurchaseList();
      rewriteProducts();
      new CustomerService().rewriteCustomers();
//      createFileOfCustomerPurchase(mapPurchaseProducts);
    } catch (NotEnoughMoneyInTheAccount e) {
      System.out.println("Not enough money in the account.");
    }
  }

//  public void createFileOfCustomerPurchase(HashMap<Integer, Product> mapPurchaseProducts) {
//    String nameFile = new CustomerService().getCustomer().getLogin() + "_purchase.txt";
//    File file = new File(nameFile);
//    if (!file.exists()) {
//      try {
//        file.createNewFile();
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//    }
//    try (FileWriter fw = new FileWriter(file, true)) {
//      BufferedWriter bw = new BufferedWriter(fw);
//      for (Product var : mapPurchaseProducts.values()) {
//        bw.write(var.toString() + "\n");
//      }
//      bw.flush();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }

  public void rewriteProducts() {
    HashMap<Integer, Product> var = new ProductService().createMapProducts();
    try (FileWriter fwProduct = new FileWriter("ListProductsHand.txt")) {
      BufferedWriter bw = new BufferedWriter(fwProduct);
      for (Map.Entry<Integer, Product> product : var.entrySet()) {
        bw.write(product.getValue().toString() + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private int sumCostProducts(List<Product> list) {
    int sum = 0;
    for (Product product : list) {
      sum += product.getCost();
    }
    return sum;
  }

  public List<Product> searchProductByID(String... id) {
    List<Product> list = new LinkedList<>();
    for (String s : id) {
      if (createMapProducts().containsKey(Integer.parseInt(s))) {
        list.add(createMapProducts().get(Integer.parseInt(s)));
      } else {
        try {
          throw new NotSearchedProductByID();
        } catch (NotSearchedProductByID e) {
          System.out.println("Product with " + s + " not found.");
        }
      }
    }
    return list;
  }

//  public void showPurchaseFile() {
//    String nameFile = new CustomerService().getCustomer().getLogin() + "_purchase.txt";
//    if (!(new File(nameFile).exists())) {
//      System.out.println("No purchases previously made.");
//    } else {
//      try (FileReader fr = new FileReader(nameFile)) {
//        BufferedReader br = new BufferedReader(fr);
//        String var;
//        while ((var = br.readLine()) != null) {
//          System.out.println(var);
//        }
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//    }
//  }


  //С сериализацией
  public void showPurchaseFile() {
    String nameFile = new CustomerService().getCustomer().getLogin() + "_serializationlist.txt";
    if (!(new File(nameFile).exists())) {
      System.out.println("No purchases previously made.");
    } else {
      HashMap<Integer, Product> map = new CustomerPurchaseList(new CustomerService().getCustomer(),
          mapPurchaseProducts).getDeserializationPurchaseList();
      for (Product product : map.values()) {
        System.out.println(product);
      }
    }
  }
}
