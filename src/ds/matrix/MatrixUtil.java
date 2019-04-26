package ds.matrix;

public class MatrixUtil {

    public static int[][] generateM() {
        int i[][] = new int[3][3];
        int counter=1;
        for (int var = 0; var < 3; var++) {
            i[var] = new int[3];
            for(int j=0;j<3;j++){
                i[var][j]=counter;
                counter++;
            }
        }
        return i;
    }

    public static int[][] generateM1() {
        int i[][] = new int[1][10];
        int counter=1;
        for (int var = 0; var < 1; var++) {
            i[var] = new int[10];
            for(int j=0;j<10;j++){
                i[var][j]=counter;
                counter++;
            }
        }
        return i;
    }
}
