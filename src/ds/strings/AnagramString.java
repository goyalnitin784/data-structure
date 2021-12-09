package ds.strings;

import java.util.HashMap;
import java.util.Scanner;

//Given two strings a and b consisting of lowercase characters.
// The task is to check whether two given strings are anagram of each other or not.
// An anagram of a string is another string that contains same characters, only the order of characters can be different.
// For example, “act” and “tac” are anagram of each other.
public class AnagramString {
    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        String str2 = "forgeeksgeeks";
        new AnagramString().anagrams(str1,str2);
//        Scanner scanner = new Scanner(System.in);
//        String count = scanner.nextLine();
//        try{
//            int counter = Integer.parseInt(count);
//            for(int i=0;i<counter;i++){
//                String input = scanner.nextLine();
//                String[] inputArr = input.split(" ");
//                new AnagramString().anagrams(inputArr[0],inputArr[1]);
//            }
//
//        }catch (Exception e){
//
//        }

    }

    public void anagrams(String str1, String str2) {
        if (str1 == null && str2 != null) {
            System.out.println("NO");
        }
        if (str2 == null && str1 != null) {
            System.out.println("NO");
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            if (map.containsKey(str1.charAt(i))) {
                map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
            }else{
                map.put(str1.charAt(i),1);
            }
        }

        boolean anagrams = true;
        for (int i = 0; i < str2.length(); i++) {
            if (!map.containsKey(str2.charAt(i))) {
                anagrams = false;
                break;
            } else {
                if (map.get(str2.charAt(i)) == 1) {
                    map.remove(str2.charAt(i));
                } else {
                    map.put(str2.charAt(i), map.get(str2.charAt(i)-1));
                }

            }
        }
        if (anagrams && map.size()==0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

}
