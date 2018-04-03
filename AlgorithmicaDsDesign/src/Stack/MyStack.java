package Stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
	private Queue<Integer> queue1;
	private Queue<Integer> queue2;
	int top;

	MyStack() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	public void push(int e) {
		while (!queue1.isEmpty())
			queue2.add(queue1.poll());
		queue1.add(e);
		//top = e;
		while (!queue2.isEmpty())
			queue1.add(queue2.poll());
	}

	public int pop() {
		if (queue1.isEmpty())
			return -1;
		return queue1.poll();
	}

	public int top(){
		//System.out.println("i am in top");
		if (queue1.isEmpty())
			return -1;
		while(!queue1.isEmpty())
			queue2.add(queue1.poll());
		//System.out.println("i am Here " +queue2.peek());
		top = queue2.peek();
		while(!queue2.isEmpty())
			queue1.add(queue2.poll());
		return top;
	}

	public boolean empty() {
		return queue1.isEmpty();
	}

}
