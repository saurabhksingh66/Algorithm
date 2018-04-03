package depthOfTree;

import Node.BinaryTree;
import Node.MyInteger;
import Node.TreeNode;

public class LongestRoot2LeafPath {

	// TC-> O(n) SC-> O(n)
	public int height1(TreeNode root) {
		if (root == null)
			return 0;
		int lh = height1(root.left);
		int rh = height1(root.right);
		return Math.max(lh, rh) + 1;
	}

	public int height2(TreeNode root) {
		int height = 0;
		MyInteger temp = new MyInteger(Integer.MIN_VALUE);
		return auxHeight2(root, height, temp);
	}

	private int auxHeight2(TreeNode root, int height, MyInteger temp) {
		//System.out.println("aux2");
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			temp.setX(Math.max(height + 1, temp.getX()));
		auxHeight2(root.left, height + 1, temp);
		auxHeight2(root.right, height + 1, temp);
		return temp.getX();
	}

	public int height3(TreeNode root) {
		if (root == null)
			return 0;
		int height = 1;
		int[] in = new int[1];
		in[0] = Integer.MIN_VALUE;
		auxHeight3(root, height, in);
		return in[0];
	}

	private void auxHeight3(TreeNode root, int height, int[] in) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			in[0] = Math.max(in[0], height);
		}
		auxHeight3(root.left, height + 1, in);
		auxHeight3(root.right, height + 1, in);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		LongestRoot2LeafPath r2l = new LongestRoot2LeafPath();
		int n = 1;
		TreeNode root = BinaryTree.createTree(n);
		System.out.println();
		tree.display1(root);
		System.out.println();
		System.out.println("height1 = " + r2l.height1(root));
		System.out.println("height2 = " + r2l.height2(root));
		System.out.println("height3 = " + r2l.height3(root));
	}
}
