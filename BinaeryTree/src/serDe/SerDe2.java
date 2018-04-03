package serDe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Node.BinaryTree;
import Node.TreeNode;

public class SerDe2 {

	private List<Integer> preOrder(TreeNode root, List<Integer> list) {
		if (root == null)
			return null;
		list.add(root.data);
		preOrder(root.left, list);
		preOrder(root.right, list);
		return list;
	}

	private List<Integer> inOrder(TreeNode root, List<Integer> list) {
		if (root == null)
			return null;
		preOrder(root.left, list);
		list.add(root.data);
		preOrder(root.right, list);
		return list;
	}

	private List<Integer> levelOrder(TreeNode root, List<Integer> list) {
		if (root == null)
			return null;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode current;

		while (!queue.isEmpty()) {
			current = queue.remove();
			list.add(current.data);
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}
		return list;
	}

	public int[] serializationPre(TreeNode root) {
		if (root == null)
			return new int[0];
		List<Integer> list = new ArrayList<Integer>();
		list = preOrder(root, list);
		int[] pre = new int[list.size()];
		for (int i = 0; i < list.size(); ++i)
			pre[i] = list.get(i);
		list.clear();
		list = inOrder(root, list);
		int[] in = new int[list.size()];
		for (int i = 0; i < list.size(); ++i)
			in[i] = list.get(i);
		return pre;
	}

	public int[] serializationIn(TreeNode root) {
		if (root == null)
			return new int[0];
		List<Integer> list = new ArrayList<Integer>();
		list = inOrder(root, list);
		int[] in = new int[list.size()];
		for (int i = 0; i < list.size(); ++i)
			in[i] = list.get(i);
		return in;
	}

	public int[] serializationLevel(TreeNode root) {
		if (root == null)
			return new int[0];
		List<Integer> list = new ArrayList<Integer>();
		list = levelOrder(root, list);
		int[] level = new int[list.size()];
		for (int i = 0; i < list.size(); ++i)
			level[i] = list.get(i);
		return level;
	}

	public TreeNode deserialization1(int[] pre, int[] in) {

		return auxDeserialization1(pre, in, 0, pre.length-1, 0);
	}

	private TreeNode auxDeserialization1(int[] pre, int[] in, int inStart, int inEnd, int preStart) {
		if (inStart > inEnd)
			return null;
		TreeNode tmp = new TreeNode(pre[preStart]);
		if (inStart == inEnd)
			return tmp;
		int i;
		for (i = inStart; i <= inEnd; ++i) {
			if (in[i] == pre[preStart])
				break;
		}
		tmp.left = auxDeserialization1(pre, in, inStart, i-1, preStart+1);
		tmp.right = auxDeserialization1(pre, in, i+1, inEnd, i-inStart+1);
		return tmp;
	}
	
	public TreeNode deserialization2(int[] pre, int[] in) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i =0; i<in.length; ++i){
			map.put(in[i], i);
		}
		return auxDeserialization2(pre, in, 0, pre.length-1, 0,map);
	}
	
	private TreeNode auxDeserialization2(int[] pre, int[] in, int inStart, int inEnd, int preStart, HashMap<Integer,Integer> map){
		if(inStart>inEnd) return null;
		TreeNode tmp = new TreeNode(pre[preStart]);
		if (inStart == inEnd)
			return tmp;
		int i = map.get(pre[preStart]);
		tmp.left = auxDeserialization1(pre, in, inStart, i-1, preStart+1);
		tmp.right = auxDeserialization1(pre, in, i+1, inEnd, preStart+i+1);
		return tmp;
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		SerDe2 serde = new SerDe2();
		int n = 5;
		TreeNode root = BinaryTree.createTree(n);
		// tree.display1(root);
		System.out.println();
		// System.out.println("I am here");
		int[] pre = { 1,2,4,5,3};
		int[] in = { 4,2,5,1,3};
		tree.display1(serde.deserialization2(pre, in));
	}
}
