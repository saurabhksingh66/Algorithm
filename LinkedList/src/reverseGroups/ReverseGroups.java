/* Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number 
of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5 */

package reverseGroups;

import Node.ListNode;

public class ReverseGroups {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode();
		dummy.next = head;
		int i = 1;
		ListNode prev, current, temp, start, PREV;
		prev = temp = PREV = dummy;
		current = start = head;
		int j = 1, length = 0;
		while (current != null) {
			++length;
			current = current.next;
		}
		if (k > length) {
			return head;
		}
		j = 1;

		while (true) {
			current = start;
			prev = PREV;
			while (i <= j * k) {
				++i;
				temp = current.next;
				current.next = prev;
				prev = current;
				current = temp;
			}
			++j;
			PREV.next = prev;

			if (temp == null) {
				start.next = null;
				return dummy.next;
			}
			if (j > length / k) {
				System.out.println("I am here");
				start.next = temp;
				return dummy.next;
			}
			PREV = start;
			start = temp;
		}

	}
}
