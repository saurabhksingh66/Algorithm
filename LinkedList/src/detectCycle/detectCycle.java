package detectCycle;

import java.util.HashSet;

import Node.ListNode;

/* Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space? */

public class detectCycle {

	public boolean hasCycle1(ListNode head) {
		if (head != null) {
			ListNode current = head;
			HashSet<ListNode> set = new HashSet<ListNode>();
			while (current != null) {
				if (set.contains(current))
					return true;
				set.add(current);
				current = current.next;
			}
		}
		return false;
	}

	public boolean hasCycle2(ListNode head) {
		if (head != null && head.next != null) {
			ListNode fast, slow;
			fast = slow = head;
			do {
				slow = slow.next;
				if (fast == null || fast.next == null || slow == null)
					return false;
				fast = fast.next.next;

			} while (!(fast == slow));
			return true;
		}
		return false;
	}

}
