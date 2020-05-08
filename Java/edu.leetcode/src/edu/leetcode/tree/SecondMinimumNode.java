package edu.leetcode.tree;

public class SecondMinimumNode {

	/**
	 * 671. Second Minimum Node In a Binary Tree (Easy)
	 * @param root
	 * @return
	 */
	public int findSecondMinimumValue(TreeNode root) {
		if(root == null) return -1;
		if(root.left == null && root.right == null) return -1;
		int leftVal = root.left.val;
		int rightVal = root.right.val;
		if(leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
		if(rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
		if(leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
		return rightVal;
	}
}
