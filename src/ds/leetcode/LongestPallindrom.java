package ds.leetcode;

public class LongestPallindrom {

  public static void main(String[] args) {
    String s = "nitingoeln";
    System.out.println(new LongestPallindrom().longestPalindrome(s));
  }

  public String longestPalindrome(String s) {

    int start = 0;
    int length = 0;

    boolean[][] arr = new boolean[s.length()][s.length()];

    for (int i = 0; i < arr.length; i++) {
      arr[i][i] = true;
      length = 1;
    }
    for (int i = 0; i < arr.length - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        arr[i][i + 1] = true;
        start = i;
        length = 2;
      }
    }

    for (int k = 3; k <= s.length(); k++) {
      for (int i = 0; i < s.length() - k + 1; i++) {
        int j = i + k - 1;
        if (arr[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
          arr[i][j] = true;
          if (length < k) {
            length = k;
            start = i;
          }
        }
      }
    }
    return s.substring(start, start + length);
  }
}
