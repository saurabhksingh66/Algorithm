/*
  Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

 */

package populatingNextRightPointer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeLinkNode {
	int data;
	TreeLinkNode left, right, next;

	public TreeLinkNode(int data) {
		this.data = data;
	}

}

public class PopulatingNextRight {

	public void linkConnect1(TreeLinkNode root) {
		if (root == null)
			return;
		int height = height(root);
		List<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
		for (int i = 1; i <= height; ++i) {
			auxLinkConnect(root, i, list);
			int j;
			System.out.println();
			for (j = 0; j < list.size() - 1; ++j) {
				list.get(j).next = list.get(j + 1);
			}
			list.clear();
		}
	}

	private void auxLinkConnect(TreeLinkNode root, int height,
			List<TreeLinkNode> list) {
		if (root == null)
			return;
		if (height == 1)
			list.add(root);
		auxLinkConnect(root.left, height - 1, list);
		auxLinkConnect(root.right, height - 1, list);

	}

	private int height(TreeLinkNode root) {
		if (root == null)
			return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}

	public void display1(TreeLinkNode root) {
		auxDisplay1(root, 0, "root");
	}

	private static void auxDisplay1(TreeLinkNode root, int nspaces, String type) {
		if (root == null)
			return;
		for (int i = 0; i < nspaces; ++i)
			System.out.print(' ');
		if (root.next == null)
			System.out.println(root.data + "(" + type + ")" + "--->>" + null);
		else
			System.out.println(root.data + "(" + type + ")" + "--->>"
					+ root.next.data);
		auxDisplay1(root.left, nspaces + 4, "L");
		auxDisplay1(root.right, nspaces + 4, "R");
	}
	
	public void linkConnect2(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		queue.add(root);
		TreeLinkNode temp;
		ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
		int count = 0;
		while(!queue.isEmpty()){
			count = queue.size();
		while(count!=0){
			temp = queue.remove();
			list.add(temp);
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
			--count;
		}
		int j = 0;
		for(j=0;j<list.size()-1;++j)
			list.get(j).next = list.get(j+1);
		list.clear();
		}
		
	}
	
	public void linkConnect3(TreeLinkNode root){
		TreeLinkNode parent = root;
		TreeLinkNode current;
		TreeLinkNode dummy = new TreeLinkNode(0);
		
		while(parent!=null){
			
			current = dummy;
			while(parent!=null){
				if(parent.left!=null){
					current.next = parent.left;
					current = current.next;
				}
				if(parent.right!=null){
					current.next = parent.right;
					current = current.next;
				}
				parent = parent.next;
			}
			parent = dummy.next;
			dummy.next = null;
		}
	}

	public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(5);
		root.left = new TreeLinkNode(4);
		root.right = new TreeLinkNode(8);
		root.left.left = new TreeLinkNode(6);
		root.left.right = new TreeLinkNode(11);
		root.right.left = new TreeLinkNode(3);

		PopulatingNextRight pnr = new PopulatingNextRight();
		pnr.display1(root);
		System.out.println();
		pnr.linkConnect3(root);
		System.out.println();
		System.out.println();
		pnr.display1(root);
	}
}
