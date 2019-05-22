package ds.array;

public class MissingAndRepeatedNumber {
    static void printTwoElements(int arr[], int size) {


        int repeatingNumber = -1;
        int missingNumber = -1;
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];

            if (index < 0) {
                index = -index;
            }
            if (arr[index - 1] < 0) {
                repeatingNumber = index;
            } else {
                arr[index - 1] = -arr[index - 1];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                missingNumber = i;
            }
        }

        System.out.println(repeatingNumber + " is the repeating number");
        System.out.println(missingNumber + " is the missing number");
    }

    public static void main(String[] args) {
        int arr[] = {7, 3, 4, 5, 5, 6, 2};
        int n = arr.length;
        printTwoElements(arr, n);
    }

}
