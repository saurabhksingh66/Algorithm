package binomialCoef;

import java.util.Arrays;


public class BinomialCoefficient {
	
	// Not scalable
	public int binomialCoef1(int n, int k) {
		if(n < 0 || k > n)
			return -1;
		int[] fact = new int[n + 1];
		fact[0] = 1;
		getFactorials(n, fact);
		return fact[n] / (fact[k] * fact[n - k]);
	}

	private int getFactorials(int n, int[] fact) {
		if(n == 0)
			return 1;
		if(fact[n] != 0) 
			return fact[n];
		return fact[n] = n * getFactorials(n - 1, fact);	
	}
	
	public int binomialCoef2(int n, int k) {
		if(n < 0 || k > n)
			return -1;
		return auxBinomialCoef2(n, k);
	}
	
	private int auxBinomialCoef2(int n, int k) {
		if(n == k)
			return 1;
		if(n < k)
			return 0;
		if(n < 0 || k < 0)
			return 0;
		
		return auxBinomialCoef2(n - 1, k -1) + auxBinomialCoef2(n - 1, k);
	}
	
	public int binomialCoef3(int n, int k) {
		if(n < 0 || k > n)
			return -1;
		int[][] mem = new int[n + 1][k + 1];
		for(int i = 0; i <= n; ++i)
			mem[i][0] = 1;
		for(int i = 1; i <= n ; i++) {
			for(int j = 1; j <= k; j++)
				mem[i][j] = mem[i - 1][j - 1] + mem[i - 1][j];
		}
		for(int[] in : mem)
			System.out.println(Arrays.toString(in));
		return mem[n][k];
	}

	public static void main(String[] args) {
		BinomialCoefficient bcf = new BinomialCoefficient();
		int n = 5, k = 4;
	//	System.out.println(bcf.binomialCoef1(n, k));
		//System.out.println(bcf.binomialCoef2(n, k));
		System.out.println(bcf.binomialCoef3(n, k));
	}
}
