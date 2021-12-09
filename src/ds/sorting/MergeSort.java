package ds.sorting;

public class MergeSort {

  public static void main(String[] args) {
    int arr[] = new int[]{5, 4, 3, 10, 13};
    mergeSort(arr, 0, arr.length - 1);
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + "   ");
    }
  }

  public static void merge(int[] arr, int start, int end, int mid) {
    int n1 = mid - start + 1;
    int n2 = end - mid;
    int[] arr1 = new int[n1];
    int[] arr2 = new int[n2];

    for (int i = 0; i < n1; i++) {
      arr1[i] = arr[start + i];
    }
    for (int i = 0; i < n2; i++) {
      arr2[i] = arr[mid + i + 1];
    }
    int k = start;
    int i = 0;
    int j = 0;
    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] <= arr2[j]) {
        arr[k] = arr1[i];
        i++;
      } else {
        arr[k] = arr2[j];
        j++;
      }
      k++;
    }
    while (i < arr1.length) {
      arr[k] = arr1[i];
      i++;
      k++;
    }
    while (j < arr2.length) {
      arr[k] = arr2[j];
      j++;
      k++;
    }
  }

  public static void mergeSort(int arr[], int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      mergeSort(arr, start, mid);
      mergeSort(arr, mid + 1, end);
      merge(arr, start, end, mid);
    }
  }

}
