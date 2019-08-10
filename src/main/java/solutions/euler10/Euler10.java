package solutions.euler10;

public class Euler10 {

  private static long answer = 0;
  private static long workwith = 2;

  public static void main(String[] args) {

    while (workwith < 2000000) {
      findAnswer();
      workwith++;

    }

    System.out.println(answer);
  }

  public static void findAnswer() {
    long x = 0;
    for (x = 2; x < workwith; x++) {

      if (workwith % x == 0) {
        return;
      }
    }

    answer += workwith;
  }
}
