/*
 * Given a binary tree, you need to compute the length of the diameter of the tree. 
 * The diameter of a binary tree is the length of the longest path between 
 * any two nodes in a tree. This path may or may not pass through the root. 
 * */
package diameter;

import Node.BinaryTree;
import Node.TreeNode;

public class Diameter {
	int max = 0;

	public int diameter1(TreeNode root) {
		if (root == null)
			return 0;
		int[] diam = new int[1];
		diam[0] = Integer.MIN_VALUE;
		auxDiameter1(root, diam);
		return diam[0] - 1;
	}

	private int auxDiameter1(TreeNode root, int[] diam) {
		if (root == null)
			return 0;
		int lh = auxDiameter1(root.left, diam);
		int rh = auxDiameter1(root.right, diam);
		diam[0] = Math.max(diam[0], lh + rh + 1);
		return Math.max(lh, rh) + 1;
	}

	public int diameter2(TreeNode root) {
		auxDiameter2(root);
		return max-1;
	}

	private int auxDiameter2(TreeNode root) {
		if (root == null)
			return 0;
		int lh = auxDiameter2(root.left);
		int rh = auxDiameter2(root.right);
		max = Math.max(max, lh + rh + 1);
		return Math.max(lh, rh) + 1;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 0;
		TreeNode root = BinaryTree.createTree(n);
		Diameter di = new Diameter();
		System.out.println();
		tree.display1(root);
		System.out.println();
		System.out.println("Diameter1 = " + di.diameter1(root));
		System.out.println("Diameter2 = " + di.diameter2(root));
	}
}
