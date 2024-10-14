/** Leetcode 19
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass. 
 */
package com.srbh.linkedlist;

public class RemoveFromEnd {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;
		int length = 0;
		ListNode current = head;
		while(current != null) {
			length++;
			current = current.next;
		}
		ListNode dummyHead = new ListNode();
		dummyHead.next = head;
		current = dummyHead;
		int index = 0;
		while(current != null && current.next != null) {
			if(index == length - n) {
				current.next = current.next.next;
				break;
			}
			index++;
			current = current.next;
		}
		return dummyHead.next;
	}
	
	//TODO
	public ListNode removeNthFromEnd2(ListNode head, int n) {
		if( head == null)
			return head;
		
		ListNode dummyHead = new ListNode();
		dummyHead.next = head;
		
		while(n >= 1) {
			if(head == null)
				return dummyHead.next;
			head = head.next;
			n--;
		}
		
		ListNode current = dummyHead;
		while(head != null) {
			head = head.next;
			current = current.next;
		}
		
		current.next = current.next.next;
		
		return dummyHead.next;
		
	}
}
