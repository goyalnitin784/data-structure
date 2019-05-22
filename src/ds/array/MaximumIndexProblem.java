package ds.array;

//Given an array arr[], find the maximum j – i such that arr[j] > arr[i]
public class MaximumIndexProblem {
    public static void main(String[] args) {
        int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (left[i] > left[i - 1]) {
                left[i] = left[i - 1];
            } else {
                left[i] = arr[i];
            }
        }

        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (right[i + 1] > right[i]) {
                right[i] = right[i + 1];
            } else {
                right[i] = arr[i];
            }
        }

        int i = 0;
        int j = 0;
        int maxLenth = -1;
        while (i < arr.length && j < arr.length) {
            if (left[i] < right[j]) {
                j++;
            } else {
                i++;
            }
            if (maxLenth >= (j - i) + 1) {
                maxLenth = (j - i) + 1;
            }
        }

    }
}
