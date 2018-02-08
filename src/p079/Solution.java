package p079;

public class Solution {

    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length==0 || word.length()==0) {
            return false;
        }

        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(this._exist(board, word, i, j, used)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean _exist(char[][] board, String word, int i, int j, boolean[][] used) {
        if(word.length()==0 || i<0||i>=board.length || j<0 || j>=board[0].length || board[i][j] != word.charAt(0) || used[i][j]) {
            return false;
        }
        
        if(word.length() == 1) {
            return true;
        }
        used[i][j] = true;
        if(this._exist(board, word.substring(1), i-1, j, used)) return true;
        if(this._exist(board, word.substring(1), i+1, j, used)) return true;
        if(this._exist(board, word.substring(1), i, j-1, used)) return true;
        if(this._exist(board, word.substring(1), i, j+1, used)) return true;
        used[i][j] = false;
        
        return false;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(s.exist(board, "BFDEC"));;
    }

}
