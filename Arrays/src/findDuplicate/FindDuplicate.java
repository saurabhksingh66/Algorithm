/* Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.
*/
package findDuplicate;

import java.util.Arrays;

public class FindDuplicate {
	
	public int findDuplicate1(int[] nums) {
		if (nums != null && nums.length > 0) {
			Arrays.sort(nums);
			int i;
			for (i = 0; i < nums.length - 1; ++i) {
				if (nums[i] == nums[i + 1])
					return nums[i];
			}
		}
		return -1;
	}
}
