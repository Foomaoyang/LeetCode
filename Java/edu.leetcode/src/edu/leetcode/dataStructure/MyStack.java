package edu.leetcode.dataStructure;

/**
 * 自定义栈
 * @author MaoYangyang
 *
 * @param <T>
 */
public interface MyStack<T> extends Iterable<T> {

	MyStack<T> push(T item);
	T pop() throws Exception;
	boolean isEmpty();
	int size();
}
