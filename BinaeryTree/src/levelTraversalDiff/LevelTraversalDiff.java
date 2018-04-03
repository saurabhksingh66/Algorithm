package levelTraversalDiff;

import Node.BinaryTree;
import Node.TreeNode;

public class LevelTraversalDiff {

	public void levelPrint(TreeNode root) {
		if (root == null)
			return;
		int heightLeft = height(root.left);
		int heightRight =  height(root.right);
		if(heightLeft!=heightRight) return;
		int height = heightLeft + 1;
		for (int i = height; i >= 1; i--) {
			auxLevelPrint(root, root, root, i);
			System.out.println();
		}
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	private void auxLevelPrint(TreeNode root, TreeNode root1, TreeNode root2,
			int height) {
		if (root1 == null || root2 == null)
			return;

		if (root1 == root && root2 == root && height == 1) {
			System.out.print(root.data + " ");
		} else if (height == 1) {
			System.out.print(root1.data + " " + root2.data + " ");
			return;
		}

		auxLevelPrint(root, root1.left, root2.right, height - 1);

		if (root1 == root || root2 == root)
			return;

		auxLevelPrint(root, root1.right, root2.left, height - 1);
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		TreeNode root = tree.createTree(7);
		tree.display1(root);
		
		LevelTraversalDiff diff = new LevelTraversalDiff();
		diff.levelPrint(root);
	}
}
