package treeSize;

import java.util.LinkedList;
import java.util.Queue;

import Node.BinaryTree;
import Node.TreeNode;

public class TreeSize {

	// TC -> O(n) SC -> O(n)
	public int treeSize1(TreeNode root) {
		if (root == null)
			return 0;
		return treeSize1(root.left) + treeSize1(root.right) + 1;
	}
	
	// TC -> O(n) SC -> O(n)
	public int treeSize2(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int size = 0;
		queue.add(root);
		TreeNode current ;
		while(!queue.isEmpty()){
			current = queue.remove();
			++size;
			if(current.left!=null)
				queue.add(current.left);
			if(current.right!=null)
				queue.add(current.right);
		}
		return size;
	}
	
	/* public int treeSize(TreeNode root){
		
	} */

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		TreeSize ts = new TreeSize();
		int n = 144;
		TreeNode root = BinaryTree.createTree(n);
		System.out.println();
		tree.display1(root);
		System.out.println();
		System.out.println("Size1 = " + ts.treeSize1(root));
		System.out.println("Size2 = " + ts.treeSize2(root));
	}
}
