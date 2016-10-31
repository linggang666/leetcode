package p367;

public class V2 {
	public boolean isPerfectSquare(int num) {
		int l=1, r=num;
		while(l<=r){
			int mid = l+(r-l)/2;
			if(num%mid==0 && num/mid == mid)
				return true;
			if(num/mid < mid){
				r=mid-1;
			}else{
				l=mid+1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		V2 v = new V2();
		System.out.println(v.isPerfectSquare(2147483647));
		System.out.println(v.isPerfectSquare(144));
		System.out.println(v.isPerfectSquare(0));
	}
}
