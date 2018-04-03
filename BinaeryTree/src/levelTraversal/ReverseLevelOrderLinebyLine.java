package levelTraversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Node.BinaryTree;
import Node.TreeNode;

public class ReverseLevelOrderLinebyLine {
	// Using Recursion ->
		// TC: O(n^2) SC:O(n) (In case of skew binary tree)
		public void levelTransversal1(TreeNode root) {
			int height = height(root);
			System.out.println("Height = " + height);
			for (int i = height; i >= 1; --i) {   // this is the only change in original code
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
		
		public void levelTransversal2(TreeNode root) {
			if (root == null)
				return;
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			Stack<TreeNode> stack = new Stack<TreeNode>();
			queue.add(root);
			TreeNode temp;
			int count = Integer.MIN_VALUE;
			while (!queue.isEmpty()) {
				count = queue.size();
				while (count != 0) {
					temp = queue.remove();
					stack.push(temp);
					if (temp.right != null)
						queue.add(temp.right);
					if (temp.left != null)
						queue.add(temp.left);
					--count;
				}
				System.out.println();
			}
			while(!stack.isEmpty())
				System.out.print(stack.pop().data + " ");	
		}
		
		public static void main(String[] args) {
			BinaryTree tree = new BinaryTree();
			int n = 15;
			TreeNode root = BinaryTree.createTree(n);
			tree.display1(root);
			System.out.println();
			ReverseLevelOrderLinebyLine reverse = new ReverseLevelOrderLinebyLine();
			reverse.levelTransversal1(root);
			System.out.println();
			System.out.println();
			System.out.println();
			reverse.levelTransversal2(root);
		}


}
