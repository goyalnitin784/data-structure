package ds.array;

public class ZeroOneTwoArray {
    public static void main(String[] args) {

        int a[] = new int[]{0, 1, 0, 1, 0, 0, 0, 1};
        ZeroOneTwoArray.sortArray(a);
        a = new int[]{0, 0, 0, 0, 0, 0, 0, 1};
        ZeroOneTwoArray.sortArray(a);
        a = new int[]{0, 1, 1, 1, 1, 1, 1, 1};
        ZeroOneTwoArray.sortArray(a);

    }

    public static void sortArray(int a[]) {

        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        int temp;

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        while (mid <= right && mid >= left) {
            switch (a[mid]) {
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = a[mid];
                    a[mid] = a[right];
                    a[right] = temp;
                    right--;
                    break;
                case 0: {
                    temp = a[mid];
                    a[mid] = a[left];
                    a[left] = temp;
                    left++;
                    mid++;
                    break;
                }

            }
        }

        System.out.println("");
    }

}
