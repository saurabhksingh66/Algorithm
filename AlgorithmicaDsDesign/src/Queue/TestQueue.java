package Queue;

import java.util.LinkedList;

public class TestQueue {
	public static void main(String[] args) {
		Queue2 q = new Queue2();
		q.push(1);
		q.push(2);
		q.push(7);
		System.out.println(q.pop());
		System.out.println(q.peek());
		System.out.println(q.stack2.peek());
		System.out.println(q.peek());
		q.push(3);
		q.push(4);
		q.pop();
		q.push(5);
		System.out.println(q.pop());
		System.out.println(q.peek());

		System.out.println(q.empty());
	}
}
