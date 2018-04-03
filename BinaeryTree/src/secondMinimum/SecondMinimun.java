/*
  Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node
   in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value 
   is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value
 in the whole tree.

If no such second minimum value exists, output -1 instead. 
 */
package secondMinimum;

import java.util.LinkedList;
import java.util.Queue;

import Node.BinaryTree;
import Node.TreeNode;

public class SecondMinimun {

	public int secondMin(TreeNode root) {
		if(root==null) return -1;
		TreeNode temp = root;
		int min = temp.data;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			temp = queue.remove();
			if(temp.data>min){
				min = temp.data;
				break;
			}
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);	
		}
		if(min==root.data) return -1;
		return min;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(5);

		BinaryTree tree = new BinaryTree();
		tree.display1(root);
		SecondMinimun secondMin = new SecondMinimun();
		System.out.println(secondMin.secondMin(root));
		;
	}
}
