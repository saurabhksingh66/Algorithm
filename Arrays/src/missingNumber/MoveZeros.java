/* Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the
 *  non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.
 */
package missingNumber;

import java.util.Arrays;

public class MoveZeros {
	public void moveZeros1(int[] nums) {
		if (nums == null || nums.length < 1)
			return;
		int k,count=0;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 0) {
				k = i;
				for (int j = k+1; j < nums.length; ++j) {
					if (nums[j] != 0) {
						nums[k] = nums[j];
						++k;
					}
					else count++;
				}
				for(int l=nums.length;;--l){
					nums[l-1] = 0;
					count--;
					if(count<0) break;
				}
				count = 0;
			}
		}
	}
	
	public void moveZeros2(int[] nums) {
		if (nums == null || nums.length < 1)
			return;
		int index = 0;
		for(int i = 0;i<nums.length;++i){
			if(nums[i]!=0){
				nums[index] = nums[i];
				index++;
			}
		}
		for(int i = index; i<nums.length;++i){
			nums[i] = 0;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0,0,1};
		System.out.println(Arrays.toString(nums));
		MoveZeros arr = new MoveZeros();
		arr.moveZeros2(nums);
		System.out.println(Arrays.toString(nums));
	}

}
