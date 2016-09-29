package p133;

import java.util.HashMap;
import java.util.Map;

public class V1 {
	
	Map<Integer, UndirectedGraphNode> visited = new HashMap<Integer, UndirectedGraphNode>(); 
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		
		int label = node.label;
		if(visited.containsKey(label)){
			return visited.get(label);
		}
		
		UndirectedGraphNode clone = new UndirectedGraphNode(label);
		visited.put(label, clone);
		for (UndirectedGraphNode neighbor : node.neighbors) {
			cloneGraph(neighbor);
			clone.neighbors.add(visited.get(neighbor.label));
		}
		
		return clone;
	}
	
	
}
