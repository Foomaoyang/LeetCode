package adt;

public interface Map<K, V> {

	// ӳ��Ľӿ� ֧����������
	void add(K key, V value);
	V remove(K key);
	boolean contains(K key);
	void set(K key, V newValue);
	V get(K key);
	int getSize();
	boolean isEmpty();
	
}
