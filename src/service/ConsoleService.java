package service;

import java.io.File;
import java.util.Scanner;
import model.Customer;

public class ConsoleService {

  private Customer customer;
  private Scanner scanner;
  //  private File userDataBase;
  private File productList;
  private File productListHand;
  private CustomerService cs;
  private ProductService ps;


  public ConsoleService() {
    scanner = new Scanner(System.in);
    cs = new CustomerService();
    ps = new ProductService();
  }

  public void console() {
    cs.CreateFileUsers();
    mainMenu();
//    exit();
  }

  private void exit() {
    scanner.close();
    System.exit(0);
  }

  private void printViewMainConsole() {
    System.out.println("Hello user, select the procedure you need:\n");
    System.out.println("1. Registration.");
    System.out.println("2. Login/Password.");
    System.out.println("3. Exit.\n");
  }

  public void mainMenu() {
    printViewMainConsole();
    if (scanner.hasNextInt()) {
      int var = scanner.nextInt();
      switch (var) {
        case 1:
          cs.createUser();
          break;
        case 2:
          cs.loginUser();
          break;
        case 3:
          exit();
        default:
          System.out.println("Invalid menu value selected. Try again.\n");
          mainMenu();
      }
      subMenu();
    } else {
      System.out.println("Invalid input. Try again.\n");
      scanner.next();
      mainMenu();

    }
  }

  private void printViewSubMenu() {
    System.out.println("1. Show product list.");
    System.out.println("2. Create order.");
    System.out.println("3. Create my purchases file.");
    System.out.println("4. Transfer money to a card.");
    System.out.println("5. Exit.");
  }

  public void subMenu() {
//    scanner = new Scanner(System.in);
    printViewSubMenu();

    if (scanner.hasNextInt()) {
      int var = scanner.nextInt();
      switch (var) {
        case 1:
          ps.showProductList();
          break;
        case 2:
          ps.createOrderProducts();
          break;
        case 3:
          ps.createPurchaseFile();
          break;
        case 4:
//          ps.transferMoneyToCard();
          break;
        case 5:
          mainMenu();
          break;
        case 6:
          exit();
        default:
          System.out.println("Invalid menu value selected.\n");
      }
      subMenu();
    }
  }


}