/*
 * Given an array of n integer in which all the elements are between 1 to n-1
 * Find an efficient algorithm which return any duplicates available in array.
 * */

package Duplicate;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;

public class Duplicate {
	// TC = O(n^2) SC = O(1)
	// **** Not Scalable **** Applicable for Both mutable as well as Non Mutable
	// Arrays ****
	public static int findDuplicates1(int[] in) {
		if (in == null || in.length < 1)
			return -1;
		for (int i = 0; i < in.length; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (in[i] == in[j])
					return in[i];
			}
		}
		return -1;
	}

	// TC = nLog(n)+(n-1)
	// SC = O(1)
	// **** Scalable **** Applicable only for Mutable Arrays ****
	public static int findDuplicates2(int[] in) {
		if (in == null || in.length < 1)
			return -1;
		Arrays.sort(in);
		for (int i = 0; i < in.length - 1; ++i) {
			if (in[i] == in[i + 1])
				return in[i];
		}
		return -1;

	}

	// TC = n SC = n
	// **** Scalable **** Applicable for Both mutable as well as Non Mutable
	// Arrays ****
	public static int findDuplicates3(int[] in) {
		if (in == null || in.length < 1)
			return -1;
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < in.length; ++i) {
			if (hs.contains(in[i]))
				return in[i];
			hs.add(in[i]);
		}
		System.out.println("All Different");
		return -1;

	}

	// TC = O(n) SC = n bits
	// **** Scalable **** Applicable for Both mutable as well as Non Mutable
	// Arrays ****
	public static int findDuplicates4(int[] in) {
		if (in == null || in.length < 1)
			return -1;
		BitSet bs = new BitSet();
		for (int i = 0; i < in.length; ++i) {
			if (bs.get(in[i]))
				return in[i];
			bs.set(in[i]);
		}
		System.out.println("All Different");
		return -1;
	}

	// TC = O(n) SC = O(1)
	// **** Scalable **** Applicable only for mutable arrays ****
	// **** Applicable only when all the elements are lesser than arrays length ****
	public static int findDuplicates5(int[] in) {
		if (in == null || in.length < 1)
			return -1;
		int temp=0;
		for (int i = 0; i < in.length; ++i) {
			temp = Math.abs(in[i]);
			if(in[temp]<0) return temp;
			in[temp] = in[temp]*-1;
			
		}
		return -1;
	}

	public static void main(String args[]) {
		int[] in = { 4,4,3,1,2};
		System.out.println(Arrays.toString(in));
		System.out.println(findDuplicates5(in));
	}
}
