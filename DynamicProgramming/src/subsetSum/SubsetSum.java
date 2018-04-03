/*
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of
 *  the given set with sum equal to given sum.

Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.

 */

package subsetSum;


public class SubsetSum {
	public boolean hasSum1(int[] in, int sum) {
		if (in == null || in.length < 1)
			return false;
		int total = 0;
		for (int e : in)
			total += e;
		if (total < sum)
			return false;
		else if (total == sum)
			return true;
		else
			return auxSubsetSum1(in, in.length - 1, sum);
	}

	private boolean auxSubsetSum1(int[] in, int i, int sum) {
		if (sum == 0)
			return true;

		if (i < 0)
			return false;

		return auxSubsetSum1(in, i - 1, sum)
				|| auxSubsetSum1(in, i - 1, sum - in[i]);
	}

	public boolean hasSum2(int[] in, int sum) {
		if(in == null || in.length < 1)
			return false;
		int total = 0;
		for(int e: in)
			total += e;
		if(total < sum)
			return false;
		else if(total == sum)
			return true;
		boolean[][] mem = new boolean[in.length + 1][sum + 1];
		for(int i = 0; i < mem.length; ++i)
			mem[i][0] = true;
		for(int i = 1; i < mem.length; ++i) {
			for(int j = 1; j < mem[0].length; ++j) {
				if(j < in[i - 1])
					mem[i][j] = mem[i - 1][j];
				else
					mem[i][j] = mem[i - 1][j] || mem[i -1][j - in[i -1]];
			}
		}
		return mem[mem.length - 1][mem[0].length - 1];
	}

	public static void main(String[] args) {
		int[] in = { 2, 7, 6 };
		int sum = 8;
		SubsetSum ss = new SubsetSum();
		System.out.println(ss.hasSum1(in, sum));
		System.out.println(ss.hasSum2(in, sum));
	}
}
