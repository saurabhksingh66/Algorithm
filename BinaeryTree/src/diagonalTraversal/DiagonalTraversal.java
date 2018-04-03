package diagonalTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Node.BinaryTree;
import Node.TreeNode;

public class DiagonalTraversal {

	public void diagonalTraversal(TreeNode root) {
		if (root == null)
			return;
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		auxDiagonalTraversal(root, 0, map);
		System.out.println(map.values());
	}

	private void auxDiagonalTraversal(TreeNode root, int distance,
			Map<Integer, ArrayList<Integer>> map) {
		
		if (root == null)
			return;
		
		ArrayList<Integer> list = map.get(distance);
		
		if (list == null) {
			list = new ArrayList<Integer>();
			list.add(root.data);
		} else
			list.add(root.data);
		
		map.put(distance, list);
		
		auxDiagonalTraversal(root.left, distance+1, map);
		auxDiagonalTraversal(root.right, distance, map);
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int n = 6;
		TreeNode root = BinaryTree.createTree(n);
		tree.display1(root);
		System.out.println();
		DiagonalTraversal diagonal =  new DiagonalTraversal();
		diagonal.diagonalTraversal(root);
	}
}
