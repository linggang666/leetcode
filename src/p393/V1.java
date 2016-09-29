package p393;

public class V1 {

	public boolean validUtf8(int[] data) {
		int i=0;
		while(i < data.length){
			int bits = data[i]&0xFF;
			int charLen = this.getCharLen(bits);
			if(charLen == -1) return false;
			if(charLen > 0){
				while(charLen-->1){
					if(++i>=data.length) return false;
					if((data[i]&0xFF) >> 6 != 2) return false;
				}
			}
			i++;
		}
		return true;
	}
	
	private int getCharLen(int n){
		int len = 0;
		while(n>>7 ==1){
			len ++;
			n = (n<<1)&0xFF;
		}
		
		if(len == 1 || len>4) return -1;
		return len;
	}

	public static void main(String[] args) {
		V1 v = new V1();
		int[] a = {230,136,145};
		int[] b = {235, 140, 4};//[230,136,145]
		System.out.println(v.validUtf8(a));
		System.out.println(Integer.toBinaryString(136));
//		System.out.println(v.validUtf8(b));
	}

}
