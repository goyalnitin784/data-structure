package ds.strings;

public class ParseIntFunction {

    public static void main(String[] args) {
        String s = "8654";
        char[] c = s.toCharArray();
        int output = 0;
        for (int i = 0; i < c.length; i++) {
            if (isNumber(c[i])) {
                output += (Integer.valueOf(String.valueOf(c[c.length - 1 - i])) * Math.pow(10, i));
            } else {
                output = -1;
                break;
            }
        }
        System.out.println(output);
    }

    private static boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }
}
