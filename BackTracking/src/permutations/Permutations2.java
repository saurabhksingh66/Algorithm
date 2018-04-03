package permutations;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations2 {

	
	public void permutations1(char[] in) {
		if (in == null || in.length < 1)
			return;
		ArrayList<String> list = new ArrayList<String>();
		char[] out = new char[in.length];
		auxPermutations1(in, out, 0, list);
		for(int i = 0; i<list.size(); ++i){
			System.out.println(list.get(i));
		}
	}

	private void auxPermutations1(char[] in, char[] out, int depth, ArrayList<String> list) {
		if (depth == in.length) {
			if(!list.contains(Arrays.toString(out)))
				list.add(Arrays.toString(out));
			return;
		}

		for (int i = 0; i < in.length; ++i) {
			out[depth] = in[i];
			auxPermutations1(in, out, depth + 1, list);
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
	
	
	public static void main(String[] args) {
		Permutations2 per = new Permutations2();
		String s = "112";
		char[] in = s.toCharArray();
		//int[] in1 = {1,2,3};
		// per.permutations1(in);
		per.permutations1(in);
		//per.permutations3(in1);
	}
}
