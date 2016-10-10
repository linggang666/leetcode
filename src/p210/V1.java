package p210;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class V1 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			list.add(i);
		}
		
		Map<Integer, Set<Integer>> outEdges = new HashMap<>();
		Map<Integer, Integer> inEdgeCnt = new HashMap<>();
		for (int i = 0; i < prerequisites.length; i++) {
			if(!outEdges.containsKey(prerequisites[i][1])){
				Set<Integer> set = new HashSet<>();
				outEdges.put(prerequisites[i][1], set);
			}
			
			if(outEdges.get(prerequisites[i][1]).add(prerequisites[i][0])){
				if(!inEdgeCnt.containsKey(prerequisites[i][0])){
					inEdgeCnt.put(prerequisites[i][0], 1);
				}else{
					inEdgeCnt.put(prerequisites[i][0], inEdgeCnt.get(prerequisites[i][0])+1);
				}
			}
			
			list.remove(new Integer(prerequisites[i][0]));
		}
		
		int i = 0;
		while(list.size()>0){
			int course = list.get(0);
			list.remove(0);
			result[i++] = course;
			
			if(outEdges.containsKey(course)){
				for(Integer c : outEdges.get(course)){
					if(inEdgeCnt.get(c) == 1){
						list.add(c);
					}else{
						inEdgeCnt.put(c, inEdgeCnt.get(c)-1);
					}
				}
			}
		}
		System.out.println(Arrays.toString(result));
		return i==numCourses? result: new int[0];
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
//		int[][] a = {{1,0},{3,4},{1,3},{0,2},{0,3}};
		int[][] a = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		System.out.println(Arrays.toString(v.findOrder(10, a)));
	}
}
