package reverseGroups;

import Node.ListNode;
import Node.SList;

public class ReverseGroupsTest {
	public static void main(String[] args) {
		SList list = new SList();
		list.addLast(35);
		list.addLast(15);
		/*list.addLast(11);
		list.addLast(75);
		list.addLast(88);
		list.addLast(57);
		list.addLast(62);
		list.addLast(49);
		list.addLast(28);
		list.addLast(74);
		list.addLast(37);*/
		list.display();
		ReverseGroups reverseG = new ReverseGroups();
		ListNode res = reverseG.reverseKGroup(list.head, 1);
		for(ListNode current = res; current!=null; current=current.next){
			System.out.print(current.value + "  ");
			//System.out.println("    haha");
		}
	}
}
