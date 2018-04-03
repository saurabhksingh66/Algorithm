/*
 * (Maximum Sum Increasing Subsequence)
Given an array of n positive integers. Write a program to find the sum of maximum 
sum subsequence of the given array such that the intgers in the subsequence are sorted
 in increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output 
 should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should
  be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10
 */

package maxSumIncreasingSubseq;

import java.util.Arrays;

public class MaxSumSubseq {
	
	public int maxSumSubseq1(int[] in) {
		if(in == null || in.length<1)
			return 0;
		int n = in.length;
		int[] mem = new int[n];
		mem[0] = in[0];
		for(int i = 1; i<n; ++i) {
			mem[i] = in[i];
			for(int j = 0; j<i; ++j) {
				if(in[j] < in[i])
					mem[i] = mem[j] + in[i];
			}
		}
		System.out.println(Arrays.toString(mem));
		int max = 0;
		for(int i:mem)
			max = max>i?max:i;
		printSequence(max,n-1,mem,in);
		System.out.println();
		Arrays.sort(mem);
		return mem[n-1];
	}
	
	private void printSequence(int max, int n, int[] mem, int[] in) {
		if(n<0)
			return;
		
		for(int i = n; i>=0; --i) {
			if(mem[i] == max) {
				printSequence(max-in[i],i-1,mem,in);
				System.out.print(in[i] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[] in = {1, 101, 2, 3, 100, 4, 5};
		System.out.println(Arrays.toString(in));
		
		MaxSumSubseq mss = new MaxSumSubseq();
		System.out.println(mss.maxSumSubseq1(in));
	}
}
