package ds.strings;

public class AllPermutationOfAString {

    private void perm(String s, int left, int right) {
        if (left == right) {
            System.out.println(s);
        }
        for (int i = left; i <= right; i++) {
            s = swap(s, left, i);
            perm(s, left + 1, right);
            s = swap(s, left, i);
        }
    }

    private String swap(String s, int a, int b) {
        char[] c = s.toCharArray();
        char temp = s.charAt(a);
        c[a] = s.charAt(b);
        c[b] = temp;
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        String s = "abc";
        new AllPermutationOfAString().perm(s, 0, s.length() - 1);
    }

}
