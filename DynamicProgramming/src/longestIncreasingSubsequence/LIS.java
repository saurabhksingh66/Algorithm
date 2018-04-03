package longestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Random;

public class LIS {

	public int lengthOfLIS(int[] nums) {
		if (nums.length < 1 || nums == null)
			return 0;
		int mem[] = new int[nums.length];
		for(int i=0;i<mem.length;++i)
			mem[i] = 1;
		
		for(int i = 1;i<nums.length; ++i){
			for(int j = 0; j<i; j++){
				if(nums[i]>nums[j] && mem[i] < mem[j] + 1)
					mem[i] = mem[j] + 1;
			}
		}
		System.out.println(Arrays.toString(mem));
		Arrays.sort(mem);
		return mem[mem.length-1];
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		int n = 7;
		int[] nums = new int[n];
		for(int i = 0; i<n; ++i)
			nums[i] = r.nextInt(9)+1;
		System.out.println(Arrays.toString(nums));
		LIS lis = new LIS();
		System.out.println(lis.lengthOfLIS(nums));
	}
}
