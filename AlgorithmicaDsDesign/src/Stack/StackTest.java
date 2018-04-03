package Stack;

public class StackTest {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
	//	stack.push(2);
		System.out.println(stack.top());
		System.out.println(stack.empty());
		System.out.println(stack.pop());
		System.out.println(stack.empty());
		System.out.println(stack.top());
	}
}
