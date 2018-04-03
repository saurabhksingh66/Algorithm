//Iterative Preorder Traversal

package preOrderTraversal;

import java.util.Stack;

import Node.BinaryTree;
import Node.TreeNode;

public class PreOrder {
	
	// Using recursion
	// TC = O(n) SC = O(n)
	public void preOrder1(TreeNode root){
		if(root == null) return;
		System.out.print(root.data + " ");
		preOrder1(root.left);
		preOrder1(root.right);
	}
	
	// Without recursion
	//
	public void preOrder2(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode temp = root;
		while(!stack.isEmpty()){
			temp = stack.pop();
			System.out.print(temp.data + " ");
			if(temp.right!=null)
				stack.push(temp.right);
			if(temp.left!=null)
				stack.push(temp.left);
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 5;
		TreeNode root = BinaryTree.createTree(n);
		tree.display1(root);
		System.out.println();
		PreOrder pre = new PreOrder();
		pre.preOrder1(root);
		System.out.println();
		pre.preOrder2(root);
	}
}
