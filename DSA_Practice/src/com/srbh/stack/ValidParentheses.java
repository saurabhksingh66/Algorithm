/** Leetcode 20
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */

package com.srbh.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class ValidParentheses {
	public static boolean isValid(String s) {
		if (s == null || s.isEmpty())
			return true;

		Stack<String> stack = new Stack<>();

		ArrayList<String> openBrackets = new ArrayList<>(Arrays.asList("(", "{", "["));
		ArrayList<String> closeBrackets = new ArrayList<>(Arrays.asList(")", "}", "]"));

		for (int i = 0; i < s.length(); i++) {
			String c = String.valueOf(s.charAt(i));
			if (openBrackets.contains(c))
				stack.push(c);
			else if (closeBrackets.contains(c)) {
				if (stack.isEmpty())
					return false;
				String openMatch = stack.pop();
				if (")".equals(c) && !"(".equals(openMatch))
					return false;
				if ("}".equals(c) && !"{".equals(openMatch))
					return false;
				if ("]".equals(c) && !"[".equals(openMatch))
					return false;

			}
		}
		if (!stack.isEmpty())
			return false;

		return true;

	}

	public static boolean isValid1(String s) {
		if (s == null || s.length() < 1)
			return true;

//		Stack<Character> stack = new Stack<>();

		Deque<Character> stack = new ArrayDeque<>();

		for (char c : s.toCharArray()) {

			if (!stack.isEmpty() && stack.peek() == closingMatch(c))
				stack.pop();
			else
				stack.push(c);
		}
		return stack.isEmpty();
	}

	private static char closingMatch(char c) {
		return switch (c) {
		case ')' -> '(';
		case ']' -> '[';
		case '}' -> '{';
		default -> ' ';
		};

	}

	public static void main(String[] args) {
		String s = "())";
		System.out.println(isValid1(s));
	}
}
