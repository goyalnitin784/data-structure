package ds.dp;

public class CoinChangeProblem {

    public static int count(int[] arr, int n, int m) {

        if (m == 0) {
            return 1;
        }
        if (m < 0) {
            return 0;
        }
        if (n <= 0 && m > 0) {
            return 0;
        }
        if (arr[n - 1] > m) {
            return count(arr, n - 1, m);
        }
        return count(arr, n - 1, m) + count(arr, n, m - arr[n - 1]);
    }

    public static int countUsingDp(int[] arr, int n, int m) {

        int[] solution = new int[m + 1];
        solution[0] = 1;

        for (int i = 1; i < m; i++) {
            solution[i] = 0;
        }

        for (int i = 1; i <= n; i++) {//Coin
            for (int j = arr[i]; j <= m; i++) {//Sum
                solution[j] = solution[j] + solution[j - arr[i - 1]];
            }
        }
        return solution[m];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println(count(arr, m, 4));
    }

}
