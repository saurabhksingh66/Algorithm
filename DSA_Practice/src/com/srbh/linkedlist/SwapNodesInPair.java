/** Leetcode 24
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem 
 * without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values
 * in the list, only nodes itself can be changed.
 */
package com.srbh.linkedlist;

public class SwapNodesInPair {

	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode dummyHead = new ListNode();
		
		dummyHead.next = head;
		
		ListNode first = head;
		ListNode second = head.next;
		ListNode prev = dummyHead;
		ListNode temp;
		
		while(first != null && second != null) {
			
			temp = second.next;
			
			prev.next = second;
			second.next = first;
			first.next = temp;
			
			prev = first;
			first = temp;
			second = temp != null ? temp.next : null;
			
		}
		
		
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		int[] in1 = { 2,4,3, 5 };
		ListNode l1 = new SList().arrayToList(in1);
		SList.display(l1);
		
		SList.display(swapPairs(l1));
	}
}
