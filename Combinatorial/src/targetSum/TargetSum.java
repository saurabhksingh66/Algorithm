/*
 *  You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one 
 *  from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

 */

package targetSum;

// Need to get more optimal solution using Dynamic Programming.


public class TargetSum {
	public int targetSum1(int[] in, int target){
		if(in == null || in.length<1)
			return 0;
		MyInteger count = new MyInteger();
		auxTargetSum1(in,target,0,0,count);
		return count.count;
	}
	
	private void auxTargetSum1(int[] in, int target,int sum,int depth, MyInteger count){
		if(depth ==in.length && sum == target){
			count.count++;
			return;
		}
		if(depth == in.length)
			return;

		auxTargetSum1(in,target,sum+in[depth],depth+1,count);
		auxTargetSum1(in,target,sum-in[depth],depth+1,count);
	}
	
	public int targetSum2(int[] in, int target){
		if(in == null || in.length<1)
			return 0;
		MyInteger count = new MyInteger();
		auxTargetSum2(in,target,0,count);
		return count.count;
	}
	
	private void auxTargetSum2(int[] in, int target,int depth, MyInteger count){
		if(depth ==in.length && target == 0){
			count.count++;
			return;
		}
		if(depth == in.length)
			return;

		auxTargetSum2(in,target+in[depth],depth+1,count);
		auxTargetSum2(in,target-in[depth],depth+1,count);
	}  
	
	public static void main(String[] args) {
		int[]in = {1,1,1,1,1};
		TargetSum ts = new TargetSum();
		System.out.println(ts.targetSum1(in, 3));
		System.out.println(ts.targetSum2(in, 3));
	}
}

class MyInteger{
	int count;
}
