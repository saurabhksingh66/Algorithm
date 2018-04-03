package swapNodes;

import Node.ListNode;
import Node.SList;

public class SwapNodesTest {
	public static void main(String[] args) {
		SList list = new SList();
		SwapNodes swap = new SwapNodes();
		list.addLast(25);
		list.addLast(45);
		list.addLast(78);
		list.addLast(84);
		list.addLast(115);
		list.addLast(16);
		list.addLast(74);
	//	list.addLast(34);
		list.display();
		ListNode res = swap.swapPairs(list.head);
		for(ListNode current = res;current!=null;current= current.next){
			System.out.print(current.value + "  ");
		}
	}
}
