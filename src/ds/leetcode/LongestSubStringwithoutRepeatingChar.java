package ds.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringwithoutRepeatingChar {

  public static void main(String[] args) {
    int out = new LongestSubStringwithoutRepeatingChar().lengthOfLongestSubstring("abbbbbaaca");
    System.out.println(out);
  }

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    int maxLength = 0;
    Map<Character, Integer> positionMap = new HashMap<>();
    int start = 0;
    int end = 0;
    for (int i = 0; i < s.length(); i++) {
      if (positionMap.containsKey(s.charAt(i))) {
        start = (start > positionMap.get(s.charAt(i))) ? start : (positionMap.get(s.charAt(i)) + 1);
      }
      end++;
      positionMap.put(s.charAt(i), i);
      if ((end - start) > maxLength) {
        maxLength = end - start;
      }
    }
    return maxLength;
  }
}
