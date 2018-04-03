package Node;

import java.util.Random;

public class BSTUtils {

	private TreeNode add(TreeNode root, int data) {
		if (root == null)
			return new TreeNode(data);

		TreeNode current = root;
		while (true) {
			if (data < current.data) {
				if (current.left == null) {
					current.left = new TreeNode(data);
					break;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					current.right = new TreeNode(data);
					break;
				}
				current = current.right;
			}
		}
		return root;
	}

	public TreeNode createBST(int n) {
		TreeNode root = null;
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			root = add(root, r.nextInt(n) + 1);
		}
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

	public void display(TreeNode root) {
		auxDisplay(root, 0, "root");
	}

	private void auxDisplay(TreeNode root, int nSpace, String type) {
		if (root == null)
			return;

		for (int i = 0; i < nSpace; ++i) {
			System.out.print(" ");
		}
		System.out.println(root.data + "(" + type + ")");
		auxDisplay(root.left, nSpace + 4, "L");
		auxDisplay(root.right, nSpace + 4, "R");
	}

	public static void main(String[] args) {
		BSTUtils bst = new BSTUtils();
		TreeNode root1 = bst.createBST(16);
		TreeNode root2 = bst.createBBST(16);
		bst.display(root1);
		System.out.println("----------------------------------------");
		bst.display(root2);
	}

}
