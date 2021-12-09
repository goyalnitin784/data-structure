package ds.strings;

import java.util.Scanner;

public class FormAPallindromFromAString {

    //Using Recursion
    public int check(char[] str, int begin, int end) {
        if (begin > end) {
            return 0;
        }
        if (begin == end) {
            return 0;
        }
        if (begin == end - 1) {
            if (str[begin] == str[end]) {
                return 0;
            } else {
                return 1;
            }
        }

        if (str[begin] == str[end]) {
            return check(str, begin + 1, end - 1);
        }
        return 1 + Math.min(check(str, begin, end - 1), check(str, begin + 1, end));
    }

    public int checkUsingLcs(String str) {
        int output = 0;

        if (str == null || str.length() < 2) {
            return 0;
        }
        char[] chararr = str.toCharArray();
        char[] reverseOrder = new char[str.length()];
        int j=0;
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseOrder[j++] = str.charAt(i);
        }
        int[][] data = new int[str.length() + 1][str.length() + 1];

        data[0][0] = 0;
        for (int i = 0; i < str.length() + 1; i++) {
            data[i][0] = 0;
        }
        for (int i = 0; i < str.length() + 1; i++) {
            data[0][i] = 0;
        }

        for (int i = 1; i <= str.length(); i++) {
            for (j = 1; j <= str.length(); j++) {
                if (chararr[i-1] == reverseOrder[j-1]) {
                    data[i][j] = 1 + data[i - 1][j - 1];
                } else {
                    data[i][j] = Math.max(data[i - 1][j], data[i][j - 1]);
                }
            }
        }

        output = str.length()-data[str.length()][str.length()];
        return output;

    }

    public static void main(String[] args) {
        String str1 = "abcd";
        int out = new FormAPallindromFromAString().checkUsingLcs(str1);
        Scanner scanner = new Scanner(System.in);
        String count = scanner.nextLine();
        try {
            int counter = Integer.parseInt(count);
            for (int i = 0; i < counter; i++) {
                String input = scanner.nextLine();
                new FormAPallindromFromAString().check(input.toCharArray(), 0, input.length() - 1);
                new FormAPallindromFromAString().checkUsingLcs(input);
            }
        } catch (Exception e) {

        }
    }
}
