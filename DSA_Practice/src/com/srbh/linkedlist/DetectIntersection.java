/** Leetcode 160
 * Given the heads of two singly linked-lists headA and headB, return the node at 
 * which the two lists intersect. If the two linked lists have no intersection at all, return null.
 */

package com.srbh.linkedlist;

import java.util.HashSet;

public class DetectIntersection {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		
		ListNode current = headA;
		
		HashSet<ListNode> set = new HashSet<>();
		
		while(current != null) {
			set.add(current);
			current = current.next;
		}
		
		current = headB;
		
		while(current != null) {
			if(set.contains(current))
				return current;
			current = current.next;
		}
		return null;
	}
	
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		
		if(headA == null || headB == null)
			return null;
		
		int aLength = 0;
		int bLength = 0;
		
		ListNode current = headA;
		while(current != null) {
			aLength++;
			current = current.next;
		}
		
		current = headB;
		while(current != null) {
			bLength++;
			current = current.next;
		}
		
		ListNode currentA = headA;
		ListNode currentB = headB;
		
		while(aLength > bLength) {
			currentA = currentA.next;
			aLength--;
		}
		
		while(bLength > aLength) {
			currentB = currentB.next;
			bLength--;
		}
		
		while(currentA != currentB) {
			currentA = currentA.next;
			currentB = currentB.next;
		}
		return currentA;
	}
}
