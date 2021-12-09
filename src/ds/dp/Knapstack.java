package ds.dp;

public class Knapstack {

    public static int knapstack(int[] weight, int[] value, int w, int n) {
        if (n == 0) {
            return 0;
        }
        if (w == 0) {
            return 0;
        }
        if (weight[n - 1] > w) {
            return knapstack(weight, value, w, n - 1);
        }
        return Math.max(knapstack(weight, value, w, n - 1), value[n - 1] + knapstack(weight, value, w - weight[n - 1], n - 1));
    }

    public static int knapStackWithoutRecursion(int[] weight, int[] value, int w, int n) {

        int[][] dp = new int[n + 1][w + 1];


        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= w; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (weight[i] < w) {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {

        int[] weight = new int[5];
        int[] value = new int[5];
        int w = 10;

    }

}
