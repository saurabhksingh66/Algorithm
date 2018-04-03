//Create a Queue data structure using stack data structure

package Queue;

import java.util.Stack;

public class Queue {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	int front;

	Queue() {
		stack1 = new Stack();
		stack2 = new Stack();
	}

	public void push(int e) {
		while (!stack1.isEmpty())
			stack2.push(stack1.pop());
		stack1.push(e);
		while (!stack2.isEmpty())
			stack1.push(stack2.pop());
	}

	public int pop() {
		if(stack1.isEmpty()) return -1;
		return stack1.pop();
	}
	public int peek(){
		if(stack1.isEmpty()) return -1;
		return stack1.peek();
	}
	public boolean empty(){
		return stack1.isEmpty();
	}
}
