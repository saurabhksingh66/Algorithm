/*
 Print a Binary Tree in Vertical Order
 
          1
        /    \
       2      3
      / \    / \
     4   5  6   7
             \   \
              8   9 
               
			  
The output of print this tree vertically will be:
4
2
1 5 6
3 8
7
9 
 */

package printVerticalOrder;

import Node.BinaryTree;
import Node.TreeNode;

public class PrintVerticalOrder {

	public void printVerticalOrder(TreeNode root) {
		if (root == null)
			return;
		int[] min = new int[1];
		int[] max = new int[1];
		min[0] = Integer.MAX_VALUE;
		max[0] = Integer.MIN_VALUE;
		findMinMax(root, min, max, 0);
		for(int i = min[0]; i<=max[0]; ++i){
			printVerticalLine(root,i,0);
			System.out.println();
		}
	}

	private void findMinMax(TreeNode root, int[] min, int[] max, int distance) {

		if (root == null)
			return;
		min[0] = Math.min(min[0], distance);
		max[0] = Math.max(max[0], distance);

		findMinMax(root.left, min, max, distance - 1);
		findMinMax(root.right, min, max, distance + 1);
	}
	
	private void printVerticalLine(TreeNode root, int LineNumber, int distance){
		if(root==null) return;
		if(LineNumber==distance) System.out.print(root.data + " ");
		
		printVerticalLine(root.left,LineNumber,distance-1);
		printVerticalLine(root.right, LineNumber, distance+1);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right= new TreeNode(5);
		root.right.left =  new TreeNode(6);
		root.right.right =  new TreeNode(7);
		
		BinaryTree tree = new BinaryTree();
		tree.display1(root);
		
		PrintVerticalOrder vertical = new PrintVerticalOrder();
		vertical.printVerticalOrder(root);
	}
}
