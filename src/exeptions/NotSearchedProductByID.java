package exeptions;

public class NotSearchedProductByID extends Exception {

  public NotSearchedProductByID() {
    super();
  }

  public NotSearchedProductByID(String message) {
    super(message);
  }
}
