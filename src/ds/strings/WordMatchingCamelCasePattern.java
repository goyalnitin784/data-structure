package ds.strings;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.*;

/*
Input:
        dict[] = ["Hi", "Hello", "HelloWorld",  "HiTech", "HiGeek",
        "HiTechWorld", "HiTechCity", "HiTechLab"]

        For pattern "HT",
        Output: ["HiTech", "HiTechWorld", "HiTechCity", "HiTechLab"]
 */
public class WordMatchingCamelCasePattern {

}

class TriNode {
    static TriNode root;
    boolean isLeafNode = false;
    TriNode[] childrens = new TriNode[26];
    List<String> words = new ArrayList<>();

    public boolean isLeafNode() {
        return isLeafNode;
    }

    public void setLeafNode(boolean leafNode) {
        isLeafNode = leafNode;
    }

    public List<String> getWords() {
        return words;
    }

    private static void insert(String word) {
        TriNode pointer = root;
        if (word == null || word.length() == 0) {
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                continue;
            }
            int index = word.charAt(i) - 'A';
            pointer.childrens[index] = new TriNode();
            pointer = pointer.childrens[index];
        }
        pointer.setLeafNode(true);
        pointer.getWords().add(word);
    }

    private static List<String> findCamelCasePattern(String pattern) {

        TriNode pointer = root;
        for (int i = 0; i < pattern.length(); i++) {
            pointer = pointer.childrens[pattern.charAt(i) - 'A'];
            if (pointer == null) {
                return null;
            }
        }
        return printAllWords(pointer);
    }

    private static List<String> printAllWords(TriNode triNode) {
        if (triNode == null || !triNode.isLeafNode()) {
            return new ArrayList<>();
        }
        List<String> output = new ArrayList<>();
        output.addAll(triNode.getWords());
        for (int i = 0; i < 26; i++) {
            output.addAll(printAllWords(triNode.childrens[i]));
        }
        return output;
    }

    static void findAllWords(List<String> dict, String pattern) {

        // construct Trie root node
        root = new TriNode();

        // Construct Trie from given dict
        for (String word : dict)
            insert(word);

        List<String> output = findCamelCasePattern(pattern);
        if (output == null || output.size() == 0) {
            System.out.println("No element found");
        } else {
            System.out.println(output.toString());
        }
    }
    public static void main(String args[]) {

        // dictionary of words where each word follows
        // CamelCase notation
        List<String> dict = Arrays.asList("Hi", "Hello",
                "HelloWorld", "HiTech", "HiGeek",
                "HiTechWorld", "HiTechCity",
                "HiTechLab");

        // pattern consisting of uppercase characters only
        String pattern = "HT";

        findAllWords(dict, pattern);
    }
}
