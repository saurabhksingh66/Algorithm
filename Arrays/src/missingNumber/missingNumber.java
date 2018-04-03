/* Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity? */

package missingNumber;

public class missingNumber {
	public int findNum(int[] nums) {
		if(nums==null || nums.length<1) return -1;
		int sum = (nums.length*(nums.length+1))/2;
		int arraySum=0;
		for(int i=0;i<nums.length;++i)
			arraySum = arraySum + nums[i];
		return sum - arraySum;
	}
}
