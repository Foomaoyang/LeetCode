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
	
	// 向Trie中添加新的单词word
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
	
	// 查询单词word是否在Trie中
	public boolean Contains(String word) {
		Node cur = root;
		for(int i = 0; i < word.length(); i ++) {
			char c = word.charAt(i);
			if(cur.next.get(c) ==  null)
				return false;
			cur = cur.next.get(c);
		}
		// 注意返回值 例如pan panad，找到pan并不能认为就找到了这个词，号要看是不是panad 中的字符
		return cur.isWord;
	}
	
	// 在Trie中查找是否有单词以prefix为前缀
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
