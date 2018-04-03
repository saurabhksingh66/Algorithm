package longestPalSubSeq;

import java.util.Arrays;

public class LongestPalSubSeq {

	public int longestPalSubSeq1(String s) {
		if (s == null || s.length() < 1)
			return 0;
		return auxLongestPalSubSeq1(s, 0, s.length() - 1);
	}

	private int auxLongestPalSubSeq1(String s, int i, int j) {
		if (i > j)
			return 0;
		if (i == j)
			return 1;
		if (s.charAt(i) == s.charAt(j))
			return 2 + auxLongestPalSubSeq1(s, i + 1, j - 1);
		else
			return Math.max(auxLongestPalSubSeq1(s, i + 1, j),
					auxLongestPalSubSeq1(s, i, j - 1));
	}

	public int longestPalSubSeq2(String s) {
		if (s == null || s.length() < 1)
			return 0;
		int[][] mem = new int[s.length()][s.length()];
		return auxLongestPalSubSeq2(s, 0, s.length() - 1, mem);
	}

	private int auxLongestPalSubSeq2(String s, int i, int j, int[][] mem) {
		if (i > j)
			return 0;
		if (i == j)
			return 1;
		if (mem[i][j] != 0)
			return mem[i][j];
		if (s.charAt(i) == s.charAt(j))
			return mem[i][j] = 2 + auxLongestPalSubSeq2(s, i + 1, j - 1, mem);
		else
			return mem[i][j] = Math.max(auxLongestPalSubSeq2(s, i + 1, j, mem),
					auxLongestPalSubSeq2(s, i, j - 1, mem));
	}

	// TC:O(n^2)
	// SC:O(n^2) -> O(n)
	// Recursion->Dynamic programming
	public int longestPalSubSeq3(String s) {
		if (s == null || s.length() < 1)
			return 0;
		int[][] mem = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); ++i)
			mem[i][i] = 1;
		for (int i = s.length() - 2; i >= 0; --i) {
			for (int j = i + 1; j < s.length(); ++j) {
				if (s.charAt(i) == s.charAt(j))
					mem[i][j] = mem[i + 1][j - 1] + 2;
				else
					mem[i][j] = Math.max(mem[i + 1][j], mem[i][j - 1]);
			}
		}
		for (int[] i : mem)
			System.out.println(Arrays.toString(i));
		return mem[0][s.length() - 1];
	}

	public static void main(String[] args) {
		LongestPalSubSeq lps = new LongestPalSubSeq();
		String s = "abcad";
		System.out.println(s);
		System.out.println(lps.longestPalSubSeq2(s));
		System.out.println(s);
		System.out.println(lps.longestPalSubSeq3(s));
	}
}
