package solutions.euler9;

public class Euler9 {

  public static void main(String[] args) {

    long answer = 0;
    for (int a = 1; a < 1000; a++) {
      for (int b = 1; b < 1000; b++) {
        double c = (double) (a * a) + (b * b);
        c = Math.sqrt(c);
        if (a + b + c == 1000) {
          int a2 = a;
          int b2 = b;
          answer = a2 * b2 * (long) c;

        }
      }
    }
    System.out.println(answer);
  }
}
