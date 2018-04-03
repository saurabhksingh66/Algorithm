package pathCount;


public class PathCount {

	public int countPath1(int n) {
		if (n <= 0)
			return 0;
		int[] count = { 0 };
		auxCountPath1(0, 0, count, n);
		return count[0];
	}

	private void auxCountPath1(int i, int j, int[] count, int n) {
		if (i >= n || j >= n)
			return;
		if (i == n - 1 && j == n - 1) {
			count[0] = count[0] + 1;
			return;
		}

		auxCountPath1(i, j + 1, count, n);
		auxCountPath1(i + 1, j, count, n);
	}

	public int countPath2(int n) {
		if (n <= 0)
			return 0;
		return auxCountPath2(n - 1, n - 1);
	}

	private int auxCountPath2(int i, int j) {
		if (j < 0 || i < 0)
			return 0;
		if (i == 0 && j == 0)
			return 1;

		int leftCount = auxCountPath2(i - 1, j);
		int topCount = auxCountPath2(i, j - 1);
		return leftCount + topCount;
	}

	public int countPath3(int n) {
		if (n <= 0)
			return 0;
		int[][] mem = new int[n][n];
		auxCountPath3(n - 1, n - 1, mem);
		return mem[n - 1][n - 1];
	}

	private int auxCountPath3(int i, int j, int[][] mem) {
		if (j < 0 || i < 0)
			return 0;
		if (i == 0 && j == 0)
			return 1;
		if (mem[i][j] != 0)
			return mem[i][j];

		int topCount = auxCountPath3(i - 1, j, mem);
		int leftCount = auxCountPath3(i, j - 1, mem);

		mem[i][j] = leftCount + topCount;

		return mem[i][j];
	}

	public int countPath4(int n) {
		if (n <= 0)
			return 0;
		int[][] mem = new int[n + 1][n + 1];
		mem[1][1] = 1;
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				if(i==1 && j==1) continue;
				mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
			}
		}
		return mem[n][n];
	}

	public static void main(String[] args) {
		PathCount path = new PathCount();
		System.out.println(path.countPath1(4));
		System.out.println(path.countPath2(4));
		System.out.println(path.countPath3(4));
		System.out.println(path.countPath4(4));
	}
}
