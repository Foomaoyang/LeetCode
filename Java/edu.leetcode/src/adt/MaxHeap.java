package adt;

import java.util.Random;

public class MaxHeap<E extends Comparable<E>> {

	private Array<E> data;
	
	public MaxHeap(int capacity) {
		data = new Array<>(capacity);
	}
	
	public MaxHeap() {
		data = new Array<>();
	}
	
	public MaxHeap(E[] arr) {
		data = new Array<>(arr);
		for(int i = parent(arr.length-1); i >= 0; i--)
			siftDown(i);
	}
	
	
	// 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲结点的索引
	private int parent(int index) {
		if(index == 0)
			throw new IllegalArgumentException("index-0 doesn't have parent.");
		return (index - 1) / 2;
	}

	// 向堆中添加元素
	public void add(E e) {
		data.addLast(e);
		siftUp(data.getSize() - 1);
	}
	
	private void siftUp(int k) {
		while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
			data.swap(k, parent(k));
			k = parent(k);
		}
	}
	
		// 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
	private int leftChild(int index) {
		return index * 2 + 1;
	}
	
	private int rightChild(int index) {
		return index * 2 + 2;
	}
	
	// 查找堆中最大值
	public E findMax() {
		if(data.getSize() == 0)
			throw new IllegalArgumentException("Can not findMax when heap is empty.");
		return data.get(0);
	}
	
	// 取出堆中最大元素
	public E extractMax() {
		E ret = findMax();
		
		data.swap(0, data.getSize() - 1);
		data.removeLast();
		siftDown(0);
		
		return ret;
	}
	
	// 下沉操作
	private void siftDown(int k) {
		while(leftChild(k) < data.getSize()) {
			int j = leftChild(k);
			if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
				j ++; // 转成右子树
			// 此时data[j]是leftChild和rightChild中的最大值
			
			if(data.get(k).compareTo(data.get(j)) >= 0)
				break;
			
			data.swap(k, j);
			k = j;
		}
	}
	
	// 取出堆中的最大元素，并且替换成元素e
	public E replace(E e) {
		E ret = findMax();
		data.set(0,  e);
		siftDown(0);
		return ret;
	}
	//                          Heapify
	///////////////////////////////////////////////////
	//                                      15                            //
	//                             /                   \                   //
	//                     17                             19            //
	//            /                 \               /             \       //
	//        13                   22         16              28    //
	//      /     \                /                                      //
	//   30     41            62                                     //
	//////////////////////////////////////////////////
	
	
	// 将任意数组整理成堆的形状
	public void heapify() {
		
	}
	
	// 返回堆中的元素个数
	public int size() {
		return data.getSize();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public static void main(String[] args) {
		int n = 100000;
		MaxHeap<Integer> maxHeap = new MaxHeap<>();
		Random random = new Random();
		for(int i = 0; i < n; i ++)
			maxHeap.add(random.nextInt(Integer.MAX_VALUE));
		
		int[] arr = new int[n];
		for(int i = 0; i < n; i ++)
				arr[i] = maxHeap.extractMax();
		
		for(int i = 1; i < n; i ++)
			if(arr[i - 1] < arr[i])
				throw new IllegalArgumentException("Error");
		
		System.out.println("Test MaxHeap completed.");
	}
}
