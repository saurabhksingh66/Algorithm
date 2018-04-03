package climbingStairs;

import java.util.HashMap;

public class ClimbingStairs {
	HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();

	public int climbStairs1(int n) {
		if (n <= 0)
			return 0;
		if (n == 1 || n == 2)
			return n;

		return climbStairs1(n - 1) + climbStairs1(n - 2);
	}

	public int climbStairs2(int n) {
		if (n <= 0)
			return 0;
		int mem[] = new int[n + 1];
		return auxClimbStairs2(mem, n);
	}

	private int auxClimbStairs2(int[] mem, int n) {
		if (n == 1 || n == 2)
			return n;
		if (mem[n] != 0)
			return mem[n];
		mem[n] = auxClimbStairs2(mem, n - 1) + auxClimbStairs2(mem, n - 2);
		return mem[n];
	}

	public int climbStairs3(int n) {
		if (n <= 0)
			return 0;
		if (n == 1 || n == 2)
			return n;
		int mem[] = new int[n+1];
		mem[1] = 1; mem[2] = 2;
		for(int i = 3; i<=n; i++){
			mem[i] = mem[i-1] + mem[i-2];
		}
		return mem[n];
	}
	
	public int climbStairs4(int n){
		if (n <= 0)
			return 0;
		if(n==1 || n==2) return n;
		int first = 1, second = 2,res = 0;
		for(int i = 3; i<=n;++i){
			res = first + second;
			first = second;
			second = res;
		}
		return res;
	}
	
	public int climbStairs5(int n){
		if (n <= 0)
			return 0;
		map.put(1, 1);
		map.put(2, 2);
		for(int i = 3; i<=n;++i){
			map.put(i, map.get(i-1) + map.get(i-2));
		}
		return map.get(n);
	}
	
	public static void main(String[] args) {
		ClimbingStairs stairs = new ClimbingStairs();
		int n = 1;
		System.out.println(stairs.climbStairs1(n));
		System.out.println(stairs.climbStairs2(n));
		System.out.println(stairs.climbStairs3(n));
		System.out.println(stairs.climbStairs4(n));
		System.out.println(stairs.climbStairs5(n));
	}
}
