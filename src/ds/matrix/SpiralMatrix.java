package ds.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] a = MatrixUtil.generateM();
        if (a.length == 0) {
            return;
        }
        if (a[0].length == 0) {
            return;
        }
        int left = 0;
        int right = a[0].length;
        int top = 0;
        int bottom = a.length;
        while (left < right && top < bottom) {

            for (int i = left; i < right; i++) {
                System.out.print(a[top][i]);
            }

            top++;
            for (int i = top; i < bottom; i++) {
                System.out.print(a[i][right - 1]);
            }

            right--;

            if (left < right) {
                for (int i = right - 1; i >= left; i--) {
                    System.out.print(a[bottom - 1][i]);
                }
                bottom--;
            }

            if (top < bottom) {
                for (int i = bottom-1; i >= top; i--) {
                    System.out.print(a[i][left]);
                }
                left++;
            }
        }
    }
}
