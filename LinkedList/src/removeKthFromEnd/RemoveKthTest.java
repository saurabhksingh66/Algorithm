package removeKthFromEnd;

import Node.ListNode;
import Node.SList;

public class RemoveKthTest {
	public static void main(String[] args) {
		SList list = new SList();
		list.addLast(15);
		list.addLast(12);
		list.addLast(45);
		list.addLast(74);
		list.addLast(87);
		list.addLast(99);
		list.display();
		RemoveKth remove = new RemoveKth();
		System.out.println("List Head: " + list.head.value);
		ListNode res = remove.removeKthFromEnd3(list.head, 5);
		System.out.println("After Result");
		for(ListNode current = res; current!=null; current = current.next){
			System.out.print(current.value + "  ");
		}
	}
}
