package ds.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] a = MatrixUtil.generateM1();
        if(a.length==0){
            return;
        }
        if(a[0].length==0){
            return;
        }
        int rowTop = 0;
        int columnLeft = 0;
        int rowBottom = a.length;
        int columnRight = a[0].length;
        List<Integer> list = new ArrayList<>();
        while (rowTop < rowBottom && columnLeft < columnRight) {
            for (int var = columnLeft; var < columnRight; var++) {
                list.add(a[rowTop][var]);
            }
            rowTop++;
            for (int var = rowTop; var < rowBottom; var++) {
                list.add(a[var][columnRight-1]);
            }
            columnRight--;
            if (rowTop < rowBottom) {
                for (int var = columnRight-1; var >= columnLeft; var--) {
                    list.add(a[rowBottom-1][var]);
                }
                rowBottom--;
            }

            if (columnLeft < columnRight) {
                for (int var = rowBottom-1; var >= rowTop; var--) {
                    list.add(a[var][columnLeft]);
                }
                columnLeft++;
            }
        }
        System.out.println(list);
    }
}
