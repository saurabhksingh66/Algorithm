/*
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

 */

package MatrixSearch;

import java.util.Arrays;

public class MatrixSearch {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5 } };
		// int[][] matrix =null;
		// int[][] matrix = { {} };
		System.out.println(Arrays.deepToString(matrix));
		System.out.println("Matrix[0].Length : " + matrix[0].length);
		System.out.println("Matrix.length : " + matrix.length);
		// System.out.println("Matrix : " + matrix[0][0] );
		System.out.println(matrixSearch2(matrix, 1));

	}

	// matrixSearch : TC = O(m*log(n)) ****Scalable, can be applied for large
	// numbers as well****
	public static boolean matrixSearch1(int[][] matrix, int target) {
		if (matrix != null && matrix.length > 0) {
			for (int i = 0; i < matrix.length; i++) {
				if (Arrays.binarySearch(matrix[i], target) >= 0)
					return true;
			}
		}
		return false;
	}

	// matrixSearch2 : TC = O(m+log(n)) **** Third Best ****
	public static boolean matrixSearch2(int[][] matrix, int target) {
		if (matrix != null && matrix.length > 0 && matrix[0].length > 0) {
			for (int i = 0; i < matrix.length; ++i) {
				if (target >= matrix[i][0] && target <= matrix[i][matrix[0].length - 1]) {
					if (Arrays.binarySearch(matrix[i], target) >= 0)
						return true;
				}

			}
		}
		return false;
	}

	// matrixSearch3 : TC = O(log(mn)) ******Best Method So Far******
	public static boolean matrixSearch3(int[][] matrix, int target) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return false;
		int l = 0, mid, x = matrix[0].length, s;
		int r = matrix.length * x - 1;
		while (l <= r) {
			mid = (l + r) / 2;
			s = matrix[mid / x][mid % x];
			if (s == target)
				return true;
			else if (s > target)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return false;
	}

}
