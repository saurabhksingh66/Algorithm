package Successor;

import java.util.Arrays;

public class Successor {

	public static void main(String[] args) {
		int[] in = { 15, 25, 26, 48, 78, 108 };
		System.out.println(Arrays.toString(in));
		System.out.println(successor1(in,47));

	}

	public static int successor1(int[] in, int target) {
		if (in == null || in.length < 1)
			return -1;
		int l = 0, r = in.length - 1, m;
		if (target > in[r])
			return -1;
		while (l < r) {
			m = (l + r) / 2;
			if (target == in[m])
				return m;
			else if (target > in[m])
				l = m + 1;
			else
				r = m;
		}
		return l;
	}

}
