/*
 * Design a Data Structure called Super Queue with following API:

 * 1-> enqueue(e)
 * 2-> dequeue()
 * 3- findMin()
 * Perform above actions in O(1) time complexity.
 */

package SuperQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SuperQueue {
	private Queue<Integer> queue;
	private Deque<Integer> minQueue;

	SuperQueue() {
		queue = new LinkedList<Integer>();
		minQueue = new LinkedList<Integer>();
	}

	public void enqueue(int e) {
		queue.add(e);
		if(!minQueue.isEmpty()){
			if(e<minQueue.peekLast()){
				while(e<minQueue.peekLast()){
						minQueue.removeLast();
						if(minQueue.isEmpty()) break;
				}
				minQueue.addLast(e);
			}
			else minQueue.addLast(e);
		}
		else minQueue.addLast(e);
	}

	public int dequeue() {
		int e = queue.remove();
		if (e == minQueue.peekFirst())
			minQueue.removeFirst();
		return e;
	}
	
	public int findMin(){
		if(minQueue.isEmpty()) return -1;
		return minQueue.peekFirst();
	}
	public void display() {
		System.out.println("queue:" + queue.toString());
		System.out.println("mindq:" + minQueue.toString());
}

}
