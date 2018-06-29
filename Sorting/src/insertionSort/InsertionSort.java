package insertionSort;

import java.util.Arrays;

public class InsertionSort {
	
	public void insertionSort(int[] in) {
		System.out.println("Process Starts Here!");
		if(in == null || in.length < 1)
			return;
		for(int i = 1; i < in.length; ++i) {
			int temp = in[i];
			int j = i - 1;
		while(j >= 0 && in[j] > temp) {
			in[j + 1] = in[j];
			--j;
		}
		
		in[j + 1] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] in = {1,3,8,7,1,5};
		InsertionSort is = new InsertionSort();
		System.out.println("ahaha");
		System.out.println(Arrays.toString(in));
		is.insertionSort(in);
		System.out.println(Arrays.toString(in));
	}
}
