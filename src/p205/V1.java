package p205;

public class V1 {
	public boolean isIsomorphic(String s, String t) {
		
		int[] secrets = new int[128];
		int[] temp = new int[128];
		for (int i = 0; i < secrets.length; i++) {
			secrets[i] = Integer.MAX_VALUE;
		}
		
		int len = s.length();
		for (int i = 0; i < len; i++) {
			char sc = s.charAt(i);
			char tc = t.charAt(i);
			
			if(secrets[sc-0] == Integer.MAX_VALUE && temp[tc-0] == 0){
				secrets[sc-0] = sc - tc;
				temp[tc-0] = 1;
			}else if(sc-tc != secrets[sc-0]){
				return false;
			}
		}
		return true;
	}
}
