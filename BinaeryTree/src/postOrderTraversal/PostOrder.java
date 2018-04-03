//Iterative Postorder Traversal 

package postOrderTraversal;

import java.util.Stack;
import Node.BinaryTree;
import Node.TreeNode;

public class PostOrder {
	
	//using recursion
	//
	public void postOrder1(TreeNode root){
		if(root == null) return;
		postOrder1(root.left);
		postOrder1(root.right);
		System.out.print(root.data + " ");
	}
	
	//without recursion (2 stacks)
	//
	public void postOrder2(TreeNode root){
		if(root == null) return;
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		stack1.push(root);
		TreeNode temp = root;
		while(!stack1.isEmpty()){
			temp = stack1.pop();
			stack2.push(temp);
			if(temp.left!=null)
				stack1.push(temp.left);
			if(temp.right!=null)
				stack1.push(temp.right);
		}
		while(!stack2.isEmpty())
			System.out.print(stack2.pop().data + " ");
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 5;
		TreeNode root = BinaryTree.createTree(n);
		tree.display1(root);
		System.out.println();
		PostOrder post = new PostOrder();
		post.postOrder1(root);
		System.out.println();
		post.postOrder2(root);
	}
}
