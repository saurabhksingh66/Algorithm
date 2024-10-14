package com.srbh.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyQueue<T> implements Iterable<T> {
	private LinkedList<T> queue = new LinkedList<>();

	public MyQueue() {

	}

	public MyQueue(T value) {
		offer(value);
	}

	public int size() {
		return queue.size();
	}

	public boolean isEmpty() {
		return queue.size() == 0;
	}

	public T peek() {
		if (isEmpty())
			throw new NoSuchElementException();
		return queue.peekFirst();
	}

	public T poll() {
		if (isEmpty())
			throw new NoSuchElementException();
		return queue.pollFirst();
	}

	public void offer(T value) {
		queue.offerLast(value);
	}

	@Override
	public Iterator<T> iterator() {
		return queue.iterator();
	}

	@Override
	public String toString() {
		return "MyQueue [queue=" + queue + "]";
	}

}
