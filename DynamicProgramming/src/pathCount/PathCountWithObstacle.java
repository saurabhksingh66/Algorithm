/*
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

The total number of unique paths is 2.
 */

package pathCount;

public class PathCountWithObstacle {

	public int pathCount1(int[][] in) {
		if (in.length < 1 || in[0].length < 1 || in == null)
			return 0;
		int m = in.length, n = in[0].length;
		int[][] mem = new int[m + 1][n + 1];
		mem[1][1] = 1;

		if (in.length == 1 && in[0].length == 1 && in[0][0] == 1)
			return 0;

		for (int i = 1; i <= m; ++i) {
			for (int j = 1; j <= n; ++j) {

				if (in[0][0] == 1)
					break;

				if (i == 1 && j == 1)
					continue;

				if (in[i - 1][j - 1] != 1) {
					mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
				}
			}
		}
		return mem[m][n];
	}

	public int pathCount2(int[][] in) {
		if (in.length < 1 || in[0].length < 1 || in == null)
			return 0;
		int m = in.length, n = in[0].length;
		int[][] mem = new int[m][n];
		mem[0][0] = in[0][0] == 1 ? 0 : 1;

		for (int j = 1, i = 0; j < n; ++j) {
			if(in[i][j]!=1)
				mem[i][j] = mem[i][j - 1];
		}
		for (int i = 1, j = 0; i < m; ++i) {
			if(in[i][j]!=1)
			mem[i][j] = mem[i - 1][j];
		}

		for (int i = 1; i < m; ++i) {
			for (int j = 1; j < n; ++j) {
				if(in[i][j]!=1)
					mem[i][j] = mem[i-1][j] + mem[i][j-1];
			}
		}
		return mem[m-1][n-1];
	}
	
	public static void main(String[] args) {
		PathCountWithObstacle path = new PathCountWithObstacle();
		int m = 3, n= 3;
		int in[][] = new int[m][n];
		in[0][1] = 1;
		in[1][1] = 1;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.print(in[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println(path.pathCount1(in));
		System.out.println(path.pathCount2(in));
	}

}
