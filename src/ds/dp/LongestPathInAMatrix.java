package ds.dp;

import java.util.Arrays;

public class LongestPathInAMatrix {
    public static void main(String[] args) {
        int mat[][] = {
                {1, 2, 3, 4},
                {2, 2, 3, 4},
                {3, 2, 3, 4},
                {4, 5, 6, 7},
        };
        int n = 4, m = 4;
        System.out.println(wrapper(mat, m, n));

    }

    static int wrapper(int mat[][], int m, int n) {
        int result = 1;

        int dp[][] = new int[4][4];
        for (int i = 0; i < 4; i++)
            Arrays.fill(dp[i], -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == -1)
                    LIP(dp, mat, n, m, i, j);
                //  Update result if needed
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    static int LIP(int[][] dp, int[][] matrix, int m, int n, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n)
            return 0;

        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        if (x < m - 1 && matrix[x][y]+1 == matrix[x + 1][y]) {
            dp[x][y] = 1 + LIP(dp, matrix, m, n, x + 1, y);
        }
        if (y < n - 1 && matrix[x][y] == matrix[x][y + 1] + 1) {
            dp[x][y] = Math.max(dp[x][y], 1 + LIP(dp, matrix, m, n, x, y + 1));
        }
        if (x > 0 && matrix[x][y] == matrix[x - 1][y] + 1) {
            dp[x][y] = Math.max(dp[x][y], 1 + LIP(dp, matrix, m, n, x - 1, y));
        }
        if (y > 0 && matrix[x][y] == matrix[x][y - 1] + 1) {
            dp[x][y] = Math.max(dp[x][y], 1 + LIP(dp, matrix, m, n, x, y - 1));
        }
        if (dp[x][y] == -1) {
            dp[x][y] = 1;
        }
        return dp[x][y];
    }
}
