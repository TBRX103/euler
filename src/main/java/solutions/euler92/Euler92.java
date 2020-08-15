package solutions.euler92;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Euler92 {

  private static final HashSet<Integer> confirmedNumbers = new HashSet<>();
  private static final HashSet<Integer> setOne = new HashSet<>();
  private static int eightyNineCount = 0;

  static {
    confirmedNumbers.add(85);
    confirmedNumbers.add(89);
    confirmedNumbers.add(145);
    confirmedNumbers.add(42);
    confirmedNumbers.add(20);
    confirmedNumbers.add(4);
    confirmedNumbers.add(16);
    confirmedNumbers.add(37);
    confirmedNumbers.add(58);
    setOne.add(1);
    setOne.add(10);
    setOne.add(100);
    setOne.add(1000);
  }

  public static void main(String[] args) {
    List<Integer> currentWorkingSet = new ArrayList<>();
    IntStream.range(1, 10000000).forEach(i -> {
          currentWorkingSet.clear();
          int copy = i;

          final int baseDigitSquareSum = digitSquareSumOf(copy);
          currentWorkingSet.add(baseDigitSquareSum);

          boolean matchesEightyNine = matchesEightyNine(copy);
          boolean matchesOne = matchesOne(copy);

          while (copy > 0 && !matchesEightyNine && !matchesOne) {
            copy = digitSquareSumOf(copy);
            matchesEightyNine = matchesEightyNine(copy);
            matchesOne = matchesOne(copy);
          }

          if (matchesOne) {
            setOne.add(i);
            setOne.add(baseDigitSquareSum);
            return;
          }

          if (matchesEightyNine) {
            eightyNineCount++;
            confirmedNumbers.add(i);
            confirmedNumbers.add(baseDigitSquareSum);
            return;
          }
        }
    );
    System.out.println("89 count " + eightyNineCount);
  }

  public static boolean matchesEightyNine(int i) {
    if (confirmedNumbers.contains(i)) {
      return true;
    }
    return false;
  }

  public static boolean matchesOne(int i) {
    if (setOne.contains(i)) {
      return true;
    }

    return false;
  }

  public static int digitSquareSumOf(int i) {
    int copy = i;
    int sum = 0;
    while (copy > 0) {
      int digit = copy % 10;
      sum += digit * digit;
      copy = copy / 10;
    }
    return sum;
  }

}
