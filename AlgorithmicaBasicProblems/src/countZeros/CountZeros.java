/* Given an array that contains some number of contiguous zeroes at the start,
 * followed by some arbitrary integers other than zero. Write an efficient function
 *  that returns the number of zeroes in the given array.
 *  Function Prototype:
 *  int countZeroes(int []a, int n)
 *  Example ->
 *  Input: 0 0 0 0 0 3 2 8 11 10 15 22
 *  Output: 5
 * */
package countZeros;

public class CountZeros {
	public static int countZeros(int[] a) {
		if (a == null || a.length == 0)
			return 0;
		int i = 0, count = 0;
		while (i < a.length && a[i] == 0) {
			++count;
			++i;
		}
		return count;
	}

	public static void main(String[] args) {
		int a[] = { 0, 0, 0, 0, 0, 5 };
		int count = countZeros(a);
		System.out.println(count);
	}
}
