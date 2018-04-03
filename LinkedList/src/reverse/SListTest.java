package reverse;

import java.util.Random;

import Node.SList;

public class SListTest {
	public static void main(String[] args) {
		SList list = new SList();
		list.addLast(45);
		list.addLast(14);
		list.addLast(35);
		list.addLast(24);
		list.addLast(5);
		list.display();
		list.addFirst(8);
		list.display();
		
		ReverseList rList = new ReverseList();
		System.out.println("rList HEAD = " + rList.reverseList1(list.head).value);
		
	}
}
