package nextElement;

import java.util.Arrays;

public class NextElementTest {
	public static void main(String[] args) {
		NextElement next = new NextElement();
		int nums1[] = { 4,1,2};
		int nums2[] = { 1,2,3,4};
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		System.out.println(Arrays.toString(next
				.nextGreaterElement(nums1, nums2)));
	}
}
