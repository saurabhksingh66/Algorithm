package moveZeros;

import Node.ListNode;
import Node.SList;

public class moveZerosTest {
	public static void main(String[] args) {
		MoveZeros move = new MoveZeros();
		SList list = new SList();
		list.addLast(0);
		list.addLast(15);
		list.addLast(16);
		list.addLast(0);
		list.addLast(0);
		list.addLast(11);
		list.display();
		ListNode res = move.moveZeros(list.head);
		for(ListNode current = res; current!=null;current = current.next){
			System.out.print(current.value + "  ");
		}
	}
}
