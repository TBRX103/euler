package solutions.euler7;

public class Euler7 {

  private static int primecount = 0;
  private static int answer = 0;

  private static int workwith = 2;
  private static int findNumber = 10001;
  private static int count = 0;

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    while (primecount != findNumber) {
      findAnswer();
      workwith++;
    }
    System.out.println(answer);
    System.out.println(count);
  }

  public static void findAnswer() {
    int x = 0;
    for (x = 2; x < workwith; x++) {

      if (workwith % x == 0) {
        return;
      }
    }

    primecount++;

    if (primecount == findNumber) {
      answer = workwith;
    }
  }

}
