package p367;

public class V1 {
	public boolean isPerfectSquare(int num) {
		return _isPerfectSquare(num, 1,num);
	}

	private boolean _isPerfectSquare(int num, int l, int r) {
		if(l>r) return false;
		int mid = l+(r-l)/2;
		if(num%mid==0 && num/mid == mid)
			return true;
		if(num/mid < mid) 
			return _isPerfectSquare(num, l, mid-1);
		return _isPerfectSquare(num, mid+1, r);
	}
	
	public static void main(String[] args) {
		V1 v = new V1();
		System.out.println(v.isPerfectSquare(2147483647));
		System.out.println(v.isPerfectSquare(144));
		System.out.println(v.isPerfectSquare(0));
	}
}
