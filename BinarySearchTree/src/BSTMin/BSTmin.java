package BSTMin;

import Node.BSTUtils;
import Node.TreeNode;

public class BSTmin {

	// TC = O(Log(n))  SC = O(1)
	public int min(TreeNode root) {
		if(root==null) return -1;
		TreeNode temp = root;
		while(temp.left!=null)
			temp = temp.left;
		return temp.data;
	}
	
	public static void main(String[] args) {
		BSTUtils bst = new BSTUtils();
		TreeNode root = bst.createBST(16);
		bst.display(root);
		
		BSTmin bstMIN = new BSTmin();
		System.out.println("MIN = " + bstMIN.min(root));
		
	}
}
