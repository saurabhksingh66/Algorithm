//Print level order traversal line by line 

package levelTraversal;

import java.util.LinkedList;
import java.util.Queue;

import Node.BinaryTree;
import Node.TreeNode;

public class LevelTraversalLinebyLine {

	// Using Recursion ->
	// TC: O(n^2) SC:O(n) (In case of skew binary tree)
	public void levelTransversal1(TreeNode root) {
		int height = height(root);
		System.out.println("Height = " + height);
		for (int i = 1; i <= height; ++i) {
			printLevel(root, i);
			System.out.println();
		}
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	private void printLevel(TreeNode root, int height) {
		if (root == null)
			return;
		if (height == 1)
			System.out.print(root.data + " ");
		else if (height > 1) {
			printLevel(root.left, height - 1);
			printLevel(root.right, height - 1);
		}
	}

	// Using iteration
	// TC = O(n) SC = O(n)
	public void levelTransversal2(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode temp;
		int count = Integer.MIN_VALUE;
		while (!queue.isEmpty()) {
			count = queue.size();
			while (count != 0) {
				temp = queue.remove();
				System.out.print(temp.data + " ");
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
				--count;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 5;
		TreeNode root = BinaryTree.createTree(n);
		tree.display1(root);
		System.out.println();
		LevelTraversalLinebyLine lt = new LevelTraversalLinebyLine();
		lt.levelTransversal1(root);
		System.out.println();
		lt.levelTransversal2(root);
	}
}
