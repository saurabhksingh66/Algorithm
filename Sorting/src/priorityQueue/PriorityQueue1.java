package priorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueue1 {
	
	public void priorityQueue(int[] in) {
		if (in == null || in.length < 1) 
			return;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i: in)
			pq.add(i);
		int i = 0;
		while(!pq.isEmpty())
			in[i++] = pq.remove();
	}
	
	public static void main(String[] args) {
		int[] in = new int[6];
		Random r = new Random();
		for(int i = 0; i<in.length; ++i)
			in[i] = r.nextInt(in.length + 1) + 1;

		System.out.println(Arrays.toString(in));
		PriorityQueue1 pq = new PriorityQueue1();
		pq.priorityQueue(in);
		System.out.println(Arrays.toString(in));
	}
}
