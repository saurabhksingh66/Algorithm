package countNodes;

import Node.BinaryTree;
import Node.TreeNode;

public class CountNodes {
	public int countNodes(TreeNode root){
		if(root==null) return 0;
		return countNodes(root.left) + countNodes(root.right) + 1;
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 100;
		TreeNode root = BinaryTree.createTree(n);
		tree.display1(root);
		System.out.println();
		CountNodes count = new CountNodes();
		System.out.println(count.countNodes(root));
	}
}
