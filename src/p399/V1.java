package p399;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class V1 {
	
	Map<String, Map<String, Double>> graph = new HashMap<>();
	Set<String> visited = new HashSet<>();
	
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		initGraph(equations, values);
		
		double[] result = new double[queries.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = this.cal(queries[i][0], queries[i][1]);
		}
		return result;
	}
	
	private double cal(String e1, String e2){
		visited.clear();
		if(!graph.containsKey(e1) || !graph.containsKey(e2)){
			return -1.0;
		}
		Double result = _cal(e1, e2);
		return result == null ? -1: result;
	}
	
	private Double _cal(String e1, String e2){
		if(graph.containsKey(e1) && graph.get(e1).containsKey(e2)){
			return graph.get(e1).get(e2);
		}
		
		if(!visited.add(e1)){
			return null;
		}
		
		for (Map.Entry<String, Double> entry : graph.get(e1).entrySet()) {
			Double d1 = _cal(entry.getKey(), e2);
			if(d1 != null){
				return d1 * entry.getValue();
			}
		}
		return null;
	}
	
	
	private void initGraph(String[][] equations, double[] values) {
		for (int i = 0; i < equations.length; i++) {
			Map<String, Double> map1 = graph.get(equations[i][0]);
			if(map1 == null) {
				map1 = new HashMap<>(); 
				map1.put(equations[i][0], 1.0);
				graph.put(equations[i][0], map1);
			}
			map1.put(equations[i][1], values[i]);
			
			Map<String, Double> map2 = graph.get(equations[i][1]);
			if(map2 == null) {
				map2 = new HashMap<>(); 
				map2.put(equations[i][0], 1.0);
				graph.put(equations[i][1], map2);
			}
			map2.put(equations[i][0], 1.0/values[i]);
		}
	}
	
	public static void main(String[] args) {
		
		String[][] equations = {{"a", "b"},{"b", "c"}};
		double[] values = {2.0, 3.0};
		String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
		V1 v1 = new V1();
		System.out.println(Arrays.toString(v1.calcEquation(equations, values, queries)));
	}
}
