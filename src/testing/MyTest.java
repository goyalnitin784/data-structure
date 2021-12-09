package testing;

import java.util.Arrays;

public class MyTest {

  public static void main(String[] args) {
    process("DC501GCCCA098911");
  }

  public static void process(String s) {

    if (s == null || s.isEmpty()) {
      return;
    }
    char[] chars = s.toCharArray();
    int n = chars.length;
    int i = 0;
    boolean charCondition = false;
    boolean digitCondition = false;
    while (i < n) {
      charCondition = false;
      digitCondition = false;
      int begin = i;
      while (i < n && Character.isAlphabetic(chars[i])) {
        i++;
        charCondition = true;
      }
      if (charCondition) {
        Arrays.sort(chars, begin, i);
      }
      begin = i;
      while (i < n && Character.isDigit(chars[i])) {
        i++;
        digitCondition = true;
      }
      if (digitCondition) {
        Arrays.sort(chars, begin, i);
      }
    }
    System.out.println(new String(chars));

  }

}
