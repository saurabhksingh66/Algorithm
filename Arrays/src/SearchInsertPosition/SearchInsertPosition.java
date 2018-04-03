/* 
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
 *  *********** Successor *************
 *  ******** LeetCode: Problem No:35 *************
 *  */

package SearchInsertPosition;

import java.util.Arrays;

// TC = O(log(n))
public class SearchInsertPosition {
	public static int returnIndex(int[] in, int target) {
		if (in == null || in.length < 1)
			return -1;
		if (target > in[in.length - 1])
			return in.length;
		int l = 0, r = in.length - 1, mid;
		while (l < r) {
			mid = (l + r) / 2;
			if (target == in[mid])
				return mid;
			else if (target > in[mid])
				l = mid + 1;
			else
				r = mid;
		}
		return l;
	}
public static void main(String[] args){
	int[] in = {3,42,45};
	System.out.println(Arrays.toString(in));
	System.out.println("Index :" + returnIndex(in,44));
}
}
