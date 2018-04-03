/*
 Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree 
node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.
 */

package tiltBinaryTree;

import Node.BinaryTree;
import Node.TreeNode;

public class TiltBinaryTree {

	public int tiltTree1(TreeNode root) {
		if (root == null)
			return 0;
		int[] sumTilt = new int[1];
		sumTilt[0] = 0;
		auxTiltTree(root, sumTilt);
		return sumTilt[0];
	}

	private void auxTiltTree(TreeNode root, int[] sumTilt) {
		if (root == null)
			return;

		int[] sum = { 0 };
		int leftSum = sumNodes(root.left, sum);
		sum[0] = 0;
		int rightSum = sumNodes(root.right, sum);
		sumTilt[0] = sumTilt[0] + Math.abs(leftSum - rightSum);

		auxTiltTree(root.left, sumTilt);
		auxTiltTree(root.right, sumTilt);

	}

	private int sumNodes(TreeNode root, int[] sum) {
		if (root == null)
			return 0;

		sum[0] = sum[0] + root.data;

		sumNodes(root.left, sum);
		sumNodes(root.right, sum);

		return sum[0];
	}

	public int tiltTree2(TreeNode root) {
		if (root == null)
			return 0;
		int[] sum = { 0 };
		auxTiltTree2(root, sum);
		return sum[0];
	}

	private int auxTiltTree2(TreeNode root, int[] sum) {
		if (root == null)
			return 0;

		int leftSum = auxTiltTree2(root.left, sum);
		int rightSum = auxTiltTree2(root.right, sum);

		sum[0] = sum[0] + Math.abs(rightSum - leftSum);
		return leftSum + rightSum + root.data;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(7);

		BinaryTree tree = new BinaryTree();
		tree.display1(root);

		TiltBinaryTree tilt = new TiltBinaryTree();
		System.out.println("Tilt Sum = " + tilt.tiltTree1(root));
		System.out.println("Tilt Sum = " + tilt.tiltTree2(root));
	}
}
