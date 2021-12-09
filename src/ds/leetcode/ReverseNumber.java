package ds.leetcode;

public class ReverseNumber {

  public long reverse(int x) {
    boolean negative = false;
    long finalNumber = 0;
    if (x < 0) {
      negative = true;
      x = -x;
    }
    while (x > 0) {
      Double addition = new Double((x % 10) * Math.pow(10, String.valueOf(x).length() - 1));
      if (addition > Integer.MAX_VALUE
          || (finalNumber + addition.longValue()) > Integer.MAX_VALUE) {
        return 0;
      }
      if (addition < Integer.MIN_VALUE
          || (finalNumber + addition.longValue()) < Integer.MIN_VALUE) {
        return 0;
      }
      finalNumber = finalNumber + addition.intValue();
      x = x / 10;
    }
    if (negative) {
      finalNumber = -finalNumber;
    }
    return finalNumber;
  }

  public static void main(String[] args) {
    long l = 9646324351L;
    System.out.println(new ReverseNumber().reverse(1534236469));
  }

}

