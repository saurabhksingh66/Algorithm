package lcs;

public class LCS {

	public int LCS1(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() < 1 || s2.length() < 1)
			return 0;
		return auxLCS1(s1.length(), s2.length(), s1, s2);
	}

	private int auxLCS1(int i, int j, String s1, String s2) {
		if (i == 0 || j == 0)
			return 0;

		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			return auxLCS1(i - 1, j - 1, s1, s2) + 1;
		} else {
			return Math.max(auxLCS1(i - 1, j, s1, s2),
					auxLCS1(i, j - 1, s1, s2));
		}
	}
	
	public int LCS2(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() < 1 || s2.length() < 1)
			return 0;
		int[][] mem = new int[s1.length()+1][s2.length()+1];
		return auxLCS2(s1.length(), s2.length(), s1, s2, mem);
	}

	private int auxLCS2(int i, int j, String s1, String s2, int[][] mem) {
		if (i == 0 || j == 0)
			return 0;
		
		if(mem[i][j]!=0)
			return mem[i][j];
		
		if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
			return mem[i][j] = auxLCS2(i - 1, j - 1, s1, s2, mem) + 1;
		} else {
			return mem[i][j] = Math.max(auxLCS2(i - 1, j, s1, s2, mem),
					auxLCS2(i, j - 1, s1, s2, mem));
		}
	}
	
	public int LCS3(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() < 1 || s2.length() < 1)
			return 0;
		int m = s1.length(), n = s2.length();
		int[][] mem = new int[m+1][n+1];
		for(int i = 1; i<=m; ++i){
			for(int j = 1; j<=n; ++j){
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					mem[i][j] = mem[i-1][j-1] + 1;
				else
					mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]);
			}
		}
		return mem[m][n];
	}
	
	public static void main(String[] args) {
		LCS lcs = new LCS();
		String s1 = "saurabh";
		String s2 = "shubham";
		System.out.println(s1);
		System.out.println(s2);
		System.out.println("LCS Length = " + lcs.LCS1(s1, s2));
		System.out.println("LCS Length = " + lcs.LCS2(s1, s2));
		System.out.println("LCS Length = " + lcs.LCS3(s1, s2));
	}
}
