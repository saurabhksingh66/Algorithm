/*
 * a) Given an array of N integers in which each element is between 1 and N-1,
 *   write an efficient function to determine the any duplicated integer. You may
 *   destroy the array. What are the time and space complexities of your solution?
 *   Function Prototype:
 *   int FindDuplicate(int[ ]a)
 * b) Write an efficient function to solve the above problem if the given array
 *   is read only. What are the time and space complexities of your solution?
 */
package duplicate2;

import java.util.BitSet;
import java.util.HashSet;

public class DuplicateNumber {

	//applicable only if array is mutable, TC = SC = O(n)
	
	int findDuplicate1(int[] a) {
		if (a != null && a.length != 0) {
			HashSet<Integer> set = new HashSet<Integer>();
			int i = 0;
			while (i < a.length) {
				if (set.contains(a[i]))
					return a[i];
				set.add(a[i]);
				++i;
			}
		}
		return -1;
	}
	
	//applicable only if array is mutable, TC = O(n), SC = n bits
	
		int findDuplicate2(int[] a) {
			if (a != null && a.length != 0) {
				BitSet bit = new BitSet();
				int i = 0;
				while (i < a.length) {
					if(bit.get(i))
						return a[i];
					bit.set(1);
					++i;
				}
			}
			return -1;
		}
		
		public static void main(String[] args) {
			DuplicateNumber duplicate = new DuplicateNumber();
			int a[] = {2,3,2};
			System.out.println(duplicate.findDuplicate2(a));
		}
}
