/*
Boundary Traversal of binary tree
3.5
Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting 
from the root.
*/

package boundryTraversal;

import Node.BinaryTree;
import Node.TreeNode;

public class BoundryTraversal {
	
	public void boundryTraversal(TreeNode root){
		if(root==null) return;
		System.out.print(root.data + " ");
		left(root.left);
		System.out.println();
		leaves(root);
		System.out.println();
		right(root.right);
	}
	
	private void left(TreeNode root){
		if(root == null)
			return;
		
		if(root.left==null && root.right==null) return;
		
		else if(root.right==null){
			System.out.print(root.data + " ");
			left(root.left);
		}
		else{
			System.out.print(root.data + " ");
			left(root.right);
		}
	}
	
	private void right(TreeNode root){
		if(root == null)
			return;
		
		if(root.left==null && root.right==null) return;
		
		else if(root.right==null){
			right(root.left);
			System.out.print(root.data + " ");
		}
		else{
			right(root.right);
			System.out.print(root.data + " ");
		}
	}
	
	private void leaves(TreeNode root){
		if(root==null)
			return;
		if(root.left == null && root.right == null)
			System.out.print(root.data + " ");
		leaves(root.left);
		leaves(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 6;
		TreeNode root = BinaryTree.createTree(n);
		tree.display1(root);
		System.out.println();
		
		BoundryTraversal boundry = new BoundryTraversal();
		boundry.boundryTraversal(root);
	}
}
