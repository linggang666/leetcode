package p052;

public class V2 {
	
	public int totalNQueens(int n) {
        int[] board = new int[n];
        return traverse(board, 0, n);
    }
    
    private int traverse(int[] board, int row, int n) {
        if (row == n) return 1;
        
        int res = 0;
        for (int j = 0; j < n; j++) {
            if (canPlace(board, row, j)) {
                board[row] = j;
                res += traverse(board, row+1, n);
            }
        }
        return res;
    }
  
    private boolean canPlace(int[] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            int j = board[i];
            int rowDiff = row - i;
            int colDiff = Math.abs(col - j);
            if (col == j || colDiff == rowDiff) 
            	return false;
        }
        return true;
    }
	
	
	public static void main(String[] args) {
		V2 v = new V2();
		System.out.println(v.totalNQueens(4));
	}
}
