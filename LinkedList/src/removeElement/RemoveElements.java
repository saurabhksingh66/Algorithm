/*Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5 */
package removeElement;

import Node.ListNode;

public class RemoveElements {
	public ListNode removeElements(ListNode head, int value) {
		ListNode dummyNode = new ListNode();
		dummyNode.next = head;
		ListNode first, second;
		first = dummyNode;
		second = head;
		while (second != null) {
			if (second.value != value) {
				first.next = second;
				first = first.next;
			}
			second = second.next;
		}
		first.next = null;
		return dummyNode.next;
	}

	public ListNode removeElements1(ListNode head, int value) {
		ListNode dummyNode = new ListNode();
		dummyNode.next = head;
		ListNode prev, current;
		prev = dummyNode;
		current = head;
		while (current != null) {
			if (current.value == value)
				prev.next = current.next;
			else
				prev = current;
			current = current.next;
		}
		return dummyNode.next;
	}
}
