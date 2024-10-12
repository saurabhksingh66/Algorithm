/** Leetcode 141
 * 
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.

 * There is a cycle in a linked list if there is some node in the list that can be reached again 
 * by continuously following the next pointer. Internally, pos is used to denote the index of the 
 * node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
package com.srbh.linkedlist;

import java.util.HashSet;

public class DetectCycle {
	public class Solution {
		public boolean hasCycle(ListNode head) {
			if(head == null)
				return false;
			
			HashSet<ListNode> set = new HashSet<ListNode>();
			ListNode current = head;
			while(current != null) {
				if(set.contains(current))
					return true;
				set.add(current);
				current = current.next;
			}
			
			return false;
		}
	}
	
	public boolean hasCycle1(ListNode head) {
		if(head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				return true;
		}
		return false;
	}
}
