/** Leetcode 61
 * Given the head of a linked list, rotate the list to the right by k places.
 * Example:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */

package com.srbh.linkedlist;

public class RotateList {

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k < 1)
			return head;

		int length = 0;
		ListNode current = head;
		while (current != null) {
			current = current.next;
			length++;
		}

		if (k > length)
			k = k % length;

		current = head;
		int prevValue = 0;
		int tmp = 0;

		while (k > 0) {
			current = head.next;
			prevValue = head.val;
			while (current != null) {
				tmp = current.val;
				current.val = prevValue;
				prevValue = tmp;
				current = current.next;
			}
			head.val = prevValue;
			k--;
		}

		return head;

	}

	public static ListNode rotateRight1(ListNode head, int k) {
		if (head == null || head.next == null || k < 1)
			return head;

		ListNode dummyHead = new ListNode();
		dummyHead.next = head;

		ListNode current = head;
		ListNode tail = null;
		int length = 0;
		while (current != null) {
			tail = current;
			current = current.next;
			length++;
		}


		if (k >= length)
			k = k % length;
		
		if (k == 0)
			return head;
		
		int index = 0;
		current = head;
		while (index < length - k - 1) {
			current = current.next;
			index++;
		}
		
		dummyHead.next = current.next;
		current.next = null;
		tail.next = head;

		return dummyHead.next;
	}

	public static void main(String[] args) {
		int[] in1 = { 1,2 };
		ListNode l1 = new SList().arrayToList(in1);
		SList.display(l1);
		SList.display(rotateRight1(l1, 2));
	}
}
