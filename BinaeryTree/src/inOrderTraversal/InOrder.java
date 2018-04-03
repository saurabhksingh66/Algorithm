//Inorder Tree Traversal without Recursion

package inOrderTraversal;

import java.util.Stack;
import Node.BinaryTree;
import Node.TreeNode;

public class InOrder {

	// Using recursion ->
	// TC = O(n) SC = O(n)
	public void inOrder1(TreeNode root) {
		if (root == null)
			return;
		inOrder1(root.left);
		System.out.print(root.data + " ");
		inOrder1(root.right);
	}

	// without recursion
	// TC = O(n) SC = O(n)
	public void inOrder2(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode temp = root;

		while (temp != null) {
			stack.push(temp);
			temp = temp.left;
		}

		while (!stack.isEmpty()) {
			temp = stack.pop();
			System.out.print(temp.data + " ");
			if (temp.right != null) {
				temp = temp.right;
				while (temp != null) {
					stack.push(temp);
					temp = temp.left;
				}

			}
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 5;
		TreeNode root = BinaryTree.createTree(n);
		tree.display1(root);
		System.out.println();
		InOrder inorder = new InOrder();
		inorder.inOrder1(root);
		System.out.println();
		inorder.inOrder2(root);
	}
}
