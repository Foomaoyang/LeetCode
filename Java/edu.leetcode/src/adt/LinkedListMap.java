package adt;

public class LinkedListMap<K, V> implements Map<K, V> {

	// 对于字典/映射Map来说只能有一个key
	
	private class Node{
		public K key;
		public V value;
		public Node next;
		
		public Node(K key, V value, Node next) {
			this.key = key; this.value = value; this.next = next;
		}
		
		public Node(K key) {
			this(key, null, null);
		}
		
		public Node() {
			this(null, null, null);
		}
		
		@Override
		public String toString() {
			return key.toString() + " : " + value.toString();
		}
	}
	
	private Node dummyHead; // 哨兵结点
	private int size;
	
	public LinkedListMap() {
		dummyHead = new Node();
		size = 0;
	}
	
	private Node getNode(K key) {
		Node cur = dummyHead.next;
		while(cur != null) {
			if(cur.key.equals(key))
				return cur;
			cur = cur.next;
		}
		return null;
	}
	
	@Override
	public void add(K key, V value) {
		// TODO Auto-generated method stub
		Node node = getNode(key);
		if(node == null) {
			dummyHead.next = new Node(key, value, dummyHead.next);
			size ++;
		}
		else
			node.value = value;
	}

	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		Node prev = dummyHead;
		while(prev.next != null) {
			if(prev.next.key.equals(key))
				break;
			prev = prev.next;
		}
		
		if(prev.next != null) {
			Node delNode = prev.next;
			prev.next = delNode.next;
			delNode.next = null;
			size --;
			return delNode.value;
		}
		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO Auto-generated method stub
		return getNode(key) != null;
	}

	@Override
	public void set(K key, V newValue) {
		// TODO Auto-generated method stub
		Node node = getNode(key);
		if(node == null)
			throw new IllegalArgumentException(key + " doesn't exist !");
		
		node.value = newValue;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		Node node = getNode(key);
		return node == null ? null : node.value;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

}
