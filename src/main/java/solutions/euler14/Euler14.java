/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solutions.euler14;

/**
 * @author Ben
 */
public class Euler14 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    long hold;
    long chainPeak = 0;
    long peakNumber = 0;
    long index;
    int chain = 0;

    for (index = 2; index <= 1000000; index++) {
      hold = index;
      chain = 1;

      while (hold != 1) {
        if (hold % 2 == 0) // Even number
        {
          hold = hold / 2;
        } else  // Odd Number
        {
          hold = hold * 3 + 1;
        }

        chain++;
      }

      if (chain > chainPeak) {
        peakNumber = index;
        chainPeak = chain;
      }
    }

    System.out.println("The Highest Number is " + peakNumber +
        " With a chain of " + chainPeak);
  }
}


