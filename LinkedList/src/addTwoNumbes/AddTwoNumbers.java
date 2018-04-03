/*You are given two non-empty linked lists representing two non-negative integers.
 *  The digits are stored in reverse order and each of their nodes contain a single digit.
 *   Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/

package addTwoNumbes;

import Node.ListNode;

public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		if (head1 == null && head2 == null)
			return null;
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		int n = 0, pass = 0;
		ListNode current1, current2, current3 = null, head3 = null, node;
		current1 = head1;
		current2 = head2;
		while (current1 != null && current2 != null) {
			n = current1.value + current2.value + pass;
			pass = 0;
			if (n > 9) {
				n = n % 10;
				pass = 1;
			}
			node = new ListNode(n);
			if (head3 == null) {
				head3 = node;
				current3 = head3;
			}
			current3.next = node;
			current3 = current3.next;
			current1 = current1.next;
			current2 = current2.next;
		}
		while (current1 != null) {
			n = current1.value + pass;
			pass = 0;
			if (n > 9) {
				n = n % 10;
				pass = 1;
			}
			node = new ListNode(n);
			current3.next = node;
			current3 = current3.next;
		}
		while (current2 != null) {
			n = current1.value + pass;
			pass = 0;
			if (n > 9) {
				n = n % 10;
				pass = 1;
			}
			node = new ListNode(n);
			current3.next = node;
			current3 = current3.next;
		}
		if(pass==1){
			node = new ListNode(1);
			current3.next = node;
			current3 = current3.next;
		}
		return head3;
	}
	
	public ListNode addTwoNumbers2(ListNode head1, ListNode head2) {
		ListNode dummyNode = new ListNode();
		ListNode current1 = head1, current2 = head2, current3;
		current3 = dummyNode;
		int sum=0, carry=0;
		while(current1!=null||current2!=null){
			sum = ((current1!=null)?current1.value:0) + ((current2!=null)?current2.value:0) + carry;
			carry = sum/10;
			current3.next = new ListNode(sum%10);
			current3 = current3.next;
			current1 = (current1!=null)?current1.next:current1;
			current2 = (current2!=null)?current2.next:current2;
		}
		if(carry>0){
			current3.next = new ListNode(carry);
			current3 = current3.next;
		}
		return dummyNode.next;
	}
}
