package view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import model.Customer;
import model.Product;

public class CustomerPurchaseList implements Serializable {

  private Customer customer;
  private HashMap<Integer, Product> map;

  public CustomerPurchaseList(Customer customer,
      HashMap<Integer, Product> map) {
    this.customer = customer;
    this.map = map;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CustomerPurchaseList{");
    sb.append("customer=").append(customer);
    sb.append(", mapPurchaseProducts=").append(map);
    sb.append('}');
    return sb.toString();
  }

  public void createSerializationPurchaseList() {
    try (FileOutputStream fos = new FileOutputStream(customer.getLogin() + "_serializationlist.txt",
        true)) {
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(map);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public HashMap<Integer, Product> getDeserializationPurchaseList() {
    try (FileInputStream fis = new FileInputStream(
        customer.getLogin() + "_serializationlist.txt")) {
      ObjectInputStream ois = new ObjectInputStream(fis);
      try {
        return (HashMap<Integer, Product>)ois.readObject();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }


}

