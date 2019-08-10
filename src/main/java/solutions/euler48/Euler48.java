/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package solutions.euler48;

/**
 * @author Ben
 */

import java.math.BigDecimal;

public class Euler48 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    BigDecimal answer = BigDecimal.valueOf(0);
    int x = 1;
    BigDecimal answer2;

    for (x = 1; x <= 1000; x++) {
      answer2 = BigDecimal.valueOf(x);
      answer2 = answer2.pow(x);
      answer = answer.add(answer2);
    }
    System.out.println(answer.toString());
  }


}
