
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package solutions.euler20;

/**
 * @author Ben
 */

import java.math.BigInteger;

public class Euler20 {


  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    int x = 100;
    BigInteger digits = BigInteger.valueOf(1);
    int sum = 0;
    for (; x > 0; x--) {
      digits = digits.multiply(BigInteger.valueOf(x));

    }
    System.out.println(digits);
    x = 0;
    String solver =
        "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000";
    while (x < solver.length()) {

      sum += Integer.parseInt((solver.substring(x, x + 1)));
      x++;
    }
    System.out.println(sum);

  }

}
