package maxSum;

import java.util.Arrays;
import java.util.Random;

public class MaxSum {

	public int maxSum1(int[][] in) {
		if (in == null)
			return 0;
		int[] maxSum = { 0 };
		auxMaxSum1(0, 0, 0, maxSum, in);
		return maxSum[0];
	}

	private void auxMaxSum1(int i, int j, int pathSum, int[] maxSum, int[][] in) {
		if (i >= in.length || j >= in.length)
			return;
		if (i == in.length - 1 && j == in.length - 1) {
			maxSum[0] = Math.max(pathSum + in[i][j], maxSum[0]);
			return;
		}

		auxMaxSum1(i, j + 1, pathSum + in[i][j], maxSum, in);
		auxMaxSum1(i + 1, j, pathSum + in[i][j], maxSum, in);
	}

	public int maxSum2(int[][] in) {
		if (in == null)
			return 0;
		return auxMaxSum2(in, in.length - 1, in.length - 1);
	}

	private int auxMaxSum2(int[][] in, int i, int j) {
		if (i < 0 || j < 0)
			return 0;

		int topSum = auxMaxSum2(in, i - 1, j);
		int leftSum = auxMaxSum2(in, i, j - 1);

		return Math.max(topSum, leftSum) + in[i][j];
	}

	public int maxSum3(int[][] in) {
		if (in == null)
			return 0;
		int[][] mem = new int[in.length][in.length];
		return auxMaxSum3(in, in.length - 1, in.length - 1, mem);
	}

	private int auxMaxSum3(int[][] in, int i, int j, int[][] mem) {
		if (i < 0 || j < 0)
			return 0;

		if (mem[i][j] != 0)
			return mem[i][j];

		int topSum = auxMaxSum3(in, i - 1, j, mem);
		int leftSum = auxMaxSum3(in, i, j - 1, mem);

		return mem[i][j] = Math.max(topSum, leftSum) + in[i][j];
	}

	public int maxSum4(int[][] in) {
		if (in == null)
			return 0;
		int n = in.length;
		int[][] mem = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 1; j < n + 1; ++j) {
				mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1])
						+ in[i - 1][j - 1];
			}
		}
		for(int[] arr : mem)
			System.out.println(Arrays.toString(arr));
		getSequence(mem,mem.length-1,mem.length-1);
		System.out.println();
		return mem[n][n];
	}

	private void getSequence(int[][] mem, int i, int j) {
		if(i<=0 || j<=0) return;
		if(mem[i-1][j]>mem[i][j-1]){
			getSequence(mem, i-1, j);
			System.out.print(mem[i][j]-mem[i-1][j] + " ");
		}
		else{
			getSequence(mem, i, j-1);
			System.out.print(mem[i][j]-mem[i][j-1] + " ");
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] in = new int[n][n];
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				in[i][j] = r.nextInt(8) + 1;
			}
			System.out.println(Arrays.toString(in[i]));
		}
		MaxSum max = new MaxSum();
		System.out.println(max.maxSum1(in));
		System.out.println(max.maxSum2(in));
		System.out.println(max.maxSum3(in));
		System.out.println(max.maxSum4(in));
	}

}