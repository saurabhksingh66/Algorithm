/**
 * Leetcode 203
 * Given the head of a linked list and an integer val, remove all the nodes of the 
 * linked list that has Node.val == val, and return the new head.
 */
package com.srbh.linkedlist;

public class RemoveElements {
	public ListNode removeElements(ListNode head, int val) {

		if (head == null)
			return head;

		ListNode dummyHead = new ListNode();
		dummyHead.next = head;

		ListNode first = dummyHead;

		ListNode second = head;

		System.out.print("f -> " + first.val + "   ");
		System.out.println("s -> " + second.val);

		while (second != null) {
			if (second.val != val) {
				first.next = second;
				first = first.next;
			}
			second = second.next;
		}

		first.next = null;

		return dummyHead.next;
	}
	
	public ListNode removeElements1(ListNode head, int value) {
		ListNode dummyNode = new ListNode();
		dummyNode.next = head;
		ListNode prev, current;
		prev = dummyNode;
		current = head;
		while (current != null) {
			System.out.print("f -> " + prev.val + "   ");
			System.out.println("s -> " + current.val);
			if (current.val == value)
				prev.next = current.next;
			else
				prev = current;
			current = current.next;
		}
		return dummyNode.next;
	}

	public static void main(String[] args) {
		int[] in = { 6, 6, 6, 1, 2, 6, 3, 4, 5, 6, 6 };
		SList list = new SList();
		for (int i = 0; i < in.length; i++) {
			list.addLast(in[i]);
		}
		System.out.println(list);

		ListNode newHead = new RemoveElements().removeElements1(list.head, 6);
		SList.display(newHead);

	}
}
