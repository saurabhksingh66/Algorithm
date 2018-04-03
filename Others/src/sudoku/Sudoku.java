package sudoku;

public class Sudoku {

	//this method would be called from main method. (6 Lines)
	// TC -> O(n^2)
	public boolean sudoku(int[][] arr) {

		int n = arr.length;
		int[] rrSum = new int[n];
		int[] ccSum = new int[n];
		int[] cubeSum = new int[n];

		helperSum(rrSum, ccSum, cubeSum, arr);  // O(n^2)
		
		return isSudoku(rrSum,ccSum,cubeSum, arr);  //O(n^2)
	}

	// helper1 method to maintain rrSum and ccSum arrays (8 Lines)
	private void helperSum(int[] rrSum, int[] ccSum, int[] cubeSum, int[][] arr) {
		int cubeIndex = 0, n = arr.length;
		int b = (int) Math.sqrt(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cubeIndex = (i / b) * b + j / b;
				cubeSum[cubeIndex] = cubeSum[cubeIndex] + arr[i][j];
				rrSum[i] = rrSum[i] + arr[i][j];
				ccSum[i] = ccSum[i] + arr[j][i];
			}
		}
	}


	//return true if given 2d matrix is a Sudoku. (10 Lines)
	private boolean isSudoku(int[] rrSum, int[] ccSum, int[] cubeSum, int[][] arr){
		int n = arr.length;
		int sum = auxSum(arr.length);
		for(int i = 0; i<n; i++){
			if(rrSum[i]!=sum || ccSum[i]!=sum || cubeSum[i]!=sum)
				return false;
		}
		for(int i = 0; i<n-1; ++i){
			for(int j = 0; j < n-1 ; ++j){
				if(arr[i][j] == arr[i] [j+1] || arr[i][j] == arr[i+1][j])
					return false;
			}
		}
		return true;
	}
	
	// calculate sigma of a given number (4 Lines)
	private int auxSum(int n){
		int sum = 0;
		for(int i = n; i >0; --i){
			sum = sum + i;
		}
		return sum;
	}
	
	//main method to test the program
	public static void main(String[] args) {
		int[][] arr ={
				{1,2,3,4},
				{3,4,1,2},
				{4,3,2,1},
				{2,1,4,3}
            };
		Sudoku sudoku = new Sudoku();
		System.out.println(sudoku.sudoku(arr));
	}
}
