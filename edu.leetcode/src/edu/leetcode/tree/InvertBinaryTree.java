package edu.leetcode.tree;

public class InvertBinaryTree {

	/**
	 * 226. Invert Binary Tree (Easy)
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		if(root == null) return null;
		TreeNode left = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(left);
		return root;		
	}
	
}
