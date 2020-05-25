package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import model.Customer;

public class CustomerService {

  private static HashMap<String, Customer> hashMapCustomers;
  private static Customer customerObject;
  private Scanner scanner;
  private File userDataBase;

  {
    userDataBase = new File("UserDataBase.txt");
  }

  public CustomerService() {
//    this.scanner = new Scanner(System.in);
  }

  public void CreateFileUsers() {
    if (!userDataBase.exists()) {
      try {
        userDataBase.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
//        LogService.addToLog(e);
      }
    }
  }

  public HashMap<String, Customer> getCustomers() {
    if (hashMapCustomers == null) {
      hashMapCustomers = new HashMap<>();
      for (String customerString : createLinkedListUsers()) {
        String[] array = customerString.split(" ");
        hashMapCustomers
            .put(array[1], new Customer(array[1], array[3], Integer.parseInt(array[5])));
      }
    }
    return hashMapCustomers;
  }

  public void createUser() {
    scanner = new Scanner(System.in);
    System.out.println("Input login:");
    String login = scanner.nextLine();
    if (getCustomers().containsKey(login)) {
      System.out.println("User " + login + " already exists, use a different login.");
      createUser();
    } else {
      customerObject = new Customer();
      customerObject.setLogin(login);
      System.out.println("Input password:");
      customerObject.setPassword(scanner.nextLine());
      System.out.println("Input amount of money in the account.");
      customerObject.setAmountOfMoney(scanner.nextInt());
      hashMapCustomers.put(customerObject.getLogin(), customerObject);
      System.out.println("User created successfully.");
    }
  }

  private LinkedList<String> createLinkedListUsers() {
    LinkedList<String> list = new LinkedList<>();
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
      customerObject = hashMapCustomers.get(login);
      System.out.println("Input password:");
      String password = scanner.nextLine();
      if (password.equals(customerObject.getPassword())) {
        System.out.println("Login successfully.");
      } else {
        System.out.println("Wrong password, try again.");
        loginUser();
      }
    } else {
      System.out.println("Try again! Wrong data!");
      loginUser();
    }
    System.out.println();
  }

  public Customer getCustomer() {
    return customerObject;
  }

  public void transferMoneyToCard() {
    System.out.println("How much to add money?");
    scanner = new Scanner(System.in);
    customerObject.setAmountOfMoney(customerObject.getAmountOfMoney() + scanner.nextInt());
    rewriteCustomers();
  }

  public void rewriteCustomers() {
    HashMap<String, Customer> var = new CustomerService().getCustomers();
    try (FileWriter fw = new FileWriter("UserDataBase.txt")) {
      BufferedWriter bw = new BufferedWriter(fw);
      for (Customer customer : var.values()) {
        bw.write(customer.toString() + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
