package removeElement;

import Node.ListNode;
import Node.SList;

public class RemoveElementTest {
	public static void main(String[] args) {
		SList list = new SList();
		list.addLast(5);
		list.addLast(42);
		list.addLast(41);
		list.addLast(5);
		list.addLast(99);
		list.addLast(78);
		list.addLast(5);
		list.addLast(5);
		list.display();
		RemoveElements remove = new RemoveElements();
		ListNode temp = remove.removeElements1(list.head, 5);
		for(ListNode current= temp;current!=null;current=current.next){
			System.out.print(current.value + "  ");
		}
	}

}
