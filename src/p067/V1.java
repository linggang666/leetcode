package p067;

public class V1 {
	public String addBinary(String a, String b) {
		if(a == null || a.length()==0) return b;
		if(b == null || b.length()==0) return a;
		
		StringBuilder sb = new StringBuilder();
		int aLen = a.length(), bLen = b.length();
		int t = 0;
		while(aLen>0 || bLen>0){
			int ai=0,bi=0, si;
			if(aLen>0) ai = a.charAt(--aLen) - '0';
			if(bLen>0) bi = b.charAt(--bLen) - '0';
			si = ai+bi+t;
			sb.insert(0, si%2);
			t = si/2;
		}
		if(t == 1) sb.insert(0, 1);
		
		return sb.toString();
	}
}
