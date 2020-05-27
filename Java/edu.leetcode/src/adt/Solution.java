package adt;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.TreeMap;

public class Solution {

	// LeetCode346问题，数组交集
	
	public int[] intersection(int[] nums1, int[] nums2) {
		TreeSet<Integer> set = new TreeSet<>();
		for(int num : nums1)
			set.add(num);
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int num : nums2) {
			if(set.contains(num)) {
				list.add(num);
				set.remove(num);
			}
		}
		
		int[] res = new int[list.size()];
		for(int i = 0; i< list.size(); i++)
			res[i] = list.get(i);
		return res;
	}
	
	public int[] intersect(int[] nums1, int[] nums2) {
		// LeetCode 350
		// 从元素到频率的映射
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int num: nums1) {
			if(!map.containsKey(num)) // 查找键
				map.put(num, 1); // 添加
			else
				map.put(num, map.get(num) + 1); // 修改
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int num: nums2) {
			if(map.containsKey(num)) {
				list.add(num);
				map.put(num, map.get(num) - 1);
				if(map.get(num) == 0)
					map.remove(num);
			}
		}
		
		int[] res = new int[list.size()];
		for(int i = 0; i < list.size(); i ++)
			res[i] = list.get(i);
		return res;
	}
	
	public static void main(String[] args) {
		
		int[] array1 = {};
		int[] array2 = {};
		
	}
}
