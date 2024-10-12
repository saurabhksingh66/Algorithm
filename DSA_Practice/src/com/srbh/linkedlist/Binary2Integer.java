/** Leetcode 1290
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. 
 * The linked list holds the binary representation of a number
 * 
 * Return the decimal value of the number in the linked list.
 * 
 * The most significant bit is at the head of the linked list.
 */
package com.srbh.linkedlist;

public class Binary2Integer {

	public int getDecimalValue(ListNode head) {
		if (head == null || head.next == null)
			return head.val;

		StringBuilder sb = new StringBuilder("");
		
		while(head != null) {
			sb.append(head.val);
			head = head.next;
		}
		
		return Integer.parseInt(sb.toString(), 2);
	}
}
