package adt;

import java.util.TreeMap;

public class Trie {
	
	// Leetcode 208
	
	private class Node {
		public boolean isWord;
		public TreeMap<Character, Node> next;
		
		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap();
		}
		
		public Node() {
			this(false);
		}
	}
	
	private Node root;
	private int size;
	
	public Trie() {
		root = new Node();
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	// ��Trie������µĵ���word
	public void add(String word) {
		
		Node cur = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(cur.next.get(c) == null)
				cur.next.put(c, new Node());
			cur = cur.next.get(c);
		}
		if(!cur.isWord) {
			cur.isWord = true;
			size ++;
		}
	}
	
	// ��ѯ����word�Ƿ���Trie��
	public boolean Contains(String word) {
		Node cur = root;
		for(int i = 0; i < word.length(); i ++) {
			char c = word.charAt(i);
			if(cur.next.get(c) ==  null)
				return false;
			cur = cur.next.get(c);
		}
		// ע�ⷵ��ֵ ����pan panad���ҵ�pan��������Ϊ���ҵ�������ʣ���Ҫ���ǲ���panad �е��ַ�
		return cur.isWord;
	}
	
	// ��Trie�в����Ƿ��е�����prefixΪǰ׺
	public boolean isPrefix(String prefix) {
		Node cur = root;
		for(int i = 0; i < prefix.length(); i ++) {
			char c = prefix.charAt(i);
			if(cur.next.get(c) == null)
				return false;
		}
		return true;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
