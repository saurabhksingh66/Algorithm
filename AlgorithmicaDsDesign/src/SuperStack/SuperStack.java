/*
 * Design a Data Structure called Super Stack with following API:
 * 1-> push(e)
 * 2-> pop()
 * 3- findMin()
 * Perform above actions in O(1) time complexity.
 */

package SuperStack;

import java.util.Stack;

public class SuperStack {
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	SuperStack() {
		this.stack = new Stack<Integer>();
		this.minStack = new Stack<Integer>();
	}

	public void push(int e) {
		stack.push(e);
		if (minStack.isEmpty() || e < minStack.peek()) {
			minStack.push(e);
		}
	}

	public int pop() {
		if(stack.isEmpty()) return -1;
		int e = stack.pop();
		if (e == minStack.peek())
			minStack.pop();
		return e;
	}

	public int findMin() {
		if (minStack.isEmpty())
			return -1;
		return minStack.peek();
	}

	public void display() {
		System.out.println(stack.toString());
		System.out.println(minStack.toString());
	}

}
