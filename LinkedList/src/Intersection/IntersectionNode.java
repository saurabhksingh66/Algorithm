package Intersection;

import java.util.HashSet;

import Node.ListNode;

public class IntersectionNode {

	public ListNode intersectionNode1(ListNode head1, ListNode head2) {
		if (head1 != null || head2 != null) {
			HashSet<ListNode> set = new HashSet<ListNode>();
			for (ListNode current = head1; current != null; current = current.next) {
				set.add(current);
			}
			for (ListNode current = head2; current != null; current = current.next) {
				if (set.contains(current))
					return current;
			}
		}
		return null;
	}

	public ListNode intersectionNode2(ListNode head1, ListNode head2) {
		if (head1 != null && head2 != null) {
			ListNode current1 = head1, current2 = head2;
			int m = 0, n = 0;
			for (ListNode current = head1; current != null; current = current.next) {
				++m;
			}
			for (ListNode current = head2; current != null; current = current.next) {
				++n;
			}
			while (m > n) {
				current1 = current1.next;
				--m;
			}
			while (m < n) {
				current2 = current2.next;
				--n;
			}
			while (current1 != current2) {
				current1 = current1.next;
				current2 = current2.next;
			}
			return current1;
		}
		return null;
	}
}
