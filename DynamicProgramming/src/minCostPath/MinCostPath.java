/*
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], 
 write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
 Each cell of the matrix represents a cost to traverse through that cell. Total cost
 of a path to reach (m, n) is sum of all the costs on that path (including both source
 and destination). You can only traverse down, right and diagonally lower cells from a
 given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) 
 can be traversed. You may assume that all costs are positive integers.
 */

package minCostPath;

import java.util.Arrays;

public class MinCostPath {

	public int minCostPath(int[][] in) {

		if (in == null || in.length < 1)
			return 0;

		int m = in.length, n = in[0].length;
		int[][] mem = new int[m][n];
		int val = 0;

		for (int i = 0; i < m; ++i) {
			val = in[i][0] + val;
			mem[i][0] = val;
		}

		val = 0;

		for (int j = 0; j < n; ++j) {
			val = in[0][j] + val;
			mem[0][j] = val;
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				mem[i][j] = in[i][j]
						+ Math.min(mem[i - 1][j - 1],
								Math.min(mem[i - 1][j], mem[i][j - 1]));
			}
		}
		for (int[] i : mem)
			System.out.println(Arrays.toString(i));
		System.out.println();
		return mem[m - 1][n - 1];
	}

	public static void main(String[] args) {

		int[][] in = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		for (int[] i : in)
			System.out.println(Arrays.toString(i));
		System.out.println();
		MinCostPath minCost = new MinCostPath();
		System.out.println(minCost.minCostPath(in));
	}
}
