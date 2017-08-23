package p037;

import java.util.Arrays;

public class V1 {
    public void solveSudoku(char[][] board) {
        _solveSudoku(board, 0, 0);
    }
    
    private boolean _solveSudoku(char[][] board, int i, int j) {
        int[] nextEmptyIndex = this._findNextEmptyIndex(board, i, j);
        if(nextEmptyIndex.length == 0){
            return true;
        }
        for (int k = 1; k <= 9; k++) {
            char x = (char)('0'+k);
            if(this._checkValid(board, nextEmptyIndex[0], nextEmptyIndex[1], x)){
                board[nextEmptyIndex[0]][nextEmptyIndex[1]] = x;
                if(_solveSudoku(board, nextEmptyIndex[0], nextEmptyIndex[1]+1)){
                    return true;
                }
                board[nextEmptyIndex[0]][nextEmptyIndex[1]] = '.';
            }
        }
        return false;
    }
    
    private boolean _checkValid(char[][] board, int i, int j, char x){
        for (int k = 0; k < 9; k++) { //row
            if(board[i][k] == x && k!=j) return false;
        }
        for (int k = 0; k < 9; k++) { //col
            if(board[k][j] == x && k!=i) return false;
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
    
    private int[] _findNextEmptyIndex(char[][] board, int i, int j){
        while(i<9){
            while(j<9){
                if(board[i][j] == '.'){
                    return new int[]{i,j};
                }
                j++;
            }
            j=0;
            i++;
        }
        return new int[0];
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
        
        V1 v1 = new V1();
        v1.solveSudoku(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
