/**
 * Leetcode 21
 * You are given the heads of two sorted linked lists list1 and list2.

 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

 * Return the head of the merged linked list.
 */
package com.srbh.linkedlist;

public class MergeList {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummyHead = new ListNode();

		ListNode first = list1;
		ListNode second = list2;
		ListNode current = dummyHead;

		while (first != null && second != null) {
			if(first.val > second.val) {
				current.next = second;
				second = second.next;
			} else {
				current.next = first;
				first = first.next;
			}
			current = current.next;
		}
		
		while(first != null) {
			current.next = first;
			current = current.next;
			first = first.next;
		}
		
		while (second != null) {
			current.next = second;
			current = current.next;
			second = second.next;
		}

		return dummyHead.next;
	}
}
