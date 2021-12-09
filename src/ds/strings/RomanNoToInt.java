package ds.strings;

public class RomanNoToInt {
    private int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    public int romanToInt(String s) {
        if (s == null || s.equalsIgnoreCase("")) {
            return -1;
        }
        if (s.length() == 1) {
            return value(s.charAt(0));
        }
        int output = 0;
        int i = 0;
        for (i = 0; i <= s.length() - 2; i++) {
            if (value(s.charAt(i)) < value(s.charAt(i + 1))) {
                output = output + value(s.charAt(i + 1)) - value(s.charAt(i));
                i++;
            } else {
                output += value(s.charAt(i));
            }
        }
        if (i < s.length()) {
            output += value(s.charAt(s.length() - 1));
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(new RomanNoToInt().romanToInt("XX"));
    }
}
