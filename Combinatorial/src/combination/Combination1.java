/*
 *  Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:

[
  [7],
  [2, 2, 3]
]

 */

package combination;

import java.util.ArrayList;
import java.util.List;

public class Combination1 {
	
	public List<List<Integer>> combination1(int[] in, int target) {
		if (in == null || in.length <1)
			return null;
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<Integer>();
		
		auxCombination1(in,list,res,0, target);
		
		for(List<Integer> e: res) {
			for (int e1: e)
				System.out.print(e1 + " ");
			System.out.println();
		}
		
		return res;
	}

	private void auxCombination1(int[] in, List<Integer> list,
			List<List<Integer>> res, int start,int target) {
		
		if(target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}
		
		if(target < 0)
			return;
		
		for(int i = start; i < in.length; ++i) {
			list.add(in[i]);
			auxCombination1(in, list, res, i ,target - in[i]);
			list.remove(list.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		Combination1 combSum = new Combination1();
		int[] in = {2, 3, 6, 7};
		int target = 7;
		combSum.combination1(in, target);
	}
}
