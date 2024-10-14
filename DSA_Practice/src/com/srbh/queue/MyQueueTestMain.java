package com.srbh.queue;

public class MyQueueTestMain {
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<>();
		queue.offer(1);
		queue.offer(9);
		queue.offer(4);
		queue.offer(8);
		queue.offer(7);
		System.out.println(queue);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue);
		System.out.println(queue.peek());
		queue.offer(6);
		System.out.println(queue);
	}
}
