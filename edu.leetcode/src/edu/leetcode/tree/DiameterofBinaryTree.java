package edu.leetcode.tree;

public class DiameterofBinaryTree {

	private int max = 0;
	
	/**
	 * 226. Invert Binary Tree (Easy)
	 * @param root
	 * @return
	 */
	public int diameterOfBinaryTree(TreeNode root) {
		depth(root);
		return max;
	}

	private int depth(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		int leftDepth = depth(root.left);
		int rightDepth = depth(root.right);
		max = Math.max(max, leftDepth + rightDepth);
		return Math.max(leftDepth, rightDepth) + 1;
	}
	
	
}
