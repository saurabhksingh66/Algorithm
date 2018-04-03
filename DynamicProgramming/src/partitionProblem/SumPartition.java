/*
 * Partition problem is to determine whether a given set can be partitioned into two subsets
 *  such that the sum of elements in both subsets is same.
Example:
arr[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false 
The array cannot be partitioned into equal sum sets.

 */

package partitionProblem;

public class SumPartition {

	public boolean hasSumPartition1(int[] in) {
		if (in == null || in.length < 1)
			return false;
		int sum = 0;
		for (int e : in)
			sum = sum + e;
		if (sum % 2 != 0)
			return false;
		return auxHasSumPartition1(in, in.length - 1, sum / 2);
	}

	private boolean auxHasSumPartition1(int[] in, int i, int sum) {
		if (sum == 0)
			return true;
		if (i < 0)
			return false;

		return auxHasSumPartition1(in, i - 1, sum)
				|| auxHasSumPartition1(in, i - 1, sum - in[i]);
	}

	public boolean hasSumPartition2(int[] in) {
		if (in == null || in.length < 1)
			return false;
		int sum = 0;
		for (int e : in)
			sum = sum + e;
		if (sum % 2 != 0)
			return false;
		boolean[] mem = new boolean[in.length];
		return auxHasSumPartition2(in, in.length - 1, sum / 2, mem);
	}

	private boolean auxHasSumPartition2(int[] in, int i, int sum, boolean[] mem) {
		if (sum == 0)
			return true;
		if (i < 0)
			return false;
		if (mem[i] != false)
			return mem[i];

		return mem[i] = auxHasSumPartition2(in, i - 1, sum, mem)
				|| auxHasSumPartition2(in, i - 1, sum - in[i], mem);
	}

	public boolean hasSumPartition3(int[] in) {
		if (in == null || in.length < 1)
			return false;
		int sum = 0;
		for (int e : in)
			sum = sum + e;
		if (sum % 2 != 0)
			return false;
		boolean[][] mem = new boolean[in.length + 1][(sum / 2) + 1];

		for (int i = 0; i < mem.length; i++) {
			mem[i][0] = true;
		}

		for (int i = 1; i < mem.length; ++i) {
			for (int j = 1; j < mem[0].length; ++j) {
				if (j < in[i - 1])
					mem[i][j] = mem[i - 1][j];
				else
					mem[i][j] = mem[i - 1][j]
							|| mem[i - 1][j - in[i - 1]];
			}
		}

		return mem[mem.length - 1][mem[0].length - 1];
	}

	public static void main(String[] args) {
		int[] in = { 3, 7, 23, 1, 12 };
		for (int e : in)
			System.out.print(e + " ");
		System.out.println();
		SumPartition sp = new SumPartition();
		System.out.println(sp.hasSumPartition1(in));
		System.out.println(sp.hasSumPartition2(in));
		System.out.println(sp.hasSumPartition3(in));
	}
}
