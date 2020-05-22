package view;

import service.ConsoleService;

public class Console {

//  private Customer customer;
//  private Scanner scanner;
//  private File userDataBase;
//  private File productList;
//  private File productListHand;
//  private CustomerService cs;
//  private ProductService ps;
//  private ConsoleService console;

  {
//    userDataBase = new File("UserDataBase.txt");
//    productList = new File("ProductList.txt");
//    productListHand = new File("ProductListHand.txt");
  }

//  public view.Console() {
////    this.scanner = new Scanner(System.in);
//    cs = new CustomerService();
//    ps = new ProductService();
//  }

  public void startConsole() {
    ConsoleService consoleService = new ConsoleService();

//    co.CreateFileUsers();
    consoleService.console();
//    exit();
  }

//  private void console() {
//    System.out.println("Hello user, select the procedure you need:\n");
//    System.out.println("1. Registration.");
//    System.out.println("2. Login/Password.");
//    System.out.println("3. Exit.\n");
//    if (scanner.hasNextInt()) {
//      int var = scanner.nextInt();
//      switch (var) {
//        case 1:
//          cs.createUser();
//          break;
//        case 2:
//          cs.loginUser();
//          break;
//        case 3:
//          exit();
//        default:
//          System.out.println("Invalid menu value selected. Try again.\n");
//          startConsole();
//      }
//      menu();
//    } else {
//      System.out.println("Invalid input. Try again.\n");
//      startConsole();
//    }
//  }

//  private void checkIfCreatedFileUsers() {
//    if (!userDataBase.exists()) {
//      try {
//        userDataBase.createNewFile();
//      } catch (IOException e) {
//        e.printStackTrace();
//      }
//    }
//  }

//  public void createLinkedListProducts() {
//    LinkedList<String> list = new LinkedList<>();
//    String var;
//    try(FileReader fr = new FileReader(productListHand)) {
//      BufferedReader br = new BufferedReader(fr);
//      while ((var = br.readLine()) != null ) {
//        list.add(var);
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    for (String e : list) {
//      System.out.println(e);
//    }
//  }

//  private void createLinkedListUsers() {
//    LinkedList<String> list = new LinkedList<String>();
//    String var;
//    try(FileReader fr = new FileReader(userDataBase)){
//      BufferedReader br = new BufferedReader(fr);
//      while ((var = br.readLine()) != null ) {
//        list.add(var);
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//    for (String e:list) {
//      System.out.println(e);
//    }
//  }
//
//  private void exit() {
//    scanner.close();
//    System.exit(0);
//  }

//  private void createUser() {
//    scanner = new Scanner(System.in);
//    customer = new Customer();
//    System.out.println("Input login:");
//    String login = scanner.nextLine();
//    customer.setLogin(login);
//    if (isUserLoginContainsDataBaseUsers(customer)) {
//      System.out.println("User " + login + " already exists, use a different login.");
//      createUser();
//    } else {
//      System.out.println("Input password:");
//      customer.setPassword(scanner.nextLine());
//      System.out.println("Input amount of money in the account.");
//      customer.setAmountOfMoney(scanner.nextInt());
//      addUserDataBaseUsers(customer);
//      System.out.println("User created successfully.");
//      menu();
//    }
//  }

//  private void loginUser() {
//    customer = new Customer();
//    scanner = new Scanner(System.in);
//    System.out.println("Input login:");
//    String login = scanner.nextLine();
//    customer.setLogin(login);
//    if (isUserLoginContainsDataBaseUsers(customer)) {
//      System.out.println("Input password:");
//      String password = scanner.nextLine();
//      customer.setPassword(password);
//      if (isUserContainsDataBaseUsers(customer)) {
//        customer.setAmountOfMoney(parseMoney(userContainsDataBaseUsers(customer)));
//        System.out.println("Login successfully.");
//        menu();
//      } else {
//        System.out.println("Wrong password, try again.");
//        loginUser();
//      }
//    } else {
//      System.out.println("Try again! Wrong data!");
//      loginUser();
//    }
//  }

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

  // А если тут сделать проверку user через Scanner, а не через поток?
//  private boolean userContainsDataBaseUsers(model.Customer customer) {
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

//  private void menu() {
//
//    scanner = new Scanner(System.in);
//    System.out.println("1. Show product list.");
//    System.out.println("2. Create order.");
//    System.out.println("3. Create my purchases file.");
//    System.out.println("4. Transfer money to a card.");
//    System.out.println("5. Exit.");
//
//    if (scanner.hasNextInt()) {
//      int var = scanner.nextInt();
//      switch (var) {
//        case 1:
//          ps.showProductList();
//          break;
//        case 2:
//          ps.createOrderProducts();
//          break;
//        case 3:
//          ps.createPurchaseFile();
//          break;
//        case 4:
////          ps.transferMoneyToCard();
//          break;
//        case 5:
//          exit();
//          break;
//        default:
//          System.out.println("Invalid menu value selected.\n");
//      }
//      menu();
//    }
//  }

//  private void showProductList() {
//    try (BufferedReader br = new BufferedReader(new FileReader(productList))) {
//      String var;
//      while ((var = br.readLine()) != null) {
//        System.out.println(var);
//      }
//
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }

//  private void transferMoneyToCard() {
//    System.out.println("How much to add money?");
//    scanner = new Scanner(System.in);
//    int money = scanner.nextInt();
//    try (BufferedReader br = new BufferedReader(new FileReader(userDataBase))) {
//      String var;
//      int dss = customer.getAmountOfMoney();
//
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

//  private void createOrderProducts() {
//    System.out.println("Input ID product.");
//    scanner = new Scanner(System.in);
//    String product = searchProductByID(scanner.nextInt());
//  }
//
//  private String searchProductByID(int id) {
//    String var = "";
//    try (BufferedReader br = new BufferedReader(new FileReader(productList))) {
//
//      String[] array;
//      while ((var = br.readLine()) != null) {
//        array = var.split(", ");
//        if (array[0].equals("ID=" + id)) {
//          return var;
//        } else {
//          throw new NotExistProductByIDException();
//        }
//      }
//    } catch (IOException | NotExistProductByIDException e) {
//      e.printStackTrace();
//    }
//    return var;
//  }

//  private void createPurchaseFile() {
//  }

//  private String parseLoginPassword(String userDataBase) {
//    String[] array = userDataBase.split(" ");
//    return new StringBuffer(array[1]).append(array[3]).toString();
//  }

  private int parseMoney(String userDataBase) {
    String[] array = userDataBase.split(" ");
    return Integer.valueOf(array[5]);
  }


  private class NotExistProductByIDException extends Throwable {
  }
}