package ds.matrix;

public class SearchATwoDMatrix {
    public static void main(String[] args) {
        int[][] a = MatrixUtil.generateM();
        int target = 5;
        int row = 0;
        int column = a[0].length - 1;
        int rowMax = a.length;
        int colMax = a[0].length;

        while (column>=0 && row< rowMax && column<colMax) {
            if (a[row][column] == target) {
                return;
            }
            if (target > a[row][column]) {
                row++;
            } else {
                column--;
            }
        }
    }
}
