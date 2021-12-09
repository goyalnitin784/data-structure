package ds.array;

import java.util.HashMap;
import java.util.Map;

public class MostFrequestWordUsed {

    static int maxCount = -1;

    public static void main(String[] args) {
        String arr[] = {"geeks", "for", "geeks", "a",
                "portal", "to", "learn", "can",
                "be", "computer", "science",
                "zoom", "yup", "fire", "in",
                "be", "data", "geeks"};


        Map<String, Integer> data = new HashMap<>();

        for (String str : arr) {
            if (data.containsKey(str)) {
                data.put(str, data.get(str) + 1);
            } else {
                data.put(str, 1);
            }
            if (maxCount < data.get(str)) {
                maxCount = data.get(str);
            }
        }

    }
}
