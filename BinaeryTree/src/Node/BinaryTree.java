// Node Class
package Node;

import java.util.Random;

public class BinaryTree {

	private static TreeNode add(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);
		Random r = new Random();
		TreeNode current = root;
		while (true) {
			if (r.nextInt(2) == 0) {
				if (current.left == null) {
					current.left = new TreeNode(data);
					break;
				} else {
					current = current.left;
				}
			} else {
				if (current.right == null) {
					current.right = new TreeNode(data);
					break;
				} else {
					current = current.right;
				}
			}
		}
		return root;
	}

	public static TreeNode createTree(int n) {
		TreeNode root = null;
		Random r = new Random(100);
		for (int i = 0; i < n; ++i)
			root = add(root, r.nextInt(5) + 1);
		return root;
	}
	
	public TreeNode createBBST(int n) {
		return auxCreateBBST(1, n);
	}

	private TreeNode auxCreateBBST(int l, int r) {

		if (l > r)
			return null;
		//if (l == r)
		//	return new TreeNode(l);
		

		int m = (l + r) / 2;
		TreeNode temp = new TreeNode(m);
		temp.left = auxCreateBBST(l, m - 1);
		temp.right = auxCreateBBST(m + 1, r);

		return temp;
	}

	// TC:O(n ^ 2)
	// SC:O(n)
	public void display1(TreeNode root) {
		auxDisplay1(root, 0, "root");
	}

	public static void display2(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + "  ");
		display2(root.left);
		display2(root.right);
	}

	private static void auxDisplay1(TreeNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		System.out.println(root.data + "(" + type + ")");
		auxDisplay1(root.left, nspaces + 4, "L");
		auxDisplay1(root.right, nspaces + 4, "R");
	}


}
