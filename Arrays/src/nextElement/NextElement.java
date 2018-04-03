/* You are given two arrays (without duplicates) nums1 and nums2 where nums1’s 
 * elements are subset of nums2. Find all the next greater numbers for nums1's 
 * elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to 
its right in nums2. If it does not exist, output -1 for this number.

Note:

    All elements in nums1 and nums2 are unique.
    The length of both nums1 and nums2 would not exceed 1000.
 */

// LeetCode: 496

package nextElement;

public class NextElement {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			return new int[0];
		int[] result = new int[nums1.length];
		int k = 0;
		int j = 0, temp = Integer.MAX_VALUE;
		for (int i = 0; i < nums1.length; ++i) {
			result[k] = nums1[i];
			for (j = 0; j < nums2.length; ++j) {
				if (nums2[j] > nums1[i]) {
					temp = nums2[j];
					if (nums2[j] <= temp) {
						result[k] = j;
					}
				}
			}
			if(result[k]==nums1[i]) result[k] = -1;
			++k;
			
		}
		return result;
	}

}
