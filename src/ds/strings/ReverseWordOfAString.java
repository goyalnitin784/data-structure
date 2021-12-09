package ds.strings;

//Input  : s = "geeks quiz practice code"
//Output : s = "code practice quiz geeks"

import java.util.Scanner;

public class ReverseWordOfAString {


    public static String reverse(String original) {
        if (original == null || original.length() < 2) {
            return original;
        }
        char[] chars = original.toCharArray();

        int begin = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseUtil(chars, begin, i - 1);
                begin = i + 1;
            }
        }
        if (begin != 0) {
            reverseUtil(chars, begin, original.length() - 1);
            return reverseUtil(chars, 0, original.length() - 1);
        }
        return original;
    }

    private static String reverseUtil(char[] chars, int begin, int end) {
        if (chars == null) {
            return null;
        }
        if (chars.length < 2) {
            return new String(chars);
        }
        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        // String original = "geeks quiz practice code";
        // String output = new ReverseWordOfAString().reverse(original);
        //System.out.println(output);
        Scanner scanner = new Scanner(System.in);
        String count = scanner.nextLine();
        try {
            int counter = Integer.parseInt(count);
            for (int i = 0; i < counter; i++) {
                String input = scanner.nextLine();
                System.out.println(new ReverseWordOfAString().reverse(input));
            }
        } catch (Exception e) {

        }

    }


}
