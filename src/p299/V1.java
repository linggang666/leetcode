package p299;

public class V1 {
	public String getHint(String secret, String guess) {
		
		int[] sa = new int[10];
		int[] ga = new int[10];
		
		int len = secret.length();
		int bulls = 0, cows = 0;
		for (int i = 0; i < len; i++) {
			char sc = secret.charAt(i);
			char gc = guess.charAt(i);
			if(sc == gc){
				bulls++;
			}else{
				sa[sc-'0']++ ;
				ga[gc-'0']++ ;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			cows += Math.min(sa[i],	 ga[i]);
		}
		
		return bulls + "A" + cows + "B";
	}
}
