package ds.array;

public class ZeroOneArraySort {
	
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
		while(left<right) {
			if(a[left]==0){
				left++;
			}
			if(a[right]==1){
				right--;
			}
			if(a[left]==1 && a[right]==0){
				a[left]=0;
				a[right]=1;
				left++;
				right--;
			}
		}
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]);
		}
		System.out.println("");
	}

}
