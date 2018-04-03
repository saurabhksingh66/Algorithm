package permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Permutation2 {
	
	public List<List<Integer>> allPermutation1(int[] in) {
		if(in == null || in.length < 1)
			return null;
		List<List<Integer>> res = new ArrayList<>();
		
		List<Integer> list = new ArrayList<Integer>();
		auxAllPermutation1(in,list,res,0);
		for(List<Integer> e : res) {
			for(int e1: e) 
				System.out.print(e1 + " ");
			System.out.println();
		}
		return res;
	}

	private void auxAllPermutation1(int[] in, List<Integer> list,
			List<List<Integer>> res, int depth) {
		if(depth == in.length) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		
		for(int i = 0; i < in.length; ++i) {
			if(!list.contains(in[i])) {
				list.add(in[i]);
				auxAllPermutation1(in, list, res, depth + 1);
				list.remove(list.size() - 1);
			}
		}
		
	}
	
	public List<List<Integer>> allPermutation2(int[] in) {
		if(in == null || in.length < 1)
			return null;
		
		return null;
	
	}
	
	public static void main(String[] args) {
		int[] in = {1, 2, 3};
		Permutation2 per = new Permutation2();
		per.allPermutation1(in);
		
	}
}
