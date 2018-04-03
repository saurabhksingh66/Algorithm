/*You are given two non-empty linked lists representing two non-negative integers. 
 * The most significant digit comes first and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7*/

package addTwoNumbes;

import java.util.Stack;

import Node.ListNode;

public class AddTwoNumbers2 {
	public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
		if (head1 == null && head2 == null)
			return null;
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		ListNode dummyNode = new ListNode();
		ListNode current1, current2, current3;
		int sum = 0, carry = 0, value1 = 0, value2 = 0;
		int size1, size2, size3;
		current3 = dummyNode;
		Stack<ListNode> stack1 = new Stack<ListNode>();
		for (current1 = head1; current1 != null; current1 = current1.next) {
			stack1.push(current1);
		}
		Stack<ListNode> stack2 = new Stack<ListNode>();
		for (current2 = head2; current2 != null; current2 = current2.next) {
			stack2.push(current2);
		}
		Stack<ListNode> stack3 = new Stack<ListNode>();
		size1 = stack1.size();
		size2 = stack2.size();
		while (size1 != 0 || size2 != 0 || carry != 0) {
			value1 = (size1 != 0) ? stack1.pop().value : 0;
			value2 = (size2 != 0) ? stack2.pop().value : 0;
			sum = value1 + value2 + carry;
			stack3.push(new ListNode(sum % 10));
			carry = sum / 10;
			size1 = (size1 != 0) ? size1 - 1 : 0;
			size2 = (size2 != 0) ? size2 - 1 : 0;
		}
		size3 = stack3.size();

		while (size3 != 0) {
			current3.next = stack3.pop();
			current3 = current3.next;
			--size3;
		}
		return dummyNode.next;
	}
	
	public ListNode addTwoNumbers2(ListNode head1, ListNode head2) {
		ListNode dummyNode = new ListNode();
		ListNode current1, current2, current3;
		int sum = 0, value1 = 0, value2 = 0;
		current3 = dummyNode;
		Stack<ListNode> stack1 = new Stack<ListNode>();
		for (current1 = head1; current1 != null; current1 = current1.next) {
			stack1.push(current1);
		}
		Stack<ListNode> stack2 = new Stack<ListNode>();
		for (current2 = head2; current2 != null; current2 = current2.next) {
			stack2.push(current2);
		}
		Stack<ListNode> stack3 = new Stack<ListNode>();
		while (!stack1.isEmpty() || !stack2.isEmpty() || sum != 0) {
			value1 = (!stack1.isEmpty()) ? stack1.pop().value : 0;
			value2 = (!stack2.isEmpty()) ? stack2.pop().value : 0;
			sum = sum + value1 + value2;
			stack3.push(new ListNode(sum % 10));
			sum = sum / 10;
		}

		while (!stack3.isEmpty()) {
			current3.next = stack3.pop();
			current3 = current3.next;
		}
		return dummyNode.next;
	}
	
}
