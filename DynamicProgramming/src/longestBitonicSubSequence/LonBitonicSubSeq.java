package longestBitonicSubSequence;

import java.util.Arrays;

public class LonBitonicSubSeq {

	public int lonBitonicSubSeq(int[] in) {
		if (in == null || in.length < 1)
			return 0;
		int n = in.length;
		int[] lis = new int[n];
		int[] dis = new int[n];
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			dis[i] = 1;
		}
		
		for(int i = 1; i<n; ++i) {
			for(int j = 0; j < i; ++j) {
				if(in[j] < in[i] && lis[j] >= lis[i]) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		for(int i = 1; i<n; ++i) {
			for(int j = 0; j < i; ++j) {
				if(in[j] > in[i] && dis[j] >= dis[i]) {
					dis[i] = dis[j] + 1;
				}
			}
		}
		System.out.println(Arrays.toString(lis));
		System.out.println(Arrays.toString(dis));
		
		int[] res = new int[n];
		for(int i = 0; i < n; ++i) {
			res[i] = lis[i] + dis[i] -1;
		}
		System.out.println(Arrays.toString(res));
		Arrays.sort(res);
		return res[res.length-1];
	}
	
	public static void main(String[] args) {
		LonBitonicSubSeq lbs = new LonBitonicSubSeq();
		int[] in = {80, 60, 30, 40, 20, 10};
		System.out.println(Arrays.toString(in));
		System.out.println(lbs.lonBitonicSubSeq(in));
	}
}
