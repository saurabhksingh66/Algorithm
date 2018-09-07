/*
 *  Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:

[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

 */

package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination2 {
	public List<List<Integer>> combination1(int[] in, int target) {
		if (in == null || in.length < 1)
			return null;
		Arrays.sort(in);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<Integer>();

		auxCombination1(in, list, res, 0, target);

		for (List<Integer> e : res) {
			for (int e1 : e)
				System.out.print(e1 + " ");
			System.out.println();
		}

		return res;
	}

	private void auxCombination1(int[] in, List<Integer> list,
			List<List<Integer>> res, int start, int target) {

		if (target == 0) {
			res.add(new ArrayList<>(list));
			return;
		}

		if (target < 0)
			return;

		for (int i = start; i < in.length; ++i) {
			if(i == start || (i != start && in[i] != in[i - 1])) {
				list.add(in[i]);
				auxCombination1(in, list, res, i + 1, target - in[i]);
				list.remove(list.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Combination2 combSum = new Combination2();
		int[] in = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		combSum.combination1(in, target);
	}
}
