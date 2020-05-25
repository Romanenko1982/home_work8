package service;

import java.util.Scanner;

public class ConsoleService {

  private Scanner scanner;
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
  }

  private void exit() {
    new ProductService().rewriteProducts();
    new CustomerService().rewriteCustomers();
    scanner.close();
    System.exit(0);
  }

  private void printViewMainConsole() {
    System.out.println("---------------Main MENU----------------");
    System.out.println("Hello user, select the procedure you need:\n");
    System.out.println("-----------------------------------------");
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
    System.out.println("---------------------------Sub MENU-----------------------");
    System.out.println("1. Show products.");
    System.out.println("2. Show product list.");
    System.out.println("3. Create order products.");
    System.out.println("4. Show my purchases list.");
    System.out.println("5. Transfer money to a card.");
    System.out.println("6. Exit to Main Menu\n");
  }

  public void subMenu() {
    printViewSubMenu();

    if (scanner.hasNextInt()) {
      int var = scanner.nextInt();
      switch (var) {
        case 1:
          ps.showProducts();
          break;
        case 2:
          ps.showProductList();
          break;
        case 3:
          ps.createOrderProducts();
          break;
        case 4:
          ps.createPurchaseFile();
          break;
        case 5:
          cs.transferMoneyToCard();
          break;
        case 6:
          mainMenu();
          break;
        default:
          System.out.println("Invalid menu value selected.\n");
      }
      subMenu();
    }
  }
}
