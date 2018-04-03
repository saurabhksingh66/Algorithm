/*
You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis 
pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

Example 1:

Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /    
  4     

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())", 
but you need to omit all the unnecessary empty parenthesis pairs. 
And it will be "1(2(4))(3)".
 * 
 */

package tree2String;

import java.util.LinkedList;
import java.util.Queue;

import Node.BinaryTree;
import Node.TreeNode;

public class Tree2String {

	public String tree2String1(TreeNode root) {
		if (root == null)
			return "";
		String[] result = { "" };
		auxTree2String(root, result);
		return result[0];
	}

	private TreeNode auxTree2String(TreeNode root, String[] result) {
		if (root == null)
			return null;

		result[0] = result[0] + root.data;
		if (root.left != null || root.right != null)
			result[0] = result[0] + "(";
		TreeNode left = auxTree2String(root.left, result);
		if (left != null || root.right != null)
			result[0] = result[0] + ")";
		if (root.right != null)
			result[0] = result[0] + "(";
		TreeNode right = auxTree2String(root.right, result);
		if (right != null)
			result[0] = result[0] + ")";
		return root;
	}
	
	public String tree2String2(TreeNode root) {
		if (root == null)
			return "";
		String result = "" + root.data;
		String left = tree2String1(root.left);
		String right = tree2String1(root.right);
		
		if(left =="" && right == "")
			return result;
		else if(left=="")
			return result + "()" + "(" + right + ")" ;
		else if(right=="")
			return result + "(" + left + ")";
		else 
			return result + "(" + left + ")" + "(" + right + ")";
			
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 15;
		TreeNode root = BinaryTree.createTree(n);
		tree.display1(root);
		System.out.println();

		Tree2String t2s = new Tree2String();
		System.out.println(t2s.tree2String1(root));
		System.out.println(t2s.tree2String2(root));
	}
}
