/*Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?*/

package palindrome;

import java.util.Stack;

import Node.ListNode;

public class Palindrome {
	public boolean isPalindrome(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		for (ListNode current = head; current != null; current = current.next) {
			stack.push(current);
		}
		for (ListNode current = head; current != null; current = current.next) {
			if (stack.pop().value != current.value)
				return false;
		}
		return true;
	}

	public boolean isPalindrome2(ListNode head) {
		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode slow, fast, prev, current, temp;
		slow = fast = dummy;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		prev = null;
		current = slow.next;
		while (current != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		slow.next = prev;
		current = head;
		
		while (prev != null) {
			if (current.value != prev.value)
				return false;
			current=current.next;
			prev=prev.next;
		}
		return true;
	}
}
