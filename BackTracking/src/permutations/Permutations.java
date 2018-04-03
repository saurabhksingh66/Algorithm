package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

	public void permutations1(char[] in) {
		if (in == null || in.length < 1)
			return;
		char[] out = new char[in.length];
		auxPermutations1(in, out, 0);
	}

	private void auxPermutations1(char[] in, char[] out, int depth) {
		if (depth == in.length) {
			if (isValid1(out))
				System.out.println(Arrays.toString(out));
			return;
		}

		for (int i = 0; i < in.length; ++i) {
			out[depth] = in[i];
			auxPermutations1(in, out, depth + 1);
		}
	}

	private boolean isValid1(char[] out) {
		for (int i = 0; i < out.length - 1; ++i) {
			for (int j = i + 1; j < out.length; ++j) {
				if (out[i] == out[j])
					return false;
			}
		}
		return true;
	}

	public void permutations2(char[] in) {
		if (in == null || in.length < 1)
			return;
		char[] out = new char[in.length];
		auxPermutations2(in, out, 0);
	}

	private void auxPermutations2(char[] in, char[] out, int depth) {
		if (depth == in.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int i = 0; i < in.length; ++i) {
			if (isValid2(out, depth, in[i])) {
				out[depth] = in[i];
				auxPermutations2(in, out, depth + 1);
			}
		}
	}

	private boolean isValid2(char[] out, int depth, char c) {
		for (int i = 0; i < depth; ++i) {
			if (out[i] == c) {
				return false;
			}
		}
		return true;
	}

	public List<List<Integer>> permutations3(int[] in) {
		List<Integer> aList = new ArrayList<Integer>();
		List<List<Integer>> list = new ArrayList<>();
		if (in == null || in.length < 1){
			list.add(aList);
			return list;
		}
		auxPermutations3(in, 0, aList, list);
		for(int i =0; i<list.size();++i)
			System.out.println(Arrays.toString(list.get(i).toArray()));
		return list;
	}

	private void auxPermutations3(int[] in, int depth,
			List<Integer> aList, List<List<Integer>> list) {
		if (depth == in.length) {
			list.add(new ArrayList<Integer>(aList));
			return;
		}
		for (int i = 0; i < in.length; ++i) {
				if (!aList.contains(in[i])) {
					aList.add(in[i]);
					auxPermutations3(in, depth + 1, aList, list);
					aList.remove(aList.size() - 1);
				}
		}
	}

	public static void main(String[] args) {
		Permutations per = new Permutations();
		String s = "123";
		char[] in = s.toCharArray();
		//int[] in1 = {1,2,3};
		// per.permutations1(in);
		per.permutations2(in);
		//per.permutations3(in1);
	}
}
