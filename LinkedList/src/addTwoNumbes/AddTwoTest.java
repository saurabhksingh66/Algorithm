package addTwoNumbes;

import Node.ListNode;
import Node.SList;

public class AddTwoTest {
	
	public static void main(String[] args) {
		SList list1 = new SList();
		list1.addLast(9);
		list1.addLast(5);
		list1.addLast(9);
		list1.addLast(9);
		list1.display();
		SList list2 = new SList();
		list2.addLast(6);
		list2.addLast(7);
		list2.addLast(8);
		list2.display();
		AddTwoNumbers2 add = new AddTwoNumbers2();
		ListNode temp = add.addTwoNumbers2(list1.head, list2.head);
		System.out.println("After Addition");
		for(ListNode current = temp; current!= null; current = current.next){
			System.out.print(current.value + "  ");
		}
	}

}
