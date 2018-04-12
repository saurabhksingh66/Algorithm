/*
 * Given a rod of length n inches and an array of prices that contains prices of all 
 * pieces of size smaller than n. Determine the maximum value obtainable by cutting up
 *  the rod and selling the pieces. For example, if length of the rod is 8 and the values
 *   of different pieces are given as following, then the maximum obtainable value
 *    is 22 (by cutting in two pieces of lengths 2 and 6)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

And if the prices are as following, then the maximum obtainable value
 is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20

 */

package cuttingRod;

public class CuttingRod {

	public int cuttingRod1(int[] price) {
		if (price == null || price.length < 1)
			return 0;
		return auxCuttingRod1(price, price.length);
	}

	private int auxCuttingRod1(int[] price, int n) {
		if (n == 0)
			return 0;
		int count = 0;
		for (int j = 0; j < n; ++j) {
			count = Math.max(count, price[j] + auxCuttingRod1(price, n - j - 1));
		}
		return count;
	}

	public int cuttingRod2(int[] in) {
		if (in == null || in.length < 1)
			return 0;
		int[][] mem = new int[in.length + 1][in.length + 1];
		for (int i = 1; i < mem.length; ++i) {
			for (int j = 1; j < mem[0].length; ++j) {
				if (i > j)
					mem[i][j] = mem[i - 1][j];
				else {
					mem[i][j] = Math.max(mem[i - 1][j], in[i - 1]
							+ mem[i][j - i]);
				}
			}
		}
		for (int[] e : mem) {
			for (int e1 : e)
				System.out.print(e1 + " ");
			System.out.println();
		}
		return mem[mem.length - 1][mem[0].length - 1];
	}

	public static void main(String[] args) {
		int[] in = { 1, 5, 8 };
		CuttingRod cut = new CuttingRod();
		System.out.println(cut.cuttingRod1(in));
		System.out.println(cut.cuttingRod2(in));
	}
}
