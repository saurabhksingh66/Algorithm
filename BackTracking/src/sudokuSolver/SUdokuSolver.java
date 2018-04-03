package sudokuSolver;

import java.util.Arrays;

public class SUdokuSolver {

	public void sudokuSolver1(int[][] in) {
		auxSudokuSolver1(in, 0, 0);
	}

	private void auxSudokuSolver1(int[][] in, int r, int c) {

		if (r == 9) {
			if (isValid1(in)) {
				for (int[] row : in)
					System.out.println(Arrays.toString(row));
				System.out.println();
			}
			return;
		}
		if (in[r][c] != 0)
			auxSudokuSolver1(in, c == 8 ? r + 1 : r, (c+1) % 9);
		else {
			for (int k = 0; k < 9; ++k) {
				in[r][c] = k + 1;
				auxSudokuSolver1(in, c == 8 ? r + 1 : r, (c+1) % 9);
			}
			in[r][c] = 0;
		}
	}

	private boolean isValid1(int[][] in) {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 8; ++j) {
				for (int k = j + 1; k < 9; ++k) {
					if (in[i][j] == in[i][k])
						return false;
				}
			}
		}
		for (int j = 0; j < 9; ++j) {
			for (int i = 0; i < 8; ++i) {
				for (int k = i + 1; k < 9; ++k) {
					if (in[i][j] == in[k][j])
						return false;
				}
			}
		}
		int[] sum = new int[9];
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				sum[((i / 3) * 3) + (j / 3)] += in[i][j];
			}
		}
		for (int i = 0; i < 9; ++i) {
			if (sum[i] != 45)
				return false;
		}

		return true;
	}

	public void sudokuSolver2(int[][] in) {
		auxSudokuSolver2(in, 0, 0);
	}

	private void auxSudokuSolver2(int[][] in, int r, int c) {
		if (r == 9) {
				for (int[] row : in)
					System.out.println(Arrays.toString(row));
				System.out.println();
			return;
		}
		if (in[r][c] != 0)
			auxSudokuSolver2(in, c == 8 ? r + 1 : r, (c+1)% 9);
		else {
			for (int k = 1; k <= 9; ++k) {
				if(isValid2(r,c,k,in)){
					in[r][c] = k;
					auxSudokuSolver2(in, c == 8 ? r + 1 : r, (c+1) % 9);
				}
			}
			in[r][c] = 0;
		}
	}
	
	private boolean isValid2(int r,int c,int k,int[][] in){
		for(int i = 0; i<9; ++i){
			if(in[i][c] == k)
				return false;
		}
		
		for(int j = 0; j<9; ++j){
			if(in[r][j] == k)
				return false;
		}
		
		int boxR = r/3*3;
		int boxC = c/3*3;
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				if(in[boxR+i][boxC+j] == k)
					return false;
			}
}
		
		return true;
	}
	
	public static void main(String[] args) {
		SUdokuSolver sudoku = new SUdokuSolver();
		int[][] in = {{0, 0, 0, 9, 3, 0, 0, 5, 0},
                {0, 0, 0, 0, 0, 7, 0, 0, 3},
                {0, 2, 1, 0, 0, 0, 6, 0, 0},
                {2, 0, 0, 7, 8, 4, 0, 0, 0},
                {1, 9, 0, 0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 7, 0, 0},
                {9, 0, 0, 0, 0, 0, 1, 7, 0},
                {7, 0, 0, 0, 0, 0, 0, 2, 8},
                {0, 0, 8, 1, 0, 0, 5, 0, 0}};
		sudoku.sudokuSolver2(in);
	}
}
