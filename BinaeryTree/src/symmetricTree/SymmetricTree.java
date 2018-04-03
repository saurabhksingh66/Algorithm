/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric: 
*/

package symmetricTree;

import Node.BinaryTree;
import Node.TreeNode;

public class SymmetricTree {
	
	public boolean isSymmetric(TreeNode root){
		if(root==null) return false;
		return auxIsSymmetric(root,root);
	}
	
	private boolean auxIsSymmetric(TreeNode root1, TreeNode root2){
		if(root1==null && root2==null) return true;
		if(root1==null || root2 == null) return false;
		
		if(root1.data==root2.data){
			if(auxIsSymmetric(root1.left,root2.right)&& auxIsSymmetric(root1.right,root2.left))
				return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right= new TreeNode(4);
		root.right.left =  new TreeNode(4);
		root.right.right =  new TreeNode(3);
		
		BinaryTree tree = new BinaryTree();
		tree.display1(root);
		SymmetricTree sym = new SymmetricTree();
		System.out.println(sym.isSymmetric(root));
	}
}
