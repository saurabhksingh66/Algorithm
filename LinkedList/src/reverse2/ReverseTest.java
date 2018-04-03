package reverse2;

import Node.ListNode;
import Node.SList;

public class ReverseTest {
	public static void main(String[] args) {
		SList list = new SList();
		list.addLast(15);
		list.addLast(12);
		list.addLast(45);
		list.addLast(74);
		list.addLast(87);
		list.addLast(99);
		list.display();

		ReverseListMtoN reverse = new ReverseListMtoN();
		ListNode res = reverse.reverseBetween2(list.head,1, 6);
		for (ListNode current = res; current != null; current = current.next) {
			System.out.print(current.value + "  ");
			//System.out.println("I am here");
		}
	}
}
