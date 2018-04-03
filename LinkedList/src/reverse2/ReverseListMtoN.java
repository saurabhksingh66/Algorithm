/* Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list. */

package reverse2;

import java.util.LinkedList;
import java.util.Queue;

import Node.ListNode;

public class ReverseListMtoN {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || m > n)
			return null;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode p, q, temp, r;
		p = q = r = dummy;
		int i = 0;
		for (ListNode current = dummy; current != null; current = current.next) {
			if (i == m - 1)
				p = current;
			if (i == n)
				r = current;
			if (i == n + 1)
				q = current;
			++i;
		}
		if (i - 1 < n)
			return null;
		if (i - 1 == n)
			q = null;
		r.next = null;
		temp = reverse(p.next);
		while (temp.next != null) {
			p.next = temp;
			temp = temp.next;
			p = p.next;
		}
		temp.next = q;
		return dummy.next;
	}

	public ListNode reverse(ListNode head) {
		ListNode prev, temp, current;
		current = head;
		prev = null;
		while (current != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		head = prev;
		return head;
	}

	public ListNode reverseBetween2(ListNode head, int m, int n) {
		if (head == null || m > n)
			return null;
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode prev, newHead, current,temp,current1,first;
		newHead = prev = temp = dummy;
		for (int i = 1; i < m; ++i) {
			newHead = newHead.next;
		}
		prev = newHead;
		first = newHead.next;
		current = newHead.next;

		for (int i = m; i <= n; ++i) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		newHead.next = prev;
		first.next = temp;
		return dummy.next;
	}

}
