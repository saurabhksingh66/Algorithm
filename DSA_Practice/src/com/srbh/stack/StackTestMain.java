package com.srbh.stack;

public class StackTestMain {
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
		
		stack.push(5);
		stack.push(6);
		stack.push(8);
		System.out.println(stack);
		stack.pop();
		stack.pop();
		System.out.println(stack);
		stack.push(1);
		System.out.println(stack.peek());
		System.out.println(stack);
	}
}
