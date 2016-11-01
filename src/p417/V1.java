package p417;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	
	/**
	 * dfs
	 * @param matrix
	 * @return
	 */
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<int[]>();
		if(matrix.length<1 || matrix[0].length<1) 
			return res;
		
		int rows = matrix.length, cols = matrix[0].length;
		boolean[][] pacificVisited = new boolean[rows][cols];
		boolean[][] atlantiVisited = new boolean[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			canFlow(matrix, pacificVisited, 0, i, 0);
			canFlow(matrix, atlantiVisited, 0, i, cols-1);
		}
		for (int i = 0; i < cols; i++) {
			canFlow(matrix, pacificVisited, 0, 0, i);
			canFlow(matrix, atlantiVisited, 0, rows-1, i);
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if(pacificVisited[i][j] && atlantiVisited[i][j]){
					res.add(new int[]{i,j});
				}
			}
		}
		return res;
	}
	
	
	private void canFlow(int[][] matrix, boolean[][] visited, int h, int i, int j) {
		if(i<0 || i>=visited.length || j<0 || j>=matrix[0].length || visited[i][j] || matrix[i][j]<h){
			return ;
		}
		visited[i][j] = true;
		canFlow(matrix, visited, matrix[i][j], i-1, j);
		canFlow(matrix, visited, matrix[i][j], i+1, j);
		canFlow(matrix, visited, matrix[i][j], i, j-1);
		canFlow(matrix, visited, matrix[i][j], i, j+1);
	}
	
	
	public static void main(String[] args) {
		int[][] c = {
				{1,2,3},	
				{8,9,4},	
				{7,6,5},	
		};
		V1 v = new V1();
		v.pacificAtlantic(c);
	}
}
