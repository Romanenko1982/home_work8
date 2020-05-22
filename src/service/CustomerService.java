package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import model.Customer;

public class CustomerService {

  private Customer customer;
  private HashMap<String, Customer> customers;
  private Scanner scanner;
  private File userDataBase;
//  private File productList;
//  private File productListHand;

  {
    userDataBase = new File("UserDataBase.txt");
//    productList = new File("ProductList.txt");
//    productListHand = new File("ProductListHand.txt");
  }

  public CustomerService() {
    this.scanner = new Scanner(System.in);
  }

  public void CreateFileUsers() {
    if (!userDataBase.exists()) {
      try {
        userDataBase.createNewFile();
      } catch (IOException e) {
//        e.printStackTrace();
        LogService.addToLog(e);
      }
    }
  }

  public HashMap<String, Customer> getCustomers() {
    if (customers == null) {
      customers = new HashMap<>();
      for (String customerString : createLinkedListUsers()) {
        String[] array = customerString.split(" ");
        customer = new Customer(array[1], array[3], Integer.parseInt(array[5]));
        customers.put(customer.getLogin(), customer);
      }
    }
    return customers;
  }

  public void createUser() {
    scanner = new Scanner(System.in);
    customer = new Customer();
    System.out.println("Input login:");
    customer.setLogin(scanner.nextLine());
    if (getCustomers().containsKey(customer.getLogin())) {
      System.out.println("User " + customer.getLogin() + " already exists, use a different login.");
      createUser();
    } else {
      System.out.println("Input password:");
      customer.setPassword(scanner.nextLine());
      System.out.println("Input amount of money in the account.");
      customer.setAmountOfMoney(scanner.nextInt());
      customers.put(customer.getLogin(), customer);
      System.out.println("User created successfully.");
    }
  }

  private LinkedList<String> createLinkedListUsers() {
    LinkedList<String> list = new LinkedList<String>();
    String var;
    try (FileReader fr = new FileReader(userDataBase)) {
      BufferedReader br = new BufferedReader(fr);
      while ((var = br.readLine()) != null) {
        list.add(var);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return list;
  }

  public void loginUser() {
    scanner = new Scanner(System.in);
    System.out.println("Input login:");
    String login = scanner.nextLine();
    if (getCustomers().containsKey(login)) {
      customer = customers.get(customer.getLogin());
      System.out.println("Input password:");
      String password = scanner.nextLine();
      if (password.equals(customer.getPassword())) {
        System.out.println("Login successfully.");
      } else {
        System.out.println("Wrong password, try again.");
        loginUser();
      }
    } else {
      System.out.println("Try again! Wrong data!");
      loginUser();
    }
  }

//  private void addUserDataBaseUsers(Customer customer) {
//    try (BufferedWriter bw = new BufferedWriter(new FileWriter(userDataBase, true))) {
//      bw.write("Login " + customer.getLogin() + " Password " + customer.getPassword() + " Money " +
//          customer.getAmountOfMoney() + "\n");
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }

//  private boolean isUserLoginContainsDataBaseUsers(Customer customer) {
//    try (BufferedReader br = new BufferedReader(new FileReader(userDataBase))) {
//      String var;
//      while ((var = br.readLine()) != null) {
//        if (var.contains(customer.getLogin())) {
//          return true;
//        }
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return false;
//  }

//  private boolean isUserContainsDataBaseUsers(Customer customer) {
//    try (BufferedReader br = new BufferedReader(new FileReader(userDataBase))) {
//      String var;
//      while ((var = br.readLine()) != null) {
//        var = parseLoginPassword(var);
//        if (var.equals(customer.getLogin() + customer.getPassword())) {
//          return true;
//        }
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return false;
//  }

//  private String userContainsDataBaseUsers(Customer customer) {
//    String var = "";
//    try (BufferedReader br = new BufferedReader(new FileReader(userDataBase))) {
//      while ((var = br.readLine()) != null) {
//        String var1 = parseLoginPassword(var);
//        if (var1.equals(customer.getLogin() + customer.getPassword())) {
//          break;
//        }
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    return var;
//  }

//  private void transferMoneyToCard() {
//    System.out.println("How much to add money?");
//    scanner = new Scanner(System.in);
//    int money = scanner.nextInt();
//    try (BufferedReader br = new BufferedReader(new FileReader(userDataBase))) {
//      String var;
//      int dss = customer.getAmountOfMoney();
//      customer.setAmountOfMoney(customer.getAmountOfMoney() + money);
//      while ((var = br.readLine()) != null) {
//        var = parseLoginPassword(var);
//        if (var.equals(customer.getLogin() + customer.getPassword())) {
//          BufferedWriter bw = new BufferedWriter(new FileWriter(userDataBase, true));
//          bw.write(
//              "Login " + customer.getLogin() + " Password " + customer.getPassword() + " Money " +
//                  customer.getAmountOfMoney() + "\n");
//          bw.flush();
//          break;
//        }
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }

//  private String parseLoginPassword(String userDataBase) {
//    String[] array = userDataBase.split(" ");
//    return new StringBuffer(array[1]).append(array[3]).toString();
//  }


//  private int parseMoney(String userDataBase) {
//    String[] array = userDataBase.split(" ");
//    return Integer.valueOf(array[5]);
//  }

}
