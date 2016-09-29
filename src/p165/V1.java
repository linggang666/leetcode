package p165;

public class V1 {
	public int compareVersion(String version1, String version2) {
		String[] s1 = version1.split("\\.");
		String[] s2 = version2.split("\\.");
		
		int i=0;
		while(s1.length>i || s2.length>i){
			int v1=0, v2=0;
			if(s1.length>i) v1=Integer.valueOf(s1[i]);
			if(s2.length>i) v2=Integer.valueOf(s2[i]);
			if(v1>v2) return 1;
			if(v1<v2) return -1;
			i++;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println((new V1()).compareVersion("1.12", "1.12.0"));
	}
}
