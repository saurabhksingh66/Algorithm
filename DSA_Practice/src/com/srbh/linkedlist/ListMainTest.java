package com.srbh.linkedlist;

public class ListMainTest {
	public static void main(String[] args) {
//		SList list = new SList();
		
//		list.addFirst(5);
//		list.addFirst(7);
//		list.addLast(33);
//		list.addFirst(4);
//		list.addLast(67);
//		list.addLast(89);
//		list.addFirst(9);
//		
//		System.out.println(list.head.val);
//		System.out.println(list.last.val);
//		System.out.println(list);
		
//		int[] in = { 1, 2, 5, 5, 6, 2, 1 };
//		SList list = new SList();
//		for (int i = 0; i < in.length; i++) {
//			list.addLast(in[i]);
//		}
//		System.out.println(list);
		
		int[] in1 = { 2,4,3 };
		ListNode l1 = new SList().arrayToList(in1);
		SList.display(l1);
	}
}
