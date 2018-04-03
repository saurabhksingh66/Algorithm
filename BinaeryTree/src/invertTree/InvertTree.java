/*
 Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */

package invertTree;

import java.util.LinkedList;
import java.util.Queue;

import Node.BinaryTree;
import Node.TreeNode;

public class InvertTree {

	public TreeNode invertTree1(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
		queue1.add(root);
		TreeNode temp = root, temp1;
		
		while (!queue1.isEmpty()) {
			temp = queue1.remove();
			temp1 = temp.left;
			temp.left = temp.right;
			temp.right = temp1;

			if (temp.left != null)
				queue1.add(temp.left);
			if (temp.right != null)
				queue1.add(temp.right);
		}
		return root;
	}
	public TreeNode invertTree2(TreeNode root){
		if(root==null) return null;
		
		TreeNode left = invertTree2(root.left);
		TreeNode right = invertTree2(root.right);
		root.left = right;
		root.right = left;
		return root;
	} 
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 5;
		TreeNode root = BinaryTree.createTree(n);
		tree.display1(root);
		System.out.println();
		
		InvertTree invert = new InvertTree();
		tree.display1(invert.invertTree1(root));
		tree.display1(invert.invertTree1(root));
		tree.display1(invert.invertTree2(root));
	}
}
