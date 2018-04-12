/* Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values
 in the list, only nodes itself can be changed. */

package swapNodes;

import Node.ListNode;

public class SwapNodes {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummyNode = new ListNode();
		dummyNode.next = head;
		ListNode prev, first, second, temp;
		prev = dummyNode;
		first = head;
		second = head.next;
		temp = second.next;
		while (true) {
			prev.next = second;
			second.next = first;
			first.next = temp;
			if (temp == null || temp.next == null)
				break;
			prev = first;
			first = temp;
			second = temp.next;
			temp = second.next;
		}
		return dummyNode.next;
	}

}
