package ds.stackAndqueue;

import java.util.Scanner;
import java.util.Stack;

//Given an array A of maxSize N having distinct elements,
// the task is to find the next greater element for each element of the array in order of their appearance in the array.
// If no such element exists, output -1
//1 3 2 4--Sample Input
//3 4 4 -1--Sample Output


public class NextLargerElement {

    public static void printNextLarger(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (arr.length == 1) {
            System.out.println("-1");
            return;
        }
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[arr.length];
        stack.push(0);
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                output[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            output[stack.pop()] = -1;
        }
        String outputString = "";
        for (int i = 0; i < output.length; i++) {
            outputString = outputString + String.valueOf(output[i] + " ");
        }
        System.out.println(outputString.trim());


    }

    public static void main(String[] args) {
        NextLargerElement.printNextLarger(new int[]{11,13,21,4});
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int m = 0; m < testCases; m++) {
            int arrSize = Integer.parseInt(scanner.nextLine());
            String input = scanner.nextLine();
            int[] arr = new int[arrSize];
            String[] inputs = input.split(" ");
            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }
            NextLargerElement.printNextLarger(arr);
        }

    }
}
