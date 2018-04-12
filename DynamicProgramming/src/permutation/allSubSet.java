/*
 *  Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

 */

package permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allSubSet {
	public List<List<Integer>> allSubSet(int[] in) {
		if (in == null || in.length <1)
			return null;
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<Integer>();
		res.add(new ArrayList<>(list));
		Arrays.sort(in);
		auxAllSubSet1(in,list,res,0);
		
		for(List<Integer> e: res) {
			for (int e1: e)
				System.out.print(e1 + " ");
			System.out.println();
		}
		
		return res;
	}

	private void auxAllSubSet1(int[] in, List<Integer> list,
			List<List<Integer>> res, int start) {
		
		for(int i = start; i < in.length; ++i) {
			if(i == start || in[i] != in[i - 1]) {
				list.add(in[i]);
				res.add(new ArrayList<>(list));
				auxAllSubSet1(in, list, res, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		allSubSet ss = new allSubSet();
		int[] in = {1, 1, 1};
		ss.allSubSet(in);
	}
}
