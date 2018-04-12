package randomNode;

import java.util.Random;
import Node.*;

class RandomNode {
	ListNode rNode;

	public ListNode randomNode(ListNode head) {
		if (head == null)
			return head;
		Random r = new Random();
		rNode = head;
		int n = 1;
		for(ListNode current = head; current!=null;current=current.next){
			++n;
			if(r.nextInt(n)==0) rNode = current;
		}
		return rNode;
	}
}