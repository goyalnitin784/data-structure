package ds.array;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    static void printMax(int arr[], int n, int k) {

        Deque<Integer> q = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            while (!q.isEmpty() && q.peekLast() < arr[i]) {
                q.pollLast();
            }
            q.add(i);
        }

        for (int i = k; i < n; i++) {
            System.out.println(arr[q.peekFirst()]);

            while (!q.isEmpty() && q.peekFirst()<(i-k)) {
                q.poll();
            }

            while (!q.isEmpty() && q.peekLast() < arr[i]) {
                q.pollLast();
            }

            q.add(i);
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        printMax(arr, arr.length, k);
    }
}
