/*Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass. */

package removeKthFromEnd;

import java.util.Stack;

import Node.ListNode;

public class RemoveKth {
	public ListNode removeKthFromEnd1(ListNode head, int k) {
		if (head != null) {
			int length = 0;
			ListNode temp = head;
			for (ListNode current = head; current != null; current = current.next) {
				++length;
			}
			if (k < length) {
				for (int i = 0; i < length - k - 1; ++i) {
					temp = temp.next;
				}
				temp.next = temp.next.next;
				return head;
			} else if (k == length) {
				head = head.next;
				return head;
			}
		}
		return null;
	}

	public ListNode removeKthFromEnd2(ListNode head, int k) {
		if (head != null) {
			Stack<ListNode> stack = new Stack<ListNode>();
			ListNode temp = null;
			for (ListNode current = head; current != null; current = current.next) {
				stack.add(current);
			}
			if (k < stack.size()) {
				while (k >= 0) {
					temp = stack.pop();
					k--;
				}
				temp.next = temp.next.next;
			} else if (k == stack.size()) {
				return head.next;
			}
			return head;
		}
		return null;
	}

	public ListNode removeKthFromEnd3(ListNode head, int k) {
		if (head == null)
			return null;
		if (head.next == null && k == 1)
			return null;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode start, end;
		end = dummy;
		start = dummy;
		while (k >= 1) {
			if (end == null)
				return head;
			end = end.next;
			--k;
		}
		while (!(end.next == null)) {
			start = start.next;
			end = end.next;
		}
		start.next = start.next.next;
		return dummy.next;
	}
}
