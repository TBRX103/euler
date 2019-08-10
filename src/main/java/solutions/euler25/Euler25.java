package solutions.euler25;

import java.math.BigDecimal;

public class Euler25 {


  public static void main(String[] args) {
    BigDecimal fib1 = BigDecimal.valueOf(1);
    BigDecimal fib2 = BigDecimal.valueOf(1);

    BigDecimal fibans = BigDecimal.valueOf(0);
    long sum = 2;
    boolean fibswitch = false;
    while (fibans.precision() != 1000) {
      fibans = fib1.add(fib2);
      if (!fibswitch) {
        fib1 = fibans;
        fibswitch = true;
      } else {
        fibswitch = false;
        fib2 = fibans;
      }

      sum++;
      System.out.println(sum + ": " + fibans);
    }

    System.out.println(sum);
  }

}
