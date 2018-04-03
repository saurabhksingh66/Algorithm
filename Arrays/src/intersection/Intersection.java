package intersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Intersection {

	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null)
			return null;

		ArrayList<Integer> res = new ArrayList<>();
		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < nums1.length; ++i) {
			set.add(nums1[i]);
		}

		for (int i = 0; i < nums2.length; ++i) {
			if (set.contains(nums2[i])) {
				if (!res.contains(nums2[i]))
					res.add(nums2[i]);
			}
		}
		System.out.println("Res = " + Arrays.toString(res.toArray()));
		// System.out.println(res.size());

		int[] result = new int[res.size()];

		for (int j = 0; !res.isEmpty(); ++j) {
			result[j] = res.remove(0);
		}

		return result;
	}

	public int[] intersection2(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null)
			return null;
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		ArrayList<Integer> res = new ArrayList<Integer>();
		HashSet<Integer> hash = new HashSet<Integer>();

		int i = 0, j = 0;

		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				++i;
			} else if (nums1[i] > nums2[j]) {
				++j;
			} else {
				if (hash.add(nums1[i]))
					res.add(nums1[i]);
				++i;
				++j;
			}
		}
		
		int[] result = new int[res.size()];
		for(i =0; !res.isEmpty();++i)
			result[i] = res.remove(0);
		return result;
	}
}
