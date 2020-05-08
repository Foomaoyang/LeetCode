package edu.leetcode.graph;

import java.util.Arrays;
import java.util.logging.Logger;

public class isGraphBipartite {
	 static String strClassName = isGraphBipartite.class.getName();  
	 static Logger logger = Logger.getLogger(strClassName); 
	
//	Example 2:
//		Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
//		Output: false
//		Explanation:
//		The graph looks like this:
//		0----1
//		| \  |
//		|  \ |
//		3----2
//		We cannot find a way to divide the set of nodes into two independent subsets.
//	

	public static boolean isBipartite(int[][] graph) {
		int[] colors = new int[graph.length];
		Arrays.fill(colors, -1);
		for(int i = 0; i < graph.length; i++) {
			System.out.println("123");
			// 处理图不是连通的情况
			if(colors[i] == -1 && !isBipartite(i, 0, colors, graph)) {
				return false;
			}
		}
		

		return true;
	}
	
	public static boolean isBipartite(int curNode, int curColor, int[] colors, int[][] graph) {
		if(colors[curNode] != -1) {
			return colors[curNode] == curColor;
		}
		colors[curNode] = curColor;
		logger.info("input iteration.");
		System.out.println("进入迭代");
		
		for(int nextNode : graph[curNode]) {
			if(!isBipartite(nextNode, 1 - curColor, colors, graph)) {
				System.out.println("结点是：" + nextNode + ";\n\t");
				
				return false;
			}
		}
		System.out.println("迭代退出");
		return true;		
	}
	
	
	public static void main(String[] args) {
		int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
//		int[][] graph = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
		
		System.out.println(isBipartite(graph));
		System.out.println(graph.length);
	}
	
}
