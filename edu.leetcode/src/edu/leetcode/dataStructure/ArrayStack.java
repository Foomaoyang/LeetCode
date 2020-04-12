package edu.leetcode.dataStructure;

import java.util.Iterator;

public class ArrayStack<T> implements MyStack<T> {

	// 栈元素数组，只能通过转型来创建泛型数组
	private T[] a = (T[]) new Object[1];

	// 元素数量
	private int N = 0;

	@Override
	public MyStack<T> push(T item) {
		check();
		a[N++] = item;
		return this;
	}

	@Override
	public T pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("stack is empty.");
		}

		T item = a[--N];

		check();

		// 避免对象游离
		a[N] = null;
		return item;
	}

	private void check() {
		
		if (N >= a.length) {
			resize(2 * a.length);
		} else if (N > 0 && N <= a.length / 4) {
			resize(a.length / 2);
		}

	}

	/**
	 * 调整数组大小，使得栈具有伸缩性
	 * 
	 * @param size
	 */
	private void resize(int size) {
		// TODO Auto-generated method stub

		T[] tmp = (T[]) new Object[size];

		for (int i = 0; i < N; i++) {
			tmp[i] = a[i];
		}

		a = tmp;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public Iterator<T> iterator(){
		
		// 返回逆序遍历的迭代器
		return new Iterator<T>() {
			
			private int i = N;
			
			@Override
			public boolean hasNext() {
				return i > 0;
			}
			
			@Override
			public T next() {
				return a[--i];
			}
		};
	}
}
