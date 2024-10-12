/** Leetcode 234
 * Given the head of a singly linked list, return true if it is a 
 * palindrome or false otherwise.
 * 
 */
package com.srbh.linkedlist;

import java.util.Stack;

public class Palindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;

		ListNode current = head;
		Stack<Integer> stack = new Stack<>();

		while (current != null) {
			stack.push(current.val);
			current = current.next;
		}

		current = head;

		while (current != null) {
			if (current.val != stack.pop())
				return false;
			current = current.next;
		}

		return true;
	}

	public boolean isPalindrome2(ListNode head) {

		ListNode dummyNode = new ListNode();
		dummyNode.next = head;
		
		ListNode slow = dummyNode;
		ListNode fast = dummyNode;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode newHead = reverseList(slow.next);
		
		SList.display(newHead);
		
		while(newHead != null) {
			if(head.val != newHead.val)
				return false;
			head = head.next;
			newHead = newHead.next;
		}
		
		return true;
	}

	private ListNode reverseList(ListNode head) {
		if (head == null)
			return head;

		ListNode prev = null;
		ListNode current = head;

		while (current != null) {
			ListNode tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}

		return prev;
	}

	public static void main(String[] args) {
		int[] in = { 1, 2, 5, 5, 6, 2, 1 };
		SList list = new SList();
		for (int i = 0; i < in.length; i++) {
			list.addLast(in[i]);
		}
		System.out.println(list);

		System.out.println(new Palindrome().isPalindrome2(list.head));
	}
}
