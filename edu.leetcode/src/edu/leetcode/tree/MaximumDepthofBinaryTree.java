package edu.leetcode.tree;

public class MaximumDepthofBinaryTree {
	/**
	 * Ê÷µÄ¸ß¶È - 104.Maximum Depth of Binary Tree(easy)
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if(root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

}
