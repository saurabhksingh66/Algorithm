package SuperQueue;

public class SuperQueueTest {
	public static void main(String[] args) {
		SuperQueue sq = new SuperQueue();
		sq.enqueue(5);
		sq.display();
		sq.enqueue(7);
		sq.display();
		sq.enqueue(3);
		sq.display();
		System.out.println(sq.dequeue());
		System.out.println("Min = "+sq.findMin());
		sq.display();
		sq.enqueue(11);
		sq.enqueue(9);
		sq.enqueue(13);
		sq.display();
		System.out.println(sq.dequeue());
		sq.display();
		System.out.println(sq.dequeue());
		System.out.println("Min = "+sq.findMin());
	}

}
