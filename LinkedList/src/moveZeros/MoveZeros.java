package moveZeros;

import Node.ListNode;

public class MoveZeros {
	public ListNode moveZeros(ListNode head) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode current = dummy.next, temp = dummy;
		int i = 0;
		while (current != null) {
			while (current.value == 0) {
				++i;
				current = current.next;
			}
			temp.next = current;
			temp = current;
			current = current.next;
		}
		while (i != 0) {
			ListNode zeroNode = new ListNode(0);
			temp.next = zeroNode;
			temp = temp.next;
			--i;
		}
		temp.next = null;
		return dummy.next;
	}
}
