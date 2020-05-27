package adt;

public class ListNode {

	public int val;
	public ListNode next;
	
	public ListNode(int x) {
		val = x;
	}
	
	// 使用arr为参数创建一个链表，当前的ListNode为链表头结点
	public ListNode(int[] arr) {
		
		if(arr == null || arr.length == 0)
			throw new IllegalArgumentException("arr can not be empty.");
		
		this.val = arr[0];
		ListNode cur = this;
		for(int i = 1; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
	}
	
	public ListNode removeElements(ListNode head, int val) {
		while(head != null && head.val == val) {
			head = head.next;
		}
		
		if(head == null)
			return null;
		
		ListNode prev = head;
		while(prev.next != null) {
			if(prev.next.val == val)
				prev.next = prev.next.next;
			else
				prev = prev.next;
		}
		
		return head;
	}
	
	// 用递归的方式删除元素
	public ListNode removeAllElements(ListNode head, int val) {
		if(head == null)
			return head;
		
		head.next = removeAllElements(head.next, val);
		return head.val == val ? head.next : head;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		ListNode cur = this;
		while(cur != null) {
			res.append(cur.val + "->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}
	
	
	public static void main(String[] args) {
		int[] nums = {1, 2, 6, 3, 4, 5, 6};
		ListNode head = new ListNode(nums);
		System.out.println(head);
		
		head.removeElements(head, 6);
		System.out.println(head);
	}
}
