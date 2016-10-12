package p310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class V2 {
	
	Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
	Set<Integer> visited = new HashSet<Integer>();
	int minHeight = Integer.MAX_VALUE;
	
	/**
	 * time limit exceeded
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
		initGraph(edges);
		if(graph.size() != n) return list;
		
		for(int node=0; node<n; node++){
			visited.clear();
			Set<Integer> nodes = new HashSet<Integer>();
			nodes.add(node);
			visited.add(node);
			int height = getHeight(nodes, 0);
			if(height < minHeight){
				minHeight = height;
				list.clear();
			}
			if(height == minHeight){
				list.add(node);
			}
		}
		return list;
	}
	
	private int getHeight(Set<Integer> nodes, int curHeight) {
		Set<Integer> noVisit = new HashSet<Integer>();
		for(Integer node: nodes){
			noVisit.addAll(graph.get(node));
		}
		
		noVisit.removeAll(visited);
		if(noVisit.isEmpty()){
			return curHeight;
		}
		visited.addAll(noVisit);
		
		return getHeight(noVisit, curHeight+1);
	}

	private void initGraph(int[][] edges) {
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
		V2 v = new V2();
		System.out.println(Arrays.toString(v.findMinHeightTrees(1, c).toArray()));
	}
}
