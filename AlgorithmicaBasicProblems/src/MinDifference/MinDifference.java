/*Find an efficient algorithm to find two elements from two different
 *  arrays that has minimum difference.
 * */

package MinDifference;

import java.util.Arrays;

public class MinDifference {

	// TC = O(n^2)
	// **** Not Scalable ****
	public static int minDiff1(int[] in1, int[] in2) {
		if (in1 == null || in2 == null || in1.length < 1 || in2.length < 1)
			return -1;
		int minDiff = Integer.MAX_VALUE, min;
		for (int i = 0; i < in1.length; ++i) {
			for (int j = 0; j < in2.length; ++j) {
				min = Math.abs((in1[i] - in2[j]));
				minDiff = Math.min(min, minDiff);
			}
		}
		return minDiff;
	}

	// TC = nLog(n)+nLog(n)+2n = O(nLog(n))
	// **** Scalable ****
	public static int minDiff2(int[] in1, int[] in2) {
		if (in1 == null || in2 == null || in1.length < 1 || in2.length < 1)
			return -1;
		int minDiff = Integer.MAX_VALUE, diff;
		Arrays.sort(in1);
		Arrays.sort(in2);
		System.out.println(Arrays.toString(in1));
		System.out.println(Arrays.toString(in2));
		int i = 0, j = 0;
		while (i < in1.length && j < in2.length) {
			diff = Math.abs(in1[i] - in2[j]);
			minDiff = Math.min(diff, minDiff);
			if (in1[i] > in2[j])
				++j;
			else if (in1[i] < in2[j])
				++i;
			else
				return 0;
		}
		return minDiff;
	}

	// TC = nLog(n)+ nLog(n)
	// **** Scalable ****
	public static int minDiff3(int[] in1, int[] in2) {
		if (in1 == null || in2 == null || in1.length < 1 || in2.length < 1)
			return -1;
		int minDiff = Integer.MAX_VALUE, diff;
		Arrays.sort(in2);
		System.out.println(Arrays.toString(in2));
		for (int i = 0; i < in1.length; ++i) {
			diff = Math.abs(in1[i] - adjacent(in2, in1[i]));
			System.out.println("Diff = " + diff);
			minDiff = Math.min(diff, minDiff);
			System.out.println("MinDiff = " + minDiff);
		}
		return minDiff;
	}

	public static int adjacent(int[] a, int target) {
		if (a == null || a.length < 1)
			return -1;
		int l = 0, r = a.length - 1, mid;
		System.out.println("r = " + r);
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		while (l < r) {
			mid = (l + r) / 2;
			int prev = Math.abs(target - a[mid]);
			int next = Math.abs(target - a[mid + 1]);
			if (target == a[mid]) {
				System.out.println("Inside Mid");
				return a[mid];
			} else if (prev < next) {
				r = mid;
			} else
				l = mid + 1;

		}
		return a[l];
	}

	public static void main(String args[]) {
		int[] in1 = { 155, 5, 3, 355, 75, 119, 26, 444, 43 };
		int[] in2 = { 21, 12, 45, 99, 4 };
		System.out.println(Arrays.toString(in1));
		System.out.println(Arrays.toString(in2));
		System.out.println(minDiff3(in1, in2));

	}
}
