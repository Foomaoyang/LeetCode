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
	
	
	// ������ȫ�������������ʾ�У�һ����������ʾ��Ԫ�صĸ��׽�������
	private int parent(int index) {
		if(index == 0)
			throw new IllegalArgumentException("index-0 doesn't have parent.");
		return (index - 1) / 2;
	}

	// ��������Ԫ��
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
	
		// ������ȫ�������������ʾ�У�һ����������ʾ��Ԫ�ص����ӽڵ������
	private int leftChild(int index) {
		return index * 2 + 1;
	}
	
	private int rightChild(int index) {
		return index * 2 + 2;
	}
	
	// ���Ҷ������ֵ
	public E findMax() {
		if(data.getSize() == 0)
			throw new IllegalArgumentException("Can not findMax when heap is empty.");
		return data.get(0);
	}
	
	// ȡ���������Ԫ��
	public E extractMax() {
		E ret = findMax();
		
		data.swap(0, data.getSize() - 1);
		data.removeLast();
		siftDown(0);
		
		return ret;
	}
	
	// �³�����
	private void siftDown(int k) {
		while(leftChild(k) < data.getSize()) {
			int j = leftChild(k);
			if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
				j ++; // ת��������
			// ��ʱdata[j]��leftChild��rightChild�е����ֵ
			
			if(data.get(k).compareTo(data.get(j)) >= 0)
				break;
			
			data.swap(k, j);
			k = j;
		}
	}
	
	// ȡ�����е����Ԫ�أ������滻��Ԫ��e
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
	
	
	// ��������������ɶѵ���״
	public void heapify() {
		
	}
	
	// ���ض��е�Ԫ�ظ���
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
