/** Leetcode 206
 * Given the head of a singly linked list, reverse the list, and return the reversed list. * 
 */

package com.srbh.linkedlist;

public class ReverseList {
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return head;

		ListNode prev = null;
		ListNode current = head;

		while (current != null) {
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}

		return prev;
	}
	
	public ListNode reverseList2(ListNode head) {
		if(head == null)
			return head;
		
		ListNode prev = null;
		
		prev = reverseListRec(head, null);
		
		return prev;
	}
	

	private ListNode reverseListRec(ListNode current, ListNode prev) {
		
		if(current == null)
			return prev;
		
		ListNode temp = current.next;
		current.next = prev;
		prev = current;
		current = temp;
		
		return reverseListRec(current, prev);
	}

	public static void main(String[] args) {
		int[] in = { 1, 2, 3, 4, 5, 6 };
		SList list = new SList();
		for (int i = 0; i < in.length; i++) {
			list.addLast(in[i]);
		}
		System.out.println(list);

		ListNode newHead = new ReverseList().reverseList(list.head);
		SList.display(newHead);
	}
}
