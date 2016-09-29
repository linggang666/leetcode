package p036;

public class V1 {
	public boolean isValidSudoku(char[][] board) {
		if(board.length != 9 || board[0].length != 9){
			return false;
		}
		return isValid4Row(board) && isValid4Cols(board) && isValid4Block(board) ;
	}
	
	private boolean isValid4Row(char[][] board){
		for (int i = 0; i < 9; i++) {
			if(!isValid(board[i])){
				return false;
			}
		}
		return true;
	}
	
	private boolean isValid4Cols(char[][] board){
		for (int i = 0; i < 9; i++) {
			char[] col = new char[9];
			for (int j = 0; j < 9; j++) {
				col[j] = board[j][i];
			}
			if(!isValid(col)){
				return false;
			}
		}
		return true;
	}
	
	private boolean isValid4Block(char[][] board){
		int[][] points = {
				{0,0},{0,3},{0,6},
				{3,0},{3,3},{3,6},
				{6,0},{6,3},{6,6}
		};
		for (int i = 0; i < 9; i++) {
			int i1 = 0;
			char[] col = new char[9];
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					col[i1++] = board[points[i][0] + j][points[i][1]+k];
				}
			}
			if(!isValid(col)){
				return false;
			}
		}
		return true;
	}
	
	private boolean isValid(char[] chars){
		int[] flags = new int[9];
		for (char c : chars) {
			if(c == '.') continue;
			int i = c - '0' - 1;
			if(flags[i] == 1){
				return false;
			}else{
				flags[i] = 1;
			}
		}
		return true;
	}
}
