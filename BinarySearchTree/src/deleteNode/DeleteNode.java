package deleteNode;

import Node.BSTUtils;
import Node.TreeNode;

public class DeleteNode {
	
	public TreeNode deleteNode(TreeNode root, int key){
		if(root==null) return null;
		
		if(key<root.data)
			root.left = deleteNode(root.left,key);
		else if(key>root.data)
			root.right = deleteNode(root.right, key);
		else{
			if(root.left==null && root.right == null)
				return null;
			else if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			else{
				root.data = findMin(root.right);
				root.right = deleteNode(root.right,root.data);
			}
		}
		return root;
	}
	private int findMin(TreeNode root){
		if(root==null) return 0;
		while(root.left!=null)
			root = root.left;
		return root.data;
	}
	
	public static void main(String[] args) {
		BSTUtils tree = new BSTUtils();
		TreeNode root = tree.createBBST(10);
		tree.display(root);
		System.out.println();
		DeleteNode del = new DeleteNode();
		tree.display(del.deleteNode(root, 99));
	}
}
