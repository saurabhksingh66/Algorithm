/*
 *  Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 *   adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */

package pathSum;

import java.util.Arrays;
import java.util.LinkedList;

import Node.BinaryTree;
import Node.TreeNode;

public class HasPathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		int[] total = { Integer.MAX_VALUE };
		LinkedList<Integer> list = new LinkedList<Integer>();
		auxHasPathSum(root, sum, total, list);
		return (total[0] == sum ? true : false);
	}

	private void auxHasPathSum(TreeNode root, int sum, int[] total,
			LinkedList<Integer> list) {
		if (root == null)
			return;

		list.add(root.data);
		int sum1 = 0;
		if (root.left == null && root.right == null) {
			System.out.println(Arrays.toString(list.toArray()));
			for (int i = 0; i < list.size(); ++i)
				sum1 = sum1 + list.get(i);
			System.out.println("sum1 = " + sum1);
			if (sum1 == sum)
				total[0] = sum;
		}

		auxHasPathSum(root.left, sum, total, list);
		auxHasPathSum(root.right, sum, total, list);

		list.removeLast();
	}

	public boolean hasPathSum2(TreeNode root, int sum) {
		if (root == null)
			return false;
		// int[] total = {0};
		return auxhasPathSum2(root, sum, 0);
	}

	private boolean auxhasPathSum2(TreeNode root, int sum, int value) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null && value + root.data == sum)
			return true;
		return auxhasPathSum2(root.left, sum, value + root.data)
				|| auxhasPathSum2(root.right, sum, value + root.data);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		 root.left = new TreeNode(2); root.right = new TreeNode(3);
		 root.left.left = new TreeNode(4); root.left.right = new TreeNode(5);
		 root.right.left = new TreeNode(8); root.right.right = new
		 TreeNode(7);
		 

		BinaryTree tree = new BinaryTree();
		tree.display1(root);

		HasPathSum hasSum = new HasPathSum();
		System.out.println(hasSum.hasPathSum(root, 11));
		System.out.println(hasSum.hasPathSum2(root, 11));
		;
	}
}
