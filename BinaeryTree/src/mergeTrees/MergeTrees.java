/*
 *  Given two binary trees and imagine that when you put one of them to cover the 
 *  other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes
 overlap, then sum node values up as the new value of the merged node. Otherwise, 
 the NOT null node will be used as the node of new tree.

Example 1:

Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7

Note: The merging process must start from the root nodes of both trees. 
 */

package mergeTrees;

import Node.BinaryTree;
import Node.TreeNode;

public class MergeTrees {

	public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
		if (root1 == null)
			return root2;
		if (root2 == null)
			return root1;
		root1.data += root2.data;
		root1.left = mergeTrees1(root1.left, root2.left);
		root1.right = mergeTrees1(root1.right, root2.right);
		return root1;
	}

	public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
		if(root1 == null)
			return root2;
		else if(root2==null)
			return root1;
		
			int data = root1.data+root2.data;
			TreeNode root = new TreeNode(data);
			root.left = mergeTrees2(root1.left,root2.left);
			root.right = mergeTrees2(root1.right,root2.right);
			return root;
		
		
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		TreeNode root1 = tree.createTree(3);
		TreeNode root2 = tree.createTree(3);
		tree.display1(root1);
		System.out.println();
		System.out.println();
		tree.display1(root2);
		System.out.println();
		System.out.println();
		MergeTrees merge = new MergeTrees();
		tree.display1(merge.mergeTrees2(root1, root2));
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		tree.display1(merge.mergeTrees1(root1, root2));
	}
}
