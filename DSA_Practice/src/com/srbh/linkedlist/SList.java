package com.srbh.linkedlist;

public class SList {

	ListNode head;
	ListNode last;
	
	public void addFirst(int value) {
		ListNode node = new ListNode(value);
		node.next = head;
		head = node;
		if(last == null)
			last = head;
	}
	
	public void addLast(int value) {
		ListNode node = new ListNode(value);
		if(last != null) {
			last.next = node;
			last = node;
			return;
		}
		
		last = node;
		head = node;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for(ListNode node = head; node != null; node = node.next) {
			sb.append(node.val + "    ");
		}
		return sb.toString();
	}
	
	public static void display(ListNode node) {
		StringBuilder sb = new StringBuilder("");
		for(; node != null; node = node.next) {
			sb.append(node.val + "    ");
		}
		System.out.println(sb.toString());
	}
	
	public ListNode arrayToList(int[] in) {
		for (int i = 0; i < in.length; i++) {
			this.addLast(in[i]);
		}
		return head;
	}
}
