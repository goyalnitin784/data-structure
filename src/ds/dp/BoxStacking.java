package ds.dp;

import java.util.Arrays;
import java.util.Collections;

public class BoxStacking {

    public static int maxHeight(int height[], int width[], int length[], int n) {

        Box[] arr = new Box[n * 3];

        for (int i = 0; i < n; i++) {
            arr[i * 0 + 1] = new Box((height[i] * width[i]), length[i]);
            arr[i * 1 + 1] = new Box((height[i] * length[i]), width[i]);
            arr[i * 2 + 1] = new Box((length[i] * width[i]), height[i]);
        }
        Arrays.sort(arr);


        int[] heightArr = new int[arr.length];
        int[] solution = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            heightArr[i] = arr[i].height;
        }

        for (int i = 0; i < heightArr.length; i++) {
            solution[i] = 1;
        }

        for (int i = 1; i < solution.length; i++) {
            for (int j = 0; j < i; j++) {
                if (heightArr[i] > heightArr[j] && solution[j] + 1 > solution[i]) {
                    solution[i] = solution[j] + 1;
                }
            }
        }

        int max = -1;

        /* Pick maximum of all msh values */
        for(int i = 0; i < solution.length; i++){
            max = Math.max(max, solution[i]);
        }

        return max;
    }

    public static void main(String[] args) {

    }
}

class Box implements Comparable {

    int baseArea;
    int height;

    public Box(int baseArea, int height) {
        this.baseArea = baseArea;
        this.height = height;
    }

    public int getBaseArea() {
        return baseArea;
    }

    public void setBaseArea(int baseArea) {
        this.baseArea = baseArea;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int compareTo(Object o) {
        return this.baseArea - ((Box) o).baseArea;
    }
}
