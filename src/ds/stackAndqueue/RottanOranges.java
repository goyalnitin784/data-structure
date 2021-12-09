package ds.stackAndqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottanOranges {


    public static boolean isValidPosition(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return false;
        }
        return true;
    }

    public void printDuration(int[][] matrix) {
        Queue<Element> rotten = new LinkedList();
        int duration = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 2) {
                    rotten.add(new Element(i, j));
                }
            }
        }
        if (rotten.isEmpty()) {
            return;
        }
        rotten.add(new Element(-1, -1));

        boolean flag = false;
        while (!rotten.isEmpty()) {
            Element e = rotten.poll();
            if(e.x==-1 && e.y==-1){
                flag  = false;
                if(!rotten.isEmpty()){
                    rotten.add(new Element(-1, -1));
                }
            }
            if (isValidPosition(matrix, e.x, e.y - 1) && matrix[e.x][e.y - 1] == 1) {
                matrix[e.x][e.y - 1] = 2;
                rotten.add(new Element(e.x, e.y - 1));
                if (flag == false) {
                    flag = true;
                    duration++;
                }
            }
            if (isValidPosition(matrix, e.x, e.y + 1) && matrix[e.x][e.y + 1] == 1) {
                matrix[e.x][e.y + 1] = 2;
                rotten.add(new Element(e.x, e.y + 1));
                if (flag == false) {
                    flag = true;
                    duration++;
                }
            }
            if (isValidPosition(matrix, e.x - 1, e.y) && matrix[e.x - 1][e.y] == 1) {
                matrix[e.x - 1][e.y] = 2;
                rotten.add(new Element(e.x - 1, e.y));
                if (flag == false) {
                    flag = true;
                    duration++;
                }
            }
            if (isValidPosition(matrix, e.x + 1, e.y) && matrix[e.x + 1][e.y] == 1) {
                matrix[e.x + 1][e.y] = 2;
                rotten.add(new Element(e.x + 1, e.y));
                if (flag == false) {
                    flag = true;
                    duration++;
                }
            }
        }
        System.out.println(duration);
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testcases = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < testcases; i++) {
            String rowString = scanner.nextLine();
            int rows = Integer.parseInt(rowString.split(" ")[0]);
            int columns = Integer.parseInt(rowString.split(" ")[1]);
            String elements = scanner.nextLine();
            String[] elem = elements.split(" ");
            int[][] matrix = new int[rows][columns];
            int counter = 0;
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    matrix[row][column] = Integer.parseInt(elem[counter]);
                    counter++;
                }
            }
            new RottanOranges().printDuration(matrix);
        }

//        int testcases = Integer.parseInt("1");
//        for (int i = 0; i < testcases; i++) {
//            String rowString = "3 5";
//            int rows = Integer.parseInt(rowString.split(" ")[0]);
//            int columns = Integer.parseInt(rowString.split(" ")[1]);
//            String elements = "2 1 0 2 1 1 0 1 2 1 1 0 0 2 1";
//            String[] elem = elements.split(" ");
//            int[][] matrix = new int[rows][columns];
//            int counter = 0;
//            for (int row = 0; row < rows; row++) {
//                for (int column = 0; column < columns; column++) {
//                    matrix[row][column] = Integer.parseInt(elem[counter]);
//                    counter++;
//                }
//            }
//            new RottanOranges().printDuration(matrix);
//        }

    }
}

class Element {
    int x;
    int y;

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
