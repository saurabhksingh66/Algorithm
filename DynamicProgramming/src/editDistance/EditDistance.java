/*
 * Find an efficient algorithm that computes edit distance between two strings.
 * Edit Distance : Minimum number of edit operations required to transform one string to other
 * Edit operations: 1.Delete 2. Insert 3. Replace
 */

package editDistance;

public class EditDistance {

	// TC:O(3 ^ (m+n) )
	// SC:O(m+n)
	// Recursion
	public int editDistance1(String s1, String s2) {
		return auxEditDistance1(s1.length(), s2.length(), s1, s2);
	}

	private int auxEditDistance1(int i, int j, String s1, String s2) {
		if (i == 0)
			return j;
		if (j == 0)
			return i;

		if (s1.charAt(i - 1) == s2.charAt(j - 1))
			return auxEditDistance1(i - 1, j - 1, s1, s2);
		else {
			int insertCost = auxEditDistance1(i, j - 1, s1, s2);
			int replaceCost = auxEditDistance1(i - 1, j - 1, s1, s2);
			int deleteCost = auxEditDistance1(i - 1, j, s1, s2);
			return Math.min(insertCost, Math.min(replaceCost, deleteCost)) + 1;
		}
	}
	
	
	//TC:O(mn)
	//SC:O(mn)
	//Memoizaton
	public int editDistance2(String s1, String s2) {
		int[][] mem = new int[s1.length()+1][s2.length()+1];
		return auxEditDistance2(s1.length(), s2.length(), s1, s2, mem);
	}

	private int auxEditDistance2(int i, int j, String s1, String s2, int[][] mem) {
		if (i == 0)
			return j;
		if (j == 0)
			return i;
		
		if(mem[i][j]!=0)
			return mem[i][j];
		
		if (s1.charAt(i - 1) == s2.charAt(j - 1))
			return mem[i][j] = auxEditDistance2(i - 1, j - 1, s1, s2, mem);
		else {
			int insertCost = auxEditDistance2(i, j - 1, s1, s2, mem);
			int replaceCost = auxEditDistance2(i - 1, j - 1, s1, s2, mem);
			int deleteCost = auxEditDistance2(i - 1, j, s1, s2, mem);
			return mem[i][j] = Math.min(insertCost, Math.min(replaceCost, deleteCost)) + 1;
		}
	}
	
	public int editDistance3(String s1, String s2) {
		int[][] mem = new int[s1.length()+1][s2.length()+1];
		
		int m = s1.length(), n = s2.length();
		
		for(int i = 0; i<=m; ++i) 
			mem[i][0] = i;
		for(int j = 0; j<=n; ++j) 
			mem[0][j] = j;
		
		for(int i = 1; i <= m; ++i){
			for(int j = 1; j <= n; ++j) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					mem[i][j] = mem[i-1][j-1];
				else {
					int insertCost = mem[i][j-1];
					int replaceCost = mem[i-1][j-1];
					int deleteCost = mem[i-1][j];
					mem[i][j] = Math.min(insertCost, Math.min(replaceCost, deleteCost))+1;
				}
			}
		}
		return mem[m][n];
	}
	

	public static void main(String[] args) {
		EditDistance edit = new EditDistance();
		String s1 = "abjfjglavnchdc";
		String s2 = "baabjkllgjkfmncbe";
		//System.out.println(edit.editDistance1(s1, s2));
		System.out.println(edit.editDistance2(s1, s2));
		System.out.println(edit.editDistance3(s1, s2));
	}

}
