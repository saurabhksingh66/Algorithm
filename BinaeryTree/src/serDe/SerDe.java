package serDe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Node.BinaryTree;
import Node.TreeNode;

public class SerDe {

	public List<Integer> serialize1(TreeNode root) {
		List<Integer> pre = new ArrayList<Integer>();
		auxSerialize(root, pre);
		return pre;
	}

	private void auxSerialize(TreeNode root, List<Integer> pre) {
		if (root == null) {
			pre.add(-1);
			return;
		}
		pre.add(root.data);
		auxSerialize(root.left, pre);
		auxSerialize(root.right, pre);
	}

	public TreeNode deserialize1(List<Integer> pre) {
		int[] index = new int[1];
		index[0] = 0;
		return auxDeserialize1(pre, index);
	}

	private TreeNode auxDeserialize1(List<Integer> pre, int[] index) {
		
		if(index[0] >= pre.size() || pre.get(index[0])==-1){
			++index[0];
			return null;
		}
		
		TreeNode root = new TreeNode(pre.get(index[0]));
		++index[0];
		
		root.left = auxDeserialize1(pre, index);
		root.right = auxDeserialize1(pre, index);

		return root;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		SerDe SERDE = new SerDe();
		int n = 0;
		TreeNode root = BinaryTree.createTree(n);
		System.out.println();
		tree.display1(root);
		System.out.println();
		System.out.println(Arrays.toString(SERDE.serialize1(root).toArray()));
		tree.display1(SERDE.deserialize1(SERDE.serialize1(root)));
	}
}
