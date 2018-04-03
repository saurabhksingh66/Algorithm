/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:

[[1,3,1],
 [1,5,1],
 [4,2,1]]

Given the above grid map, return 7. Because the path 1,3,1,1,1 minimizes the sum. 
 */

package maxSum;

import java.util.Arrays;
import java.util.Random;

public class MinSum {
	public int minSum1(int[][] in) {
		if (in == null || in.length < 1 || in[0].length < 1)
			return 0;
		int m = in.length, n = in[0].length;
		int[][] mem = new int[m][n];
		mem[0][0] = in[0][0];
		for (int j = 1, i = 0; j < n; ++j)
				mem[i][j] = in[i][j] + mem[i][j - 1];
		for (int i = 1, j = 0; i < m; ++i)
			mem[i][j] = in[i][j] + mem[i - 1][j];
		
		for (int i = 1; i < m ; ++i) {
			for (int j = 1; j < n ; ++j) {
				mem[i][j] = Math.min(mem[i-1][j], mem[i][j-1]) + in[i][j];
			}
		}
		return mem[m-1][n-1];
	}

	public static void main(String[] args) {
		int n = 3, m = 4;
		int[][] in = new int[m][n];
		Random r = new Random();
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				in[i][j] = r.nextInt(8) + 1;
			}
			System.out.println(Arrays.toString(in[i]));
		}
		System.out.println();
		System.out.println();
		
		MinSum min = new MinSum();
		System.out.println(min.minSum1(in));
	}
}
