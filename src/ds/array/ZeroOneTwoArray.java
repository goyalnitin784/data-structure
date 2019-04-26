package ds.array;

public class ZeroOneTwoArray {
    public static void main(String[] args) {

        int a[] = new int[] {0,1,0,1,0,0,0,1};
        ZeroOneArraySort.sortArray(a);
        a = new int[] {0,0,0,0,0,0,0,1};
        ZeroOneArraySort.sortArray(a);
        a = new int[] {0,1,1,1,1,1,1,1};
        ZeroOneArraySort.sortArray(a);

    }

    public static void sortArray(int a[]){

        int left=0;
        int right=a.length-1;
        int mid=0;
        int temp;
        while(left<right){
            switch (a[mid]){
                case 0:
                {
                    temp = a[mid];
                    a[mid]=a[left];
                    a[left]=temp;
                    left++;
                    mid++;
                    break;
                }case 1:{
                    mid++;
                    break;
                }
                case 2:{
                    temp = a[mid];
                    a[mid]=a[right];
                    a[right]=temp;
                    mid++;
                    right--;
                }
            }
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println("");
    }

}
