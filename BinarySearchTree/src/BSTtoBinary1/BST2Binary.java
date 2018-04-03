/**
 * 
Convert a BST to a Binary Tree such that sum of all greater keys is added to every key

Given a Binary Search Tree (BST), convert it to a Binary Tree such that every key of
 the original BST is changed to key plus sum of all greater keys in BST.

Examples:

Input: Root of following BST
              5
            /   \
           2     13

Output: The given BST is converted to following Binary Tree
              18
            /   \
          20     13

 */

package BSTtoBinary1;

import Node.TreeNode;

public class BST2Binary {

	public TreeNode bst2Binary(TreeNode root){
		if(root==null) return null;
		int[] sum = {0};
		auxBst2Binary(root,sum);
		return root;
	}
	
	private void auxBst2Binary(TreeNode root,int[] sum){
		if(root==null) return;	
		auxBst2Binary(root.right,sum);
		sum[0] = sum[0] + root.data;
		root.data = sum[0];
		auxBst2Binary(root.left,sum);	
	}
}
