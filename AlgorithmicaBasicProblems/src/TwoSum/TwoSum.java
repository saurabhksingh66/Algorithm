
/* Given an array of integers, return indices of the two numbers such that they add up to a specific target.*/

package TwoSum;

import java.util.Arrays;
import java.util.HashSet;

public class TwoSum {

	// TC = O(n^2) SC = O(1)
	// **** Non Scalable **** Applicable for Both mutable as well as Non Mutable Arrays ****
	public static boolean twoSum1(int[] in, int target) {

		if (in == null || in.length < 1)
			return false;
		for (int i = 0; i < in.length; ++i) {
			for (int j = 0; j < in.length; ++j) {
				if (in[i] + in[j] == target)
					return true;
			}
		}
		return false;
	}

	// TC = O(nLog(n)) SC = O(1)
	// **** Scalable **** Applicable for Both mutable as well as Non Mutable Arrays ****	
	public static boolean twoSum2(int[] in, int target) {

		if (in == null || in.length < 1)
			return false;
		for (int i = 0; i < in.length; ++i) {
			if (Arrays.binarySearch(in, target - in[i]) > 0)
				return true;
		}
		return false;
	}

	// TC = O(n) SC = O(n)
	// **** Scalable **** Applicable for Both mutable as well as Non Mutable Arrays ****	
	public static boolean twoSum3(int[] in, int target) {

		if (in == null || in.length < 1)
			return false;
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < in.length; ++i) {
			if (hs.contains(target - in[i]))
				return true;
			hs.add(in[i]);
		}
		return false;
	}

	// TC = O(n) SC = O(1)
	// **** Scalable **** Applicable only for Non Mutable Arrays ****	
	public static boolean twoSum4(int[] in, int target) {

		if (in == null || in.length < 1)
			return false;
		int i = 0, j = in.length - 1;
		Arrays.sort(in);
		//System.out.println(Arrays.toString(in));
		while (i < j) {
			if (in[i] + in[j] == target)
				return true;
			else if (in[i] + in[j] > target)
				--j;
			else
				++i;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] in = { 15, 45, 12, 75, 64, 10 };
		System.out.println(Arrays.toString(in));
		System.out.println(twoSum4(in, 74));
	}

}
