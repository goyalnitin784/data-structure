package ds.dp;

public class ArraySubsetWithMinimumDifference {
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 2, 2, 1};
        int n = arr.length;
        System.out.print("The minimum difference between two sets is " + findMin(arr, n));
    }

    public static int findMin(int a[],int n){
        int totalSum = 0;
        for(int i=0;i<a.length;i++){
            totalSum+=a[i];
        }

        return 0;
    }

    public static int caclulateDifference(int a[],int n,int totalSum){
        return 0;
    }


}
