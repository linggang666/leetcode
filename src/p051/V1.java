package p051;

import java.util.ArrayList;
import java.util.List;

public class V1 {
	public List<List<String>> solveNQueens(int n){
		List<List<String>> res = new ArrayList<List<String>>();;
        if(n <= 0) 
        	return res;
        
        char[][] flags = new char[n][n];
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				flags[i][j] = '.';
			}
		}
        for (int i = 0; i < n; i++) {
			_traverse(flags, n, 0, i, res);
		}
		return res;
    }

	private void _traverse(char[][] flags, int n, int i, int j, List<List<String>> res) {
		if(isValid(flags, n, i, j)){
			flags[i][j] = 'Q';
			if(i==n-1){
				List<String> temp = new ArrayList<>();
				for (int k = 0; k < n; k++) {
					temp.add(new String(flags[k]));
				}
				res.add(temp);
			}else{
				for (int k = 0; k<n; k++) {
					_traverse(flags, n, i+1, k, res);
				}
			}
			flags[i][j] = '.';
		}
		
	}

	private boolean isValid(char[][] flags, int n, int i, int j) {
		for (int k = 0; k < i; k++) //top
			if(flags[k][j] == 'Q')
				return false;
		for (int k1=i-1,k2=j-1; k1>=0&&k2>=0; k1--,k2--) //left top
			if(flags[k1][k2] == 'Q')
				return false;
		for (int k1=i-1,k2=j+1; k1>=0&&k2<n; k1--,k2++) //left top
			if(flags[k1][k2] == 'Q')
				return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.solveNQueens(4));
	}
}
