package checkEquality;

import Node.BinaryTree;
import Node.TreeNode;

public class CheckEquality {
	
	public boolean isEqual(TreeNode root1, TreeNode root2){
		if(root1==null && root2==null) return true;
		if(root1==null || root2 == null) return false;
		
		if(root1.data==root2.data){
			if(isEqual(root1.left,root2.left) && isEqual(root1.right,root2.right))
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
		
		CheckEquality checkEquality = new CheckEquality();
		System.out.println(checkEquality.isEqual(root, root.left));;
		
	}
}
