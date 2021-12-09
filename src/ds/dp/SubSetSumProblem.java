package ds.dp;

//Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
//      Example:

//    Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
//  Output:  True  //There is a subset (4, 5) with sum 9.
public class SubSetSumProblem {

    public static boolean subset(int[] arr, int n, int sum) {
        if (n < 0 || sum < 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }
        if (arr[n - 1] > sum) {
            return subset(arr, n - 1, sum);
        }
        return subset(arr, n - 1, sum) || subset(arr, n - 1, sum - arr[n - 1]);
    }

    public static boolean subsetWithoutRecursion(int[] arr, int n, int sum) {
        boolean[][] solution = new boolean[n + 1][sum + 1];

        for (int i = 0; i < n; i++) {
            solution[i][0] = true;
        }
        for (int i = 0; i < sum; i++) {
            solution[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] > j) {
                    solution[i][j] = solution[i - 1][j];
                } else {
                    solution[i][j] = solution[i - 1][j] || solution[i - 1][j - arr[i - 1]];
                }
            }
        }
        return solution[n][sum];

    }

    public static void main(String[] args) {
        int arr[] = new int[6];

    }
}
