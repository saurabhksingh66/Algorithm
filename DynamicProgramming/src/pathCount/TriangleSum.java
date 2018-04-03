/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. 
 */

package pathCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TriangleSum {
	
	public int minSum1(List<List<Integer>> triangle){
		if(triangle == null || triangle.size()==0) return 0;
		int n = triangle.size();
		List<Integer> list;
		List<List<Integer>> mem = new ArrayList<>();
		mem.add(triangle.get(0));
		for(int i =1; i<n; i++){
			int j = 0;
			list = new ArrayList<Integer>();
			
			list.add(mem.get(i-1).get(0) + triangle.get(i).get(0));
			for(j = 1; j<i; ++j){
				list.add(triangle.get(i).get(j) + Math.min(mem.get(i-1).get(j), mem.get(i-1).get(j-1)));
			}
			list.add(mem.get(i-1).get(i-1) + triangle.get(i).get(i));
			mem.add(list);
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i<n; ++i){
			min = Math.min(min, mem.get(n-1).get(i));
		}
		return min;
	}
	
	public int minSum2(List<List<Integer>> triangle){
		if(triangle == null || triangle.size()==0) return 0;
		int n = triangle.size();
		int[][] mem = new int[n][];
		
		mem[n-1] = new int[triangle.get(n-1).size()];
		List<Integer> row = triangle.get(n-1);
		for(int j=0; j<row.size(); ++j){
			mem[n-1][j] = row.get(j);
		}
		
		for(int i = n-2; i>=0; --i){
			row = triangle.get(i);
			mem[i] = new int[triangle.get(i).size()];
			for(int j = 0; j<row.size(); ++j){
				mem[i][j] = row.get(j) + (mem[i+1][j]>mem[i+1][j+1]? mem[i+1][j+1]:mem[i+1][j]);
			}
		}
		
		return mem[0][0];
	}
	
	public static void main(String[] args) {
		List<Integer> list;
		List<List<Integer>> triangle;
		triangle = new ArrayList<>();
		Random r = new Random();
		int n = 10;
		
		for(int i = 0; i<n; ++i){
			list = new ArrayList<Integer>();
			for(int j = 0; j<=i; ++j){
				list.add(r.nextInt(9)+1);
			}
			triangle.add(list);
			System.out.println(Arrays.toString(triangle.get(i).toArray()));
		}
		System.out.println();
		System.out.println("size = " + triangle.size());
		TriangleSum tri = new TriangleSum();
		System.out.println(tri.minSum1(triangle));
		System.out.println(tri.minSum2(triangle));
	}
}
