package TST;

import java.util.LinkedList;
import java.util.List;

class TSTNode {
	TSTNode left, right, middle;
	boolean isWord;
	char data;

	public TSTNode(char data) {
		super();
		this.data = data;
	}
}

public class TST implements ITrie {

	private TSTNode root;

	@Override
	public boolean add(String word) {
		TSTNode current = root, parent = null;
		int i = 0;

		while (i < word.length() && current != null) {
			parent = current;
			if (word.charAt(i) == current.data) {
				current = current.middle;
				i = i + 1;
			} else if (word.charAt(i) < current.data)
				current = current.left;
			else
				current = current.right;
		}

		// if word is already available
		if (i == word.length()) {
			parent.isWord = true;
			return true;
		}

		// if word is not available
		TSTNode temp = new TSTNode(word.charAt(i++));
		TSTNode start = temp;
		while (i < word.length()) {
			temp.middle = new TSTNode(word.charAt(i++));
			temp = temp.middle;
		}
		temp.isWord = true;

		// fitting this series in its right place
		if (parent == null)
			root = start;
		else {
			if (start.data > parent.data)
				parent.right = start;
			else
				parent.left = start;
		}

		return true;
	}

	@Override
	public boolean remove(String word) {

		return false;
	}

	@Override
	public boolean contains(String word) {
		TSTNode temp = findLastPrefixNode(root, word);
		return (temp == null ? false : temp.isWord);
	}

	private TSTNode findLastPrefixNode(TSTNode root, String word) {
		TSTNode current = root;
		int i = 0;
		while (i < word.length() && current != null) {
			if (word.charAt(i) == current.data) {
				if (i == word.length() - 1)
					return current;
				current = current.middle;
				++i;
			} else if (word.charAt(i) < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (current == null)
			return null;
		return current;
	}

	public List<String> autoComplete(String prefix) {
		TSTNode temp = findLastPrefixNode(root, prefix);
		if (temp == null)
			return null;
		
		List<String> words = new LinkedList<String>();
		if (temp.isWord == true)
			words.add(prefix);
		
		inOrder(temp.middle, prefix, words);
		return words;
	}

	private void inOrder(TSTNode current, String prefix, List<String> words) {
		if (current == null)
			return;

		inOrder(current.left, prefix, words);

		if (current.isWord == true)
			words.add(prefix + current.data);

		inOrder(current.middle, prefix + current.data, words);
		inOrder(current.right, prefix, words);
	}

	@Override
	public void displayAll() {
		List<String> words = new LinkedList<String>();
		inOrder(root, "", words);
		System.out.println(words);
	}

	@Override
	public void print() {
		auxPrint(root, 0, "root");
	}

	private static void auxPrint(TSTNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data + "(" + type + "," + root.isWord + ")");
		auxPrint(root.left, nspaces + 4, "L");
		auxPrint(root.middle, nspaces + 4, "M");
		auxPrint(root.right, nspaces + 4, "R");
	}

}
