package edu.leetcode.tree;

public class SumofLeftLeaves {

	/**
	 * 404. Sum of Left Leaves (Easy)
	 * @param root
	 * @return
	 */
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) return 0;
		if(isLeaf(root.left)) return root.left.val + sumOfLeftLeaves(root.right);
		return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}

	private boolean isLeaf(TreeNode node) {
		// TODO Auto-generated method stub
		if(node == null) return false;
		return node.left == null && node.right == null;
	}
}
