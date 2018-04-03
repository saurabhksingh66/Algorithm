/*
 * Given n and k (positive integers),print all N bit binary strings that have exactly K bit set,
 * on the same line separated by space.
 */

package kBitsSet;

import java.util.Arrays;

public class KBitSet {
	
	public void kBitSet1(int n, int k) {
		int[] out = new int[n];
		auxKBitSet1(n, k, 0, out, 2);
	}

	private void auxKBitSet1(int n, int k, int depth, int[] out, int s) {
		if(depth == n) {
			int count = 0;
			for(int i = 0; i < out.length; ++i) {
				if(out[i] == 1)
					count++;
			}
			if(count == k)
				System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i< s; ++i) {
			out[depth] = i;
			auxKBitSet1(n,k,depth+1,out,s);
		}
		out[depth] = 0;
	}
	
	public void kBitSet2(int n, int k) {
		int[] out = new int[n];
		auxKBitSet2(n, k, 0, out, 2);
	}
	
	private void auxKBitSet2(int n, int k, int depth, int[] out, int s) {
		
		if(depth == n) {
			if(k == 0)
				System.out.println(Arrays.toString(out));
			return;
		}
		
		if(k < 0)
			return;
		
		for(int i = 0; i < 2; ++i) {
			out[depth] = i;
			if(i == 0)
				auxKBitSet2(n, k, depth + 1, out, s);
			else
				auxKBitSet2(n, k - 1, depth + 1, out, s);
		}
		
	}
	
	public static void main(String[] args) {
		KBitSet kbs = new KBitSet();
		int n = 5, k = 2;
		kbs.kBitSet1(n, k);
		System.out.println();
		System.out.println();
		kbs.kBitSet2(n, k);
	}
}
