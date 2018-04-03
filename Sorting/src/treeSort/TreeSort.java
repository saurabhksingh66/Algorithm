package treeSort;

import java.util.Arrays;

import com.google.common.collect.TreeMultiset;

public class TreeSort {

	public void treeSort(int[] in) {
		if (in == null || in.length < 1)
			return;
		TreeMultiset<Integer> tree = TreeMultiset.create();
		for(int i: in)
			tree.add(i);
		int i = 0;
		for(int e: tree)
			in[i++] = e;
	}
	
	public static void main(String[] args) {
		int[] in = {1,3,8,7,1,5};
		System.out.println(Arrays.toString(in));
		TreeSort tree = new TreeSort();
		tree.treeSort(in);
		System.out.println(Arrays.toString(in));
	}
}
