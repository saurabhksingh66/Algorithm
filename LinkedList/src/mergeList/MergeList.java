/*
 * Merge two sorted linked lists and return it as a new list. The new list should be 
 * made by splicing together the nodes of the first two lists.
 */

package mergeList;

import Node.ListNode;

public class MergeList {
	
	public ListNode mergeList(ListNode l1, ListNode l2) {
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode dummy = new ListNode();
		ListNode current = dummy;
		
		while(l1 != null && l2 != null) {
			if(l1.value < l2.value) {
				current.next = l1;
				l1 = l1.next;
				current = current.next;
			}
			else {
				current.next = l2;
				l2 = l2.next;
				current = current.next;
			}
		}
		
		while(l1 != null) {
			current.next = l1;
			l1 = l1.next;
			current = current.next;
		}
		
		while(l2 != null) {
			current.next = l2;
			l2 = l2.next;
			current = current.next;
		}
		
		
		return dummy.next;
	}
}
