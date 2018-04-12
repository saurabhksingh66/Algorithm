package randomNode;

import Node.*;

public class randomTest {
	public static void main(String[] args) {
		SList list = new SList();
		list.addLast(43);
		list.addLast(83);
		list.addLast(22);
		list.addLast(16);
		list.addLast(35);
		list.display();
		System.out.println("list HEAD = " + list.head.value);
		
		RandomNode rNode = new RandomNode();
		System.out.println(rNode.randomNode(list.head).value);
	}
}
