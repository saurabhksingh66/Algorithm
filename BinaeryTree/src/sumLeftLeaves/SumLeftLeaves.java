package sumLeftLeaves;

import Node.BinaryTree;
import Node.TreeNode;

public class SumLeftLeaves {

	public int sumLeftLeaves1(TreeNode root) {
		if (root == null)
			return 0;
		int[] sum = new int[1];
		sum[0] = 0;
		auxSum1(root, sum);
		return sum[0];
	}

	private void auxSum1(TreeNode root, int[] sum) {
		if (root == null)
			return;
		if (root.left != null && root.left.left == null
				&& root.left.right == null) {
			sum[0] = sum[0] + root.left.data;
		}
		auxSum1(root.left, sum);
		auxSum1(root.right, sum);
	}
	
	public int sumLeftLeaves2(TreeNode root){
		if (root == null)
			return 0;
		int[] sum = new int[1];
		sum[0] = 0;
		auxSum2(root, sum, 0);
		return sum[0];
	} 
	
	private void auxSum2(TreeNode root, int[] sum, int left){
		if (root == null)
			return;
		if (root.left==null && root.right == null && left == 1) {
			sum[0] = sum[0] + root.data;
		}
		auxSum2(root.left, sum,1);
		auxSum2(root.right, sum,0);
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 25;
		TreeNode root = BinaryTree.createTree(n);
		tree.display1(root);
		System.out.println();
		SumLeftLeaves sumLeft = new SumLeftLeaves();
		System.out.println("Sum = " + sumLeft.sumLeftLeaves1(root));
		System.out.println("Sum = " + sumLeft.sumLeftLeaves2(root));
	}
}
