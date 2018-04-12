/*
 * Given a n*n chess board, Find an efficient algorithm to place n queens such that no queens attack each other.
 */

package nQueens;

import java.util.Arrays;

public class NQueens {

	public void nQueens1(int n) {
		if (n < 1)
			return;
		int[] out = new int[n];
		auxNQueen1(n, out, 0);
	}

	private void auxNQueen1(int n, int[] out, int depth) {
		if (depth == n) {
			if (isValid1(out)) {
				System.out.println(Arrays.toString(out));
			}
			return;
		}
		for (int i = 0; i < n; ++i) {
			out[depth] = i;
			auxNQueen1(n, out, depth + 1);
		}
	}

	private boolean isValid1(int[] out) {
		for (int i = 0; i < out.length-1; ++i) {
			for (int j = i + 1; j < out.length; ++j) {
				if (out[i] == out[j] || i - out[i] == j - out[j]
						|| i + out[i] == j + out[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public void nQueens2(int n) {
		if (n < 1)
			return;
		int[] out = new int[n];
		auxNQueen2(n, out, 0);
	}

	private void auxNQueen2(int n, int[] out, int depth) {
		if(depth == n) {
			System.out.println(Arrays.toString(out));
			return;
		}
		
		for(int c = 0; c<n; ++c) {
			if(isValid2(out,depth,c)) {
				out[depth] = c;
				auxNQueen2(n, out, depth+1);
			}
		}
	}

	private boolean isValid2(int[] out, int cq, int cc) {
		for(int i = 0; i<cq; ++i) {
			if(out[i] == cc || (i-out[i] == cq - cc) || (i+out[i] == cq + cc))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		int n = 4;
		nq.nQueens1(n);
		System.out.println();
		System.out.println();
		nq.nQueens2(n);
	}

}
