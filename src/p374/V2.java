package p374;

public class V2 extends GuessGame{

	public int guessNumber(int n) {
		
		int l=1,h=n;
		while(true){
			int m = l + (h-l)/2;
			int gr = guess(m); 
			if(gr == 0){
				return m;
			}else if(gr == 1){
				l = m + 1;
			}else{
				h = m -1;
			}
		}
    }
}
