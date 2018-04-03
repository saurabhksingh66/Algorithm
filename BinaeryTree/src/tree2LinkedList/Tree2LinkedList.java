/*
  Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:

   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

 */

package tree2LinkedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Node.BinaryTree;
import Node.TreeNode;

public class Tree2LinkedList {
	public void tree2LinkedList1(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		Queue<TreeNode> queue = new LinkedList();

		stack.push(root);
		TreeNode temp = root;
		while (!stack.isEmpty()) {
			temp = stack.pop();
			queue.add(temp);
			if (temp.right != null)
				stack.push(temp.right);
			if (temp.left != null)
				stack.push(temp.left);
		}
		TreeNode node = queue.remove();
		while (!queue.isEmpty()) {
			temp = queue.remove();
			node.left = null;
			node.right = temp;
			node = node.right;
		}
	}

	public void tree2LinkedList2(TreeNode root) {
		if (root == null)
			return;
		auxtree2LinkedList2(root);
	}
	
	public TreeNode auxtree2LinkedList2(TreeNode root){
		if(root==null) return null;
		
		TreeNode left = auxtree2LinkedList2(root.left);
		TreeNode right = auxtree2LinkedList2(root.right);
		
		if(right==null && left!=null){
			root.right = left;
			root.left = null;
		}
		if(left!=null && right!=null){
			root.right = left;
			TreeNode temp = root.right;
			while(temp.right!=null){
				temp = temp.right;
			}
			temp.right = right;
			root.left = null;
		}
		return root;
	}
	
	public void tree2LinkedList3(TreeNode root){
		if (root == null)
			return;
		TreeNode temp = root, current = root, node;
		while (current.left != null || current.right != null) {

			if (current.left != null && current.right != null) {
				System.out.println("I am here");
				temp = current.right;
				current.right = current.left;
				node = current.right;
				while (node.right != null)
					node = node.right;
				node.right = temp;
				current.left = null;
			}

			else if (current.right == null && current.left != null) {
				current.right = current.left;
				current.left = null;
			}

			current = current.right;

		}
	}
	
	public void tree2LinkedList4(TreeNode root){
		if(root==null) return;
		
		tree2LinkedList4(root.left);
		TreeNode temp = root.left;
		while(temp!=null && temp.right!=null)
			temp = temp.right;
		
		tree2LinkedList4(root.right);
		if(temp!=null){
			temp.right = root.right;
			root.right = root.left;
			root.left = null;
		}
		
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 4;
		TreeNode root = tree.createTree(n);
		tree.display1(root);
		System.out.println();

		Tree2LinkedList t2l = new Tree2LinkedList();
		//t2l.tree2LinkedList1(root);
		//	tree.display1(root);
		System.out.println();
		System.out.println();
		System.out.println();
		t2l.tree2LinkedList4(root);
		tree.display1(root);
	}
}
