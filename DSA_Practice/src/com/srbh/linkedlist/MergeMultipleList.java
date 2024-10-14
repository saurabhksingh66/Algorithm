/** Leetcode 23
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * Example:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 */

package com.srbh.linkedlist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeMultipleList {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length < 1)
			return null;

		ListNode dummyHead = new ListNode();

		int value = Integer.MIN_VALUE;
		ListNode current;
		int length = 0;

		for (int i = 0; i < lists.length; i++) {
			current = lists[i];
			while (current != null) {
				length++;
				current = current.next;
			}
		}

		int[] tempArr = new int[length];
		int index = 0;

		for (int i = 0; i < lists.length; i++) {
			current = lists[i];
			while (current != null) {
				tempArr[index++] = current.val;
				current = current.next;
			}
		}

		Arrays.sort(tempArr);

		current = dummyHead;
		for (int i = 0; i < tempArr.length; i++) {
			current.next = new ListNode(tempArr[i]);
			current = current.next;
		}

		return dummyHead.next;
	}

	public <T> ListNode mergeKLists1(ListNode[] lists) {
		if (lists == null)
			return null;
		ListNode dummyHead = new ListNode();
		ListNode current = dummyHead;

		PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode node1, ListNode node2) {
				// TODO Auto-generated method stub
				return node1.val - node2.val;
			}

		});

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				queue.add(lists[i]);
		}

		while (queue.peek() != null) {
			ListNode temp = queue.poll();
			current.next = new ListNode(temp.val);
			current = current.next;
			if (temp.next != null)
				queue.add(temp.next);
		}

		return dummyHead.next;
	}
}
