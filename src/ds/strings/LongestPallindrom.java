package ds.strings;

import java.util.Scanner;

public class LongestPallindrom {

    String longestPallindrom(String input) {
        String out = "";

        if (input == null || input.length() < 2) {
            return input;
        }
        boolean[][] table = new boolean[input.length()][input.length()];

        for (int i = 0; i < input.length(); i++) {
            table[i][i] = true;
        }

        char[] chars = input.toCharArray();
        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < input.length() - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= chars.length; k++) {
            for (int i = 0; i < chars.length - k + 1; i++) {
                int j = i + k - 1;
                if (table[i + 1][j - 1] == true && chars[i] == chars[j]) {
                    table[i][j] = true;
                    if(k>maxLength){
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        out = input.substring(start,start+maxLength);
        return out;
    }

    public static void main(String[] args) {
        String str1 = "aldshflasghdfasgfkhgasdfasdgvfyweofyewyrtyefgv";
        String out = new LongestPallindrom().longestPallindrom(str1);
        System.out.println(out.length());
        Scanner scanner = new Scanner(System.in);
        String count = scanner.nextLine();
        try {
            int counter = Integer.parseInt(count);
            for (int i = 0; i < counter; i++) {
                String input = scanner.nextLine();
                System.out.println( new LongestPallindrom().longestPallindrom(input).length());
            }
        } catch (Exception e) {

        }
    }
}
