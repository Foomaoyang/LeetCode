package edu.leetcode.dataStructure;

public class FooStack {
	
	/**
	 * 栈
	 * @author MaoYangyang
	 *
	 * @param <Item>
	 */
	public interface MyStack<Item> extends Iterable<Item>{
		MyStack<Item> push(Item item);
		Item pop() throws Exception;
		boolean isEmpty();
		int size();
	}
	
//	/**
//	 * 数组实现
//	 * @author MaoYangyang
//	 *
//	 * @param <Item>
//	 */
//	public class ArrayStack<Item> implements MyStack<Item>{
//		
//		// 栈元素数组，只能通过转型来创建泛型数组
//		private Item[] a = (Item[]) new Object[1];
//		
//		// 元素数量
//		private int N = 0;
//		
//		@Override
//		public MyStack<Item> push(Item item){
//			check();
//			a[N++] = item;
//			return this;
//		}
//		 
//		@Override
//		public Item pop() throws Exception{
//			if(isEmpty()) {
//				throw new Exception("stack is empty.");
//			}
//			
//			Item item = a[--N];
//			
//			check();
//			
//			//避免对象游离
//			a[N] = null;
//			return item;
//		}
//
//		private void check() {
//			// TODO Auto-generated method stub
//			if(N >= a.length) {
//				resize(2 * a.length);
//			}else if(N>0&&N<=a.length/4) {
//				resize(a.length/2);
//			}
//			
//		}
//
//		/**
//		 * 调整数组大小，使得栈具有伸缩性
//		 * @param size
//		 */
//		private void resize(int size) {
//			// TODO Auto-generated method stub
//			
//			Item[] tmp = (Item[]) new Object[size];
//			
//			for(int i = 0; i < N; i++) {
//				tmp[i] = a[i];
//			}
//			
//			a = tmp;
//		}
//		
//		@Override
//		public boolean isEmpty() {
//			return N == 0;
//		}
//		
//		@Override
//		public int size() {
//			return N;
//		}
//		
//		@Override
//		public Iterator<Item> iterator(){
//			
//			// 返回逆序遍历的迭代器
//			return new Iterator<Item>() {
//				
//				private int i = N;
//				
//				@Override
//				public boolean hasNext() {
//					return i > 0;
//				}
//				
//				@Override
//				public Item next() {
//					return a[--i];
//				}
//			};
//		}
//		
//	}
//	
//	
	
	
	
	

}

