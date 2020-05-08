package edu.leetcode.tree;

public class LongestUnivaluePath {

	private int path = 0;
	
	/**
	 * 相同节点值的最大路径长度
	 * 687. Longest Univalue Path (Easy)
	 * @param root
	 * @return
	 */
	public int longestUnivaluePath(TreeNode root) {
		dfs(root);
		return path;
	}

	private int dfs(TreeNode root) {
		// TODO Auto-generated method stub
		if(root == null) return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		int leftPath = root.left != null && 
				root.left.val == root.val ? left + 1 : 0;
		int rightPath = root.right != null && 
				root.right.val == root.val ? right + 1 : 0;
		path = Math.max(path, leftPath + rightPath);
		return Math.max(leftPath, rightPath);
	}
}
