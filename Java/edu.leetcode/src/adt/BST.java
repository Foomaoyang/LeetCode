package adt;

import java.util.Stack;

public class BST<E extends Comparable<E>> {
	// E要具有可比较性的接口

	private class Node{
		public E e;
		public Node left, right;
		
		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}
	
	private Node root;
	private int size;
	
	public BST() {
		root = null;
		size = 0;
	}
	
	// ----------------------添加结点 递归--------------------------------------
	// 向二叉搜索树中插入新的元素e
//	public void add(E e) {
//		if(root == null) {
//			root = new Node(e);
//			size ++;
//		}else {
//			add(root, e);
//		}
//		
//		
//	}
	
	// 向以node为根的二叉搜索树中插入元素e， 递归算法
	// 臃肿写法
//	private void add(Node node, E e) {
//		if(e.equals(node.e))
//			return;
//		else if(e.compareTo(node.e)<0 && node.left == null) {
//			node.left = new Node(e);
//			size++;
//			return;
//		}else if(e.compareTo(node.e) > 0 && node.right == null) {
//			node.right = new Node(e);
//			size++;
//			return;
//		}
//		
//		if(e.compareTo(node.e) < 0)
//			add(node.left, e);
//		else
//			add(node.right, e);
//	}
	
	// -------------------------添加结点 递归 引入哨兵结点----------------------------------
	
	// 引入哨兵叶子结点后结点为空的情况已经在递归算法中实现
	public void add(E e) {
		root = add(root, e);
	}
	
	// 引入哨兵叶子结点
	public Node add(Node node, E e) {
		if(node == null) {
			size ++;
			return new Node(e);
		}
		
		if(e.compareTo(node.e) < 0)
			node.left = add(node.left, e);
		else if(e.compareTo(node.e) > 0)
			node.right = add(node.right, e);
		
		return node;
	}
	
	// ---------------------查找算法----------------------------------------
	
	// 查找二叉搜索树中的元素
	public boolean contains(E e) {
		return contains(root, e);
	}
	
	// 查找以node为根的二叉搜索树中是否包含元素e，递归算法
	public boolean contains(Node node, E e) {
		if(node == null)
			return false;
		
		if(e.compareTo(node.e) == 0)
			return true;
		else if(e.compareTo(node.e) < 0)
			return contains(node.left, e);
		else
			return contains(node.right, e);
	}
	
	
	// --------------------前序遍历----------------------------------------------
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node node) {
		if(node == null)
			return;
		
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	// ---------------------非递归前序遍历-----------------------------------------------
	
	public void preOrderNoRecursion() {
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node cur = stack.pop();
			System.out.println(cur.e);
			
			if(cur.right != null)
				stack.push(cur.right);
			if(cur.left != null)
				stack.push(cur.left);
		}
	}
	
	
	
	
	public void remove(E e) {
		
	}
	
	
	
	
	
	
	
	
	
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	// ----------------------------------------------------
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root, 0, res);
		return res.toString();
	}
	
	// 生成以node为根节点，深度为depth的描述二叉树的字符串
	private void generateBSTString(Node node, int depth, StringBuilder res) {
		if(node == null) {
			res.append(generateDepthString(depth) +"null\n");
			return;
		}
		
		res.append(generateDepthString(depth)+node.e+'\n');
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);
	}
	
	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < depth; i++)
			res.append("--");
		return res.toString();
	}
	
	// ------------------------------------------------------------
	
	public static void main(String[] args) {
		BST<Integer> bst = new BST<>();
		int[] nums = {5, 3, 6, 8, 4, 2};
		for(int num: nums)
			bst.add(num);
		
		//////////////////////
		//        5         //
		//      /   \       //
		//     3     6      //
		//    / \     \     //
		//   2   4     8    //
		//////////////////////
		
		bst.preOrder();
		System.out.println();
		
		System.out.println(bst);
	}
}
