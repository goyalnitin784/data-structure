package ds.strings;

import java.util.Stack;

public class RemoveAdjacentDuplicateFromAString {
    public static void main(String[] args) {
        String str1 = "acaaabbbacdddd";
        System.out.println(remove(str1));
    }

    private static String display(Stack<Character> characters) {
        if (characters.isEmpty()) {
            return "";
        }
        char c = characters.pop();
        return display(characters) + c;
    }

    private static String remove(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        Stack<Character> stack = new Stack<>();
        int i=0;
        while(true){
            if(i>=s.length()){
                break;
            }
            if (stack.isEmpty()) {//azxxzy
                stack.push(s.charAt(i));
                i++;
            } else {
                boolean repeat = false;
                while ( i < s.length() && stack.peek() == s.charAt(i)) {
                    i++;
                    repeat = true;
                }
                if (repeat) {
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                    i++;
                }
            }

        }
        return display(stack);
    }

}
