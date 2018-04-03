package allSeq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

	public List<List<Integer>> combine(int n, int k) {
		if (n < 1)
			return null;
		List<Integer> aList = new ArrayList<Integer>();
		List<List<Integer>> list = new ArrayList<>();
		auxCombine(n, 0, k, aList, list);
		
		return list;
	}

	private void auxCombine(int n, int depth, int k, List<Integer> aList,
			List<List<Integer>> list) {

		if (depth == k) {
			list.add(new ArrayList<>(aList));
			return;
		}

		for (int i = 0; i < n; ++i) {
			if ( (aList.size()==0) || (aList.size()!=0 && i >= aList.get(aList.size() - 1))) {
				aList.add(i+1);
				auxCombine(n, depth + 1, k, aList, list);
				aList.remove(aList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Combination com = new Combination();
		List<List<Integer>> list = com.combine(4, 2);
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(Arrays.toString(list.get(i).toArray()));
		}
	}

}
