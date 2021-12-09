package ds.array;

import java.util.Arrays;
import java.util.HashMap;

public class LargestSubArrayOfEqualZeroOne {

    public static void solve(int[] arr1, int n) {

        int[] arr = Arrays.copyOf(arr1, n);
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = -1;
        int start = 0;
        int end = -1;
        map.put(arr[0], 0);
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i];
            if (arr[i] == 0) {
                max = i;
                end = i;
            }
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i])) {
                int length = i - map.get(arr[i]);
                if (length > max) {
                    start = map.get(arr[i]) + 1;
                    end = i;
                    max = length;
                }
            }
        }


        for (int i = start; i < end; i++) {
            System.out.println("Index i : " + i + " and value : " + arr1[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 0, 1, 0, 1, 1};
        int size = arr.length;
        LargestSubArrayOfEqualZeroOne.solve(arr, size);
    }
}
