package p051;

import java.util.ArrayList;
import java.util.List;

public class V2 {
	
	public List<List<String>> solveNQueens(int n){
        int[] board = new int[n];
        List<List<String>> res = new ArrayList<List<String>>();
        traverse(board, 0, n, res);
        return res;
    }
    
    private void traverse(int[] board, int row, int n, List<List<String>> res) {
        if (row == n) {
        	addRes(res, board, n);
        	return;
        };
        
        for (int j = 0; j < n; j++) {
            if (canPlace(board, row, j)) {
                board[row] = j;
                traverse(board, row+1, n, res);
            }
        }
    }
  
    private void addRes(List<List<String>> res, int[] board, int n) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < n; i++) {
			sb.append('.');
		}
    	List<String> temp = new ArrayList<>();
    	for (int i = 0; i < n; i++) {
    		sb.replace(board[i], board[i]+1, "Q");
			temp.add(sb.toString());
			sb.replace(board[i], board[i]+1, ".");
		}
    	res.add(temp);
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
		System.out.println(v.solveNQueens(4));
	}
}
