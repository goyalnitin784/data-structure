package ds.array;

import java.util.Scanner;

public class Subarraysum {
    /*
    * Print Starting and end index of the sub array
    * */
    static void subArraySum(int arr[], int n, int sum) {
        int curr_sum = arr[0], start = 0, end = 0;
        while (true) {

            if (curr_sum == sum) {
                System.out.println(start + " " + end);
                break;
            }
            if (end == n || start == n) {
                System.out.println("-1");
                break;
            }
            if (curr_sum + arr[end] < sum) {
                curr_sum = curr_sum + arr[end];
            } else {
                while (start < end) {
                    if (curr_sum - arr[start] > sum) {
                        start++;
                        curr_sum = curr_sum - arr[start];
                    }
                }
            }
            end++;
        }

    }

    public static void main(String[] args) {
        Subarraysum arraysum = new Subarraysum();
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 23;
        arraysum.subArraySum(arr, n, sum);

        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testCases; i++) {
            n = Integer.parseInt(scanner.nextLine());
            arr = new int[n];
            sum = Integer.parseInt(scanner.nextLine());
            String arryString = scanner.nextLine();
            String[] data = arryString.split(" ");
            int index = 0;
            for (String val : data) {
                arr[index] = Integer.parseInt(val);
                index++;
            }
            arraysum.subArraySum(arr, n, sum);
        }
    }
}