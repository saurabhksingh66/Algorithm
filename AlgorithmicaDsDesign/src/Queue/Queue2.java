package Queue;

import java.util.Stack;

public class Queue2 {
	Stack<Integer> stack1;
	Stack<Integer> stack2;
	int front;

	Queue2() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void push(int e) {
		if (stack1.isEmpty())
			front = e;
		stack1.push(e);
	}

	public int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty())
				stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
	
	public int peek(){
		if(empty()) return -1;
		if(!stack2.isEmpty()) front = stack2.peek();
		return front;
	}
	
	public boolean empty(){
		return stack1.isEmpty()&&stack2.isEmpty();
	}
}
