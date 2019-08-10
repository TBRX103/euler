package solutions.euler6;

public class Euler6 {

  public static void main(String[] args) {
    int x;
    long sum = 0;
    long hold = 0;

    for (x = 1; x <= 100; x++) {
      sum += Math.pow(x, 2);
    }
    for (x = 1; x <= 100; x++) {
      hold += x;
    }
    System.out.println(Math.pow(hold, 2));
    hold = hold * hold;
    System.out.println(hold - sum);
  }
}
