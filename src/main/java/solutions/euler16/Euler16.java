/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package solutions.euler16;

/**
 * @author Ben
 */

import java.math.BigInteger;

public class Euler16 {


  public static void main(String[] args) {

    BigInteger answer = BigInteger.valueOf(2);
    int x = 999;
    while (x > 0) {
      answer = answer.multiply(BigInteger.valueOf(2));
      System.out.println(answer);
      x--;
    }
    String boom;
    boom = answer.toString();
    x = 0;
    int sum = 0;
    while (x < boom.length()) {
      sum += Integer.parseInt(boom.substring(x, x + 1));
      x++;

    }

    System.out.println(sum);
  }

}
