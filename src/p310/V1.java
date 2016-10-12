package p310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class V1 {
	
	/**
	 * 从叶子节点开始减枝，最后剩一个或两个
	 * @param n
	 * @param edges
	 * @return
	 */
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> list = new ArrayList<Integer>();
		if(n == 1){
			list.add(0);
			return list;
		}
		Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
		initGraph(graph, edges);
		if(graph.size() != n) return list;
		
		while(graph.size()>2){
			delLeafNode(graph);
		}
		
		for(Integer key:graph.keySet()){
			list.add(key);
		}
		
		return list;
	}
	
	private void delLeafNode(Map<Integer, Set<Integer>> graph) {
		List<Integer> leafs = new ArrayList();
		for(Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()){
			if(entry.getValue().size() == 1){
				leafs.add(entry.getKey());
			}
		}
		for (int i = 0; i < leafs.size(); i++) {
			int leaf = leafs.get(i);
			for(Integer node: graph.get(leaf)){
				graph.get(node).remove(leaf);
			}
			graph.remove(leaf);
		}
	}

	private void initGraph(Map<Integer, Set<Integer>> graph, int[][] edges) {
		for (int[] es : edges) {
			if(!graph.containsKey(es[0])) graph.put(es[0], new HashSet<>());
			if(!graph.containsKey(es[1])) graph.put(es[1], new HashSet<>());
			graph.get(es[0]).add(es[1]);
			graph.get(es[1]).add(es[0]);
		}
	}
	
	public static void main(String[] args) {
		int[][] a = {{1, 0}, {1, 2}, {1, 3}};
		int[][] b = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		int[][] c = {};
		V1 v = new V1();
		System.out.println(Arrays.toString(v.findMinHeightTrees(6, b).toArray()));
	}
}
