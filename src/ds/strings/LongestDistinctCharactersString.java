package ds.strings;

import java.util.Scanner;

public class LongestDistinctCharactersString {


    public int find(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int currentLength = 1;
        int maxLen = 1;
        int[] lastOccurance = new int[256];
        for (int i = 0; i < 256; i++) {
            lastOccurance[i] = -1;
        }

        char[] input = str.toCharArray();
        lastOccurance[str.charAt(0)] = 0;

        for (int i = 1; i < str.length(); i++) {
            if (lastOccurance[input[i]] == -1) {
                currentLength++;
            } else {
                int k = lastOccurance[input[i]];
                if (i - currentLength > k) {
                    currentLength++;
                } else {
                    currentLength = i - k;
                    if (currentLength > maxLen) {
                        maxLen = currentLength;
                    }
                }
            }
            lastOccurance[input[i]] = i;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        int out = new LongestDistinctCharactersString().find(str1);
        Scanner scanner = new Scanner(System.in);
        String count = scanner.nextLine();
        try {
            int counter = Integer. parseInt(count);
            for (int i = 0; i < counter; i++) {
                String input = scanner.nextLine();
                new LongestDistinctCharactersString().find(input);
            }
        } catch (Exception e) {

        }
    }
}
