/** Leetcode 2
 * You are given two non-empty linked lists representing two non-negative integers.
 *  The digits are stored in reverse order and each of their nodes contain a single digit.
 *   Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
package com.srbh.linkedlist;

public class Add2NumbersReverse {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode dummyHead = new ListNode();
		ListNode current = dummyHead;

		int carry = 0;
		int sum = 0;

		while (l1 != null && l2 != null) {
			sum = l1.val + l2.val + carry;
			carry = sum / 10;
			sum = sum % 10;
			current.next = new ListNode(sum);
			current = current.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			if (carry == 1) {
				sum = carry + l1.val;
				carry = sum / 10;
				sum = sum % 10;
			} else
				sum = l1.val;
			current.next = new ListNode(sum);
			current = current.next;
			l1 = l1.next;

		}

		while (l2 != null) {
			if (carry == 1) {
				sum = carry + l2.val;
				carry = sum / 10;
				sum = sum % 10;
			} else
				sum = l2.val;
			current.next = new ListNode(sum);
			current = current.next;
			l2 = l2.next;
		}

		if (carry != 0)
			current.next = new ListNode(carry);

		return dummyHead.next;

	}

	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode();
		ListNode current = dummyHead;
		int sum = 0, carry = 0;
		
		while(l1 != null || l2 != null || carry != 0) {
			sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
			carry = sum / 10;
			sum = sum % 10;
			current.next = new ListNode(sum);
			current = current.next;
			l1 = l1 != null ? l1.next: l1;
			l2 = l2 != null ? l2.next : l2;
		}
		
		return dummyHead.next;
	}

	public static void main(String[] args) {
		int[] in1 = { 2, 4, 9 };
		ListNode l1 = new SList().arrayToList(in1);
		SList.display(l1);
		int[] in2 = { 5, 6, 4, 5 };
		ListNode l2 = new SList().arrayToList(in2);
		SList.display(l2);

		ListNode l3 = addTwoNumbers(l1, l2);
		SList.display(l3);
	}
}
