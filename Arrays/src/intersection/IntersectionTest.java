package intersection;

import java.util.Arrays;

public class IntersectionTest {
	public static void main(String[] args) {
		Intersection in = new Intersection();
		int[] nums1 = { 2, 1,12,15,78,82 };
		int[] nums2 = { 1, 2,45,48,96,12,15 };
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.toString(nums2));
		int[] res = in.intersection2(nums1, nums2);
		System.out.println(Arrays.toString(res));
	}
}
