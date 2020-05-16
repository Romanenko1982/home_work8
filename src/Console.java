import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Console {

  private Customer customer;
  private Scanner scanner = new Scanner(System.in);
  private File userDataBase = new File("UserDataBase.txt");

  public void startConsole() {

    System.out.println("Hello user, select the procedure you need:\n");
    System.out.println("1. Registration.");
    System.out.println("2. Login/Password.");
    System.out.println("3. Exit.\n");

    if (scanner.hasNextInt()) {
      int var = scanner.nextInt();
      switch (var) {
        case 1:
          createUser();
          break;
        case 2:
          loginUser();
          break;
        case 3:
          exit();
        default:
          System.out.println("Invalid menu value selected. Try again.\n");
          startConsole();
      }
      menu();
    } else {
      System.out.println("Invalid input. Try again.\n");
      startConsole();
    }
  }

  public void exit() {
    System.exit(0);
  }

  public void createUser() {
    customer = new Customer();
    System.out.println("Input login:");
    String login;
    login = this.scanner.nextLine();
    if (isUserLoginContainsDataBaseUsers(customer)) {
      System.out.println("User " + login + " already exists, use a different login.");

    } else {
      customer.setLogin(login);
      System.out.println("Input password:");
      String password = this.scanner.nextLine();
      customer.setLogin(password);
      addUserDataBaseUsers(customer);
      System.out.println("User created successfully.");
      menu();
    }
  }

  public void loginUser() {
    customer = new Customer();
    System.out.println("Input login:");
    String login = this.scanner.nextLine();
    customer.setLogin(login);
    if (isUserLoginContainsDataBaseUsers(customer)) {
      System.out.println("Input password:");
      String password = this.scanner.nextLine();
      customer.setLogin(password);
      if (isUserContainsDataBaseUsers(customer)) {
        System.out.println("Login successfully.");
        menu();
      } else {
        System.out.println("Wrong password, try again.");
        loginUser();
      }
    } else {
      System.out.println("Try again! Wrong data!");
      loginUser();
    }
  }


  private void addUserDataBaseUsers(Customer customer) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(userDataBase, true))) {
      bw.write("Login " + customer.getLogin() + " " + "Password " + customer.getPassword() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private boolean isUserLoginContainsDataBaseUsers(Customer customer) {
    try (BufferedReader br = new BufferedReader(new FileReader(userDataBase))) {
      String var;
      while ((var = br.readLine()) != null) {
        if (var.contains(customer.getLogin())) {
          return true;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  private boolean isUserContainsDataBaseUsers(Customer customer) {
    try (BufferedReader br = new BufferedReader(new FileReader(userDataBase))) {
      String var;
      while ((var = br.readLine()) != null) {
        if (var.equals(customer.getLogin() + " " + customer.getPassword())) {
          return true;
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  // А если тут сделать проверку user через Scanner, а не через поток?
//  private boolean userContainsDataBaseUsers(Customer customer) {
//    try (Scanner scan = new Scanner(userDataBase)) {
//      while (scan.hasNextLine()) {
//        String var = scan.nextLine();
//        if (var.equals(customer.getLogin() + " " + customer.getPassword())) {
//          return true;
//        }
//      }
//    } catch (FileNotFoundException e) {
//      e.printStackTrace();
//    }
//    return false;
//  }

  public void menu() {

    System.out.println("1. Show purchases list.");
    System.out.println("2. Create order.");
    System.out.println("3. Create my purchases file.");
    System.out.println("4. Exit.");

    if (scanner.hasNextInt()) {
      int var = scanner.nextInt();
      switch (var) {
        case 1:
          createPurchaseList();
          break;
        case 2:
          createOrder();
          break;
        case 3:
          createPurchaseFile();
        case 4:
          exit();
        default:
          System.out.println("Invalid menu value selected.\n");
      }
      menu();
    }
  }

  public void createPurchaseList() {

  }

  public void createOrder() {
  }

  public void createPurchaseFile() {
  }
}
