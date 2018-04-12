package palindrome;

import Node.SList;

public class PalindromeTest {
	public static void main(String[] args) {
		SList list = new SList();
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		//list.addLast(8);
		list.addLast(1);
		list.addLast(2);
		list.display();
		Palindrome pal = new Palindrome();
		System.out.println("Is Palindrome: " + pal.isPalindrome2(list.head));
	}
}
