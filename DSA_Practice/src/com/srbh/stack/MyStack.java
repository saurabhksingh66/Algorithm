package com.srbh.stack;

import java.util.Iterator;
import java.util.LinkedList;

public class MyStack<T> implements Iterable<T>{
	private LinkedList<T> stack = new LinkedList<>();

	public MyStack() {
	}

	public MyStack(T value) {
		push(value);
	}

	public int getSize() {
		return stack.size();
	}
	
	public boolean isEmpty() {
		return stack.size() == 0;
	}

	public void push(T value) {
		stack.addLast(value);
	}

	public T pop() {
		if(isEmpty())
			throw new java.util.EmptyStackException();
		return stack.removeLast();
	}
	
	public T peek() {
		if(isEmpty())
			throw new java.util.EmptyStackException();
		return stack.peekLast();
	}

	@Override
	public Iterator<T> iterator() {
		return stack.iterator();
	}

	@Override
	public String toString() {
		return "MyStack [stack=" + stack + "]";
	}
}
