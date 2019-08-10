package solutions.euler52;

public class Euler52 {

  public static void main(String[] args) {
    boolean areEqual = false;
    int[] baseArray;
    for (int i = 1; i <= 999999999; i++) {
      baseArray = getDigits(i, 2);

      for (int j = 3; j <= 6; j++) {
        areEqual = compareDigits(baseArray, getDigits(i, j));
        if (!areEqual) {
          break;
        }
      }
      if (areEqual) {
        System.out.println("Number found! " + i);
        return;
      }
    }

  }

  public static int[] getDigits(int num, int mul) {
    int[] arr;
    arr = new int[10];
    num = num * mul;
    while (num > 0) {
      arr[num % 10]++;
      num /= 10;
    }

    return arr;

  }

  public static boolean compareDigits(int[] a1, int[] a2) {
    for (int i = 0; i <= 9; i++) {
      if (a1[i] != a2[i]) {
        return false;
      }
    }
    return true;
  }
}
