package p278;

/**
 * 2126753390 versions
1702766719 is the first bad version.
 * @author Administrator
 *
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
    	int left = 0, right=n;
    	while(left<right){
    		int mid = left + (right - left) / 2;
    		if(isBadVersion(mid)){
    			if(!isBadVersion(mid-1)) return mid;
    			right = mid-1;
    		}else{
    			if(isBadVersion(mid+1)) return mid+1;
    			left = mid+1;
    		}
    	}
    	return -1;
    }
    
    public static void main(String[] args) {
		System.out.println((new Solution()).firstBadVersion(2126753390));
	}
    
    protected boolean isBadVersion(int version){
    	if (version >= 1702766719) {
			return true;
		}
		return false;
	}
}