package p037;

import java.util.Arrays;

public class V2 {
    public void solveSudoku(char[][] board) {
        _solveSudoku(board);
    }
    
    private boolean _solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                    for (char k = '1'; k <= '9'; k++) {
                        if(this._checkValid(board, i, j, k)){
                            board[i][j] = k;
                            if(this._solveSudoku(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean _checkValid(char[][] board, int i, int j, char x){
        for (int k = 0; k < 9; k++) { 
            if(board[i][k] == x && k!=j) return false; //row
            if(board[k][j] == x && k!=i) return false; //col
        }
        
        // rec
        int _i = i<3? 0: i<6? 3 : 6;
        int _j = j<3? 0: j<6? 3 : 6;
        for (int i1 = 0; i1 < 3; i1++) {
            for (int j1 = 0; j1 < 3; j1++) {
                if(board[_i+i1][_j+j1] == x && (_i+i1!=i || _j+j1!=j)) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        char[][] board = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}
        };
        
        V2 v1 = new V2();
        v1.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
