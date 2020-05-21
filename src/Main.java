import java.text.SimpleDateFormat;
import java.util.Calendar;

//import java.util.Calendar.Builder;

public class Main {

  public static void main(String[] args) {

//    Console console = new Console();
//    console.startConsole();

//    GregorianCalendar gregorianCalendar = new GregorianCalendar(2015, Calendar.DECEMBER, 21);
//    SimpleDateFormat sf = new SimpleDateFormat("dd.MM.y");
//    System.out.println(sf.format(gregorianCalendar.getTime()));

       Product product = new Product(1, "dkfjv", Type.FREEZER, 100,
        new Calendar.Builder().setDate(2015, Calendar.OCTOBER, 21).build());
    System.out.println(product);


  }

}
