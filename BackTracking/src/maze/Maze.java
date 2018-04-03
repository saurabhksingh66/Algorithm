package maze;

import java.util.Arrays;

public class Maze {
	public void mazeRunner(int[][] in) {
		if(in == null || in.length < 1 || in[0].length < 1)
			return;
		int[][] result = new int[in.length][in[0].length];
		boolean ans = auxMazeRunner(in,0,0,result);
		if(ans == false) {
			System.out.println("No Paths available");
		} else {
			for(int[] i: result)
				System.out.println(Arrays.toString(i));
		}
		
	}

	private boolean auxMazeRunner(int[][] in, int i, int j, int[][] result) {
		if(i == in.length - 1 && j == in[0].length - 1) {
			in[i][j] = 1;
			return true;
		}
		
		if(i != in.length && j != in[0].length && in[i][j] == 1) {
			result[i][j] = 1;
			if(auxMazeRunner(in,i,j+1,result))
				return true;
			if(auxMazeRunner(in,i+1,j,result))
				return true;
			result[i][j] = 0;
			return false;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Maze maze = new Maze();
		int in[][] = {{1, 0, 0, 0},
					  {1, 0, 1, 1},
					  {1, 1, 0, 0},
					  {1, 1, 1, 1}
					};
		for(int[] i: in)
			System.out.println(Arrays.toString(i));
		System.out.println();
		System.out.println();
		
		maze.mazeRunner(in);
	}
}
