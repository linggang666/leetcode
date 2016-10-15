package p200;

public class V1 {
	
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
		int nums=0;
		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] flags = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)  {
				if(grid[i][j] == '1' && flags[i][j] == false){
					nums++;
					updateFlags(grid, flags, i, j);
				}
			}
		}
		return nums;
    }

	private void updateFlags(char[][] grid, boolean[][] flags, int i, int j) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;
		if(flags[i][j] || grid[i][j] == '0') return ;
		
		flags[i][j] = true;
		updateFlags(grid, flags, i-1, j);
		updateFlags(grid, flags, i+1, j);
		updateFlags(grid, flags, i, j-1);
		updateFlags(grid, flags, i, j+1);
	}
	
	public static void main(String[] args) {
		char[][] arr = {
				{'1','1','0','1','0'},
				{'0','0','0','1','0'},
				{'1','1','1','1','0'},
				{'0','0','0','0','0'}
		};
		V1 v = new V1();
		System.out.println(v.numIslands(arr));
	}
}
