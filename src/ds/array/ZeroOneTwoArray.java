package ds.array;

import java.util.Scanner;

public class ZeroOneTwoArray {

  public static void main(String[] args) {


    String test = "ALTER table rm_i.RESPONSES ENGINE=InnoDB;\n"
        + "ALTER table rm_i.RESPONSE_DATA ENGINE=InnoDB;\n"
        + "ALTER table rm_i.RES_CV ENGINE=InnoDB;\n"
        + "ALTER table rm_i.RES_DELETE ENGINE=InnoDB;\n"
        + "ALTER table rm_i.RES_FAILED ENGINE=InnoDB;\n"
        + "ALTER table rm_i.RES_FOLDERS ENGINE=InnoDB;\n"
        + "ALTER table rm_i.RES_STATUS ENGINE=InnoDB;\n"
        + "\n";

    String output= "";
    for(int i=0;i<51;i++){
      output+=test.replace("rm_i","rm_"+i);
    }

    int a[] = new int[]{0, 1, 0, 1, 0, 0, 0, 1};
    ZeroOneTwoArray.sortArray(a);
    a = new int[]{0, 0, 0, 0, 0, 0, 0, 1};
    ZeroOneTwoArray.sortArray(a);
    a = new int[]{0, 1, 1, 1, 1, 1, 1, 1};
    ZeroOneTwoArray.sortArray(a);
    Scanner scanner = new Scanner(System.in);
    int testCases = Integer.parseInt(scanner.nextLine());
    for (int testI = 0; testI < testCases; testI++) {
      int n = Integer.parseInt(scanner.nextLine());
      String arryString = scanner.nextLine();
      int[] arr = new int[n];
      String[] data = arryString.split(" ");
      int index = 0;
      for (String val : data) {
        arr[index] = Integer.parseInt(val);
        index++;
      }
      sortArray(arr);
      for (int i = 0; i < arr.length; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
  }

  public static void sortArray(int a[]) {

    int left = 0;
    int right = a.length - 1;
    int mid = 0;
    int temp;

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
  }

}
