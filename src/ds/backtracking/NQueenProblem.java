package ds.backtracking;

public class NQueenProblem {


    public static boolean isSafe(int[][] arr, int x, int y, int n) {

        for (int i = x; i >= 0; i--) {
            if (arr[i][y] == 1) {
                return false;
            }
        }

        for (int i = y; i >= 0; i--) {
            if (arr[x][i] == 1) {
                return false;
            }
        }

        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (arr[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean nQueen(int[][] arr, int n, int column) {

        if (column >= n) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (isSafe(arr, i, column, n)) {
                arr[i][column] = 1;
                if (nQueen(arr, n, column + 1)) {
                    return true;
                }
                arr[i][column] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] arr = new int[n][n];
        boolean solution = NQueenProblem.nQueen(arr, n, 0);
        if (solution) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 1) {
                        System.out.println("Column value is :  " + j);
                    }
                }
            }
        }

    }
}
