package SuperStack;

public class SuperStackTest {
	public static void main(String[] args) {
		SuperStack ss = new SuperStack();
		ss.push(25);
		ss.push(24);
		ss.push(23);
		ss.display();
		ss.push(5);
		ss.push(20);
		ss.push(15);
		ss.display();
	}
}
