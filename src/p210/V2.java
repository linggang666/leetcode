package p210;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class V2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		
		int[] result = new int[numCourses];
        int k = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()){
            int course = queue.poll();
            result[k++] = course;
            count++;
            for (int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == course){
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0){
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        return count == numCourses ? result : new int[0];
	}
	
	public static void main(String[] args) {
		V2 v = new V2();
//		int[][] a = {{1,0},{3,4},{1,3},{0,2},{0,3}};
		int[][] a = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		System.out.println(Arrays.toString(v.findOrder(10, a)));
	}
}
