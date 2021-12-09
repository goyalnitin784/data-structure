package ds.array;

import java.time.LocalTime;
import java.util.concurrent.ConcurrentHashMap;

public class Subarraysum {

  public static void main(String[] args) {

    int sum1 = 468;
    int arr1[] = new int[]{
        135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5,
        103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12,
        123, 134
    };
    new Subarraysum().test(sum1, arr1);
  }

  public void test(int sum, int arr[]) {

    new ConcurrentHashMap(1,1,1);
//    int start = 0;
//    int end = 0;
//    boolean solution = false;
//    while (true) {
//      if (sumTillNow == sum) {
//        solution = true;
//        break;
//      }
//      if (start >= arr.length || end >= arr.length) {
//        break;
//      }
//
//      while (sumTillNow < sum && end < arr.length) {
//        sumTillNow += arr[end];
//        end++;
//      }
//      while (sumTillNow > sum && start <= end) {
//        sumTillNow -= arr[start];
//        start++;
//      }
//    }
//    if (solution) {
//      System.out.println((start + 1) + " " + end);
//    } else {
//      System.out.print(-1);
//    }



  }

}