package p052;

public class V1 {
	public int totalNQueens(int n) {
        if(n <= 0) return n;
        
        boolean[][] flags = new boolean[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
			res += _traverse(flags, n, 0, i);
		}
		return res;
    }

	private int _traverse(boolean[][] flags, int n, int i, int j) {
		int res = 0;
		if(isValid(flags, i, j, n)){
			if(i==n-1) return 1;
			
			flags[i][j] = true;
			for (int k = 0; k<n; k++) {
				res += _traverse(flags, n, i+1, k);
			}
			flags[i][j] = false;
		}
		return res;
	}

	private boolean isValid(boolean[][] flags, int i, int j, int n) {
		for (int k = 0; k < i; k++) //top
			if(flags[k][j])
				return false;
		for (int k1=i-1,k2=j-1; k1>=0&&k2>=0; k1--,k2--) //left top
			if(flags[k1][k2])
				return false;
		for (int k1=i-1,k2=j+1; k1>=0&&k2<n; k1--,k2++) //left top
			if(flags[k1][k2])
				return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.totalNQueens(8));
	}
}
