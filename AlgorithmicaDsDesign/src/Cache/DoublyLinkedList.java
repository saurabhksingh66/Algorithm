package Cache;

public class DoublyLinkedList {
	private DListNode head;
	private int size;

	public DoublyLinkedList() {
		this.head = new DListNode();
		this.size = 0;
	}

	public void removeAddLast(DListNode temp) {
		// unlink the node from the list
		temp.next.prev = temp.prev;
		temp.prev.next = temp.next;
		// add the node at the last
		temp.prev = head.prev;
		temp.next = head;
		head.prev.next = temp;
		head.prev = temp;
	}

	public DListNode removeFirst() {
		--size;
		DListNode temp = head.next;
		head.next.next.prev = head;
		head.next = head.next.next;
		return temp;
	}

	public int size() {
		return size;
	}

	public DListNode addLast(String key, Integer value) {
		DListNode temp = new DListNode(key, value);
		temp.prev = head.prev;
		temp.next = head;
		head.prev.next = temp;
		head.prev = temp;
		++size;
		return temp;
	}
	public void display(){
		for(DListNode current = head.next; current != head; current = current.next) {
			System.out.print("(" + current.key + "," + current.value + ")");
		}
		System.out.println();
	}
	
}
