package secondMax;

import java.util.Arrays;

public class SecondMax {

	public int secondMax(int[] in) {
		if (in.length < 1)
			return -1;
		if(in.length==1) return in[0];
		int max1, max2;
		max1 = max2 = Integer.MIN_VALUE;
		int i, k = 0;
		for (i = 0; i < in.length; ++i) {
			if (in[i] > max1) {
				max1 = in[i];
				k = i;
			}
		}
		
		for (int j = 0; j < in.length; ++j) {
			if (j == k)
				continue;
			if (in[j] > max2) {
				max2 = in[j];
				
			}
		}

		return max2;
	}

	public static void main(String[] args) {
		int[] in = { 1};
		System.out.println(Arrays.toString(in));
		SecondMax max2 = new SecondMax();
		System.out.println(max2.secondMax(in));
	}
}
