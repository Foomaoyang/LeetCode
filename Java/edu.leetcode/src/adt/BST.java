package adt;

import java.util.Stack;

public class BST<E extends Comparable<E>> {
	// EҪ���пɱȽ��ԵĽӿ�

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
	
	// ----------------------��ӽ�� �ݹ�--------------------------------------
	// ������������в����µ�Ԫ��e
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
	
	// ����nodeΪ���Ķ����������в���Ԫ��e�� �ݹ��㷨
	// ӷ��д��
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
	
	// -------------------------��ӽ�� �ݹ� �����ڱ����----------------------------------
	
	// �����ڱ�Ҷ�ӽ�����Ϊ�յ�����Ѿ��ڵݹ��㷨��ʵ��
	public void add(E e) {
		root = add(root, e);
	}
	
	// �����ڱ�Ҷ�ӽ��
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
	
	// ---------------------�����㷨----------------------------------------
	
	// ���Ҷ����������е�Ԫ��
	public boolean contains(E e) {
		return contains(root, e);
	}
	
	// ������nodeΪ���Ķ������������Ƿ����Ԫ��e���ݹ��㷨
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
	
	
	// --------------------ǰ�����----------------------------------------------
	
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
	
	// ---------------------�ǵݹ�ǰ�����-----------------------------------------------
	
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
	
	// ������nodeΪ���ڵ㣬���Ϊdepth���������������ַ���
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
