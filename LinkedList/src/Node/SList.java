package Node;

public class SList {
	public static ListNode head;
	public ListNode last;

	public SList() {
	}

	public void addFirst(int value) {
		ListNode node = new ListNode(value);
		if (head == null) {
			head = node;
			head.next = null;
			return;
		}
		node.next = head;
		head = node;
	}

	public void addLast(int value) {
		ListNode node = new ListNode(value);
		if (head == null) {
			head = node;
			head.next = null;
			return;
		}
		last = head;
		while (last.next != null)
			last = last.next;
		node.next = null;
		last.next = node;
		last = node;
	}

	public void display() {
		for (ListNode node = head; node != null; node = node.next) {
			System.out.print(node.value + "  ");
		}
		System.out.println();
	}

}
