package detectCycle;

import java.util.HashSet;

import Node.ListNode;

/* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

 Note: Do not modify the linked list.

 Follow up:
 Can you solve it without using extra space? */

public class detectCycleNode {
	
	public ListNode hasCycle(ListNode head){
		if(head!=null){
			ListNode fast,slow;
			fast = slow = head;
			do{
				slow = slow.next;
				if(fast==null||fast.next==null)
					return null;
				fast = fast.next.next;
			}
			while(fast!=slow);
			return fast;
		}
		return null;
	}

	public ListNode cycleNode1(ListNode head) {
		if (head != null) {
			ListNode current = head;
			HashSet<ListNode> set = new HashSet<ListNode>();
			while (current != null) {
				if (set.contains(current))
					return current;
				set.add(current);
				current = current.next;
			}
		}
		return null;
	}

	public ListNode cycleNode2(ListNode head) {
		ListNode temp = hasCycle(head);
		if(temp==null) return null;
		ListNode current = head;
		while(current!=temp){
			current = current.next;
			temp = temp.next;
		}
		return current;
	}
}
