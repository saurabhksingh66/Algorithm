package reverse;

import Node.*;

public class ReverseList {

	public ListNode reverseList1(ListNode head) {
		if (head == null)
			return null;
		ListNode current = head, prev = null;

		while (current != null) {
			ListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		head = prev;
		System.out.println();
		return head;
	}
	
	public ListNode reverseList2(ListNode head) {
		if (head == null)
			return null;
		ListNode prev = null;
		prev = auxReverseList2(head,null,null);
		System.out.println(prev.value);
		return prev;
	}
	
	private ListNode auxReverseList2(ListNode current, ListNode prev, ListNode temp) {
		if(current == null)
			return prev;
		temp = current.next;
		current.next = prev;
		prev = current;
		return auxReverseList2(temp,prev,temp);
	}

	public static void main(String[] args) {
		SList list = new SList();
		list.addLast(45);
		list.addLast(14);
		list.addLast(35);
		list.addLast(24);
		list.addLast(5);
		list.addFirst(8);
		list.display();

		ReverseList rList = new ReverseList();
		SList.head = rList.reverseList2(SList.head);
		list.display();
	}

}
