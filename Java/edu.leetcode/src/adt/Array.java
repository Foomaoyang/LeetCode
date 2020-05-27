package adt;

public class Array<E> {
	
	private int size;
	private E[] data;
	
	@SuppressWarnings("unchecked")
	public Array(int capacity) {
		data = (E[])new Object[capacity];
		size = 0;
	}
	
	public Array() {
		this(10);
	}
	
	public Array(E[] arr) {
		data = (E[])new Object[arr.length];
		for(int i = 0; i < arr.length; i++)
			data[i] = arr[i];
		size = arr.length;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCapacity() {
		return data.length;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void addFirst(E e) {
		add(0, e);
	}
	
	public void addLast(E e) {
		add(size, e);
	}
	
	// 在index位置插入元素e
	public void add(int index, E e) {
//		if(size == data.length) 
//			throw new IllegalArgumentException("Add failed. Array is full.");
//			
		if(index < 0 || index > size)
			throw new IllegalArgumentException("Add failed. Array index < 0 || index > size");
		
		if(size == data.length)
			resize(data.length * 2);
		
		for(int i = size - 1; i >= index; i--)
			data[i + 1] = data[i];
		data[index] = e;
		size ++;
	}
	
	// 获取index索引位置的元素
	public E get(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get fail. index is illegal.");
		return data[index];
	}
	
	public E getLast() {
		return get(size - 1);
	}
	
	public E getFirst() {
		return get(0);
	}
	
	// 修改index索引位置的元素为e
	public void set(int index, E e) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Get fail. index is illegal.");
		data[index] = e;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
		for(int i = 0; i < size; i++) {
			res.append(data[i]);
			if(i != size - 1)
				res.append(", ");
		}
		res.append(']');
		return res.toString();
	}
	
	// 查找数组中是否含有元素e
	public boolean contains(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e))
				return true;
		}
		return false;
	}
	
	// 查找数组中元素e所在的索引，如果不存在元素e则返回-1
	public int find(E e) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(e))
				return i;
		}
		return -1;
	}
	
	// 删除元素
	public E remove(int index) {
		if(index < 0 || index >= size)
			throw new IllegalArgumentException("Remove failed. index is illegal.");
		E ret = data[index];
		for (int i = index + 1; i < size; i++)
			data[i-1] = data[i];
		size--;
		data[size] = null; // loitering objects 但不是内存泄漏
		if(size == data.length/4 && data.length/2 != 0)
			resize(data.length/2);
		return ret;
	}
	
	public E removeFirst() {
		return remove(0);
	}
	
	public E removeLast() {
		return remove(size -1);
	}
	
	public void removeElement(E e) {
		int index = find(e);
		if(index != -1)
			remove(index);
	}
	
	public void swap(int i, int j) {
		if(i < 0 || i >= size || j < 0 || j >= size)
			throw new IllegalArgumentException("Index is illegal.");
		
		E t = data[i];
		data[i] = data[j];
		data[j] = t;		
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int newCapacity) {
		E[] newData = (E[])new Object[newCapacity];
		for(int i = 0; i < size; i++)
			newData[i] = data[i];
		data = newData;
	}
	
	
	public static void main(String[] args) {
		Array<Integer> arr = new Array<Integer>(20);
		for(int i = 0; i < 10; i++) 
			arr.addLast(i);
		System.out.println(arr);
		
		arr.add(1, 100);
		System.out.println(arr);
		
		arr.remove(2);
		System.out.println(arr);
		
		arr.removeElement(4);
		System.out.println(arr);
	}
	
	

}

