/** Leetcode 83
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once. 
 * Return the linked list sorted as well.
 * 
 */

package com.srbh.linkedlist;

public class RemoveDuplicate {

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode first = head;
		ListNode second = head.next;
		
		while(second != null) {
			if(first.val != second.val) {
				first.next = second;
				first = first.next;
			}
			second = second.next;
		}
		
		first.next = null;
		
		return head;
	}
}
