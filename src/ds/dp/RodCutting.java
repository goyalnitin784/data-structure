package ds.dp;

public class RodCutting {


    public static int cutRodUsingdp(int[] arr, int length) {

        int[] solution = new int[length];
        solution[0] = 0;
        for (int i = 1; i <= length; i++) {
            int max_val = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                max_val = Math.max(max_val, arr[j-1] + solution[i - j]);
            }
            solution[i] = max_val;
        }
        return solution[length];
    }


    public static int cutRod(int[] arr, int length) {
        if (length <= 0) {
            return 0;
        }
        int max_val = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            max_val = Math.max(max_val, arr[i] + cutRod(arr, length - i + 1));
        }
        return max_val;
    }


    public static void main(String args[]) {
        int arr[] = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " + cutRod(arr, size));
    }
}
