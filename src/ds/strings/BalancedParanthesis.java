package ds.strings;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {

    public void check(String string) {
        if (string == null || string.isEmpty()) {
            System.out.println("not balanced");
            return;
        }
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (!validLeft(string.charAt(i)) && !validRight(string.charAt(i))) {
                System.out.println("not balanced");
                return;
            } else {
                if (validLeft(string.charAt(i))) {
                    characters.push(string.charAt(i));
                } else {
                    if(characters.isEmpty()){
                        System.out.println("not balanced");
                        return;
                    }
                    if (!match(characters.pop(), string.charAt(i))) {
                        System.out.println("not balanced");
                        return;
                    }
                }
            }
        }
        if (characters.isEmpty()) {
            System.out.println("balanced");
        } else {
            System.out.println("not balanced");
        }

    }

    public boolean validLeft(char c) {
        if (c == '{' || c == '(' || c == '[') {
            return true;
        }
        return false;
    }

    public boolean validRight(char c) {
        if (c == '}' || c == ')' || c == ']') {
            return true;
        }
        return false;
    }


    public boolean match(Character c1, Character c2) {

        if (c1 == null || c2 == null) {
            return false;
        }

        if (c1 == '{' && c2 == '}') {
            return true;
        }
        if (c1 == '(' && c2 == ')') {
            return true;
        }
        if (c1 == '[' && c2 == ']') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str1 = "]}(}}";
        new BalancedParanthesis().check(str1);
        Scanner scanner = new Scanner(System.in);
        String count = scanner.nextLine();
        try {
            int counter = Integer.parseInt(count);
            for (int i = 0; i < counter; i++) {
                String input = scanner.nextLine();
                new BalancedParanthesis().check(input);
            }
        } catch (Exception e) {

        }

    }

}
