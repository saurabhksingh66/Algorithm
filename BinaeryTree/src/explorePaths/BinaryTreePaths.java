package explorePaths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Node.BinaryTree;
import Node.TreeNode;

public class BinaryTreePaths {
	LinkedList<Integer> list = new LinkedList<Integer>();

	public void root2Leaf(TreeNode root) {
		if (root == null)
			return;

		list.add(root.data);

		if (root.left == null && root.right == null) {
			System.out.println(Arrays.toString(list.toArray()));
		}

		root2Leaf(root.left);

		root2Leaf(root.right);

		list.removeLast();
	}

	public List<String> root2LeafPaths(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		List<String> list2 = new LinkedList<String>();
		auxRoot2LeafPaths(root, list,list2);
		return list2;
	}

	private void auxRoot2LeafPaths(TreeNode root, ArrayList<Integer> list,List<String> list2) {
		if (root == null)
			return;
		list.add(root.data);
		if (root.left == null && root.right == null) {
			String temp = list.get(0).toString();
			for(int i=1;i<list.size();++i){
				temp = temp + "->" + list.get(i);
			}
			list2.add(temp);
		}
		auxRoot2LeafPaths(root.left, list,list2);
		auxRoot2LeafPaths(root.right, list,list2);
		list.remove(list.size()-1);
	}

	public static void main(String[] args) {
		BinaryTreePaths paths = new BinaryTreePaths();
		BinaryTree tree = new BinaryTree();
		int n = 10;
		TreeNode root = BinaryTree.createTree(n);
		tree.display1(root);
		System.out.println();
		paths.root2Leaf(root);
		System.out.println();
		System.out.println(Arrays.toString(paths.root2LeafPaths(root).toArray()));

	}

}
