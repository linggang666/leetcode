package p374;

public class V1 extends GuessGame{

	public int guessNumber(int n) {
        return _guessNumber(1, n);
        
    }
	
	private int _guessNumber(int l, int h){
		int m = (int) (((long)l + (long)h) / 2);;
		if(guess(m) == 0){
			return m;
		}else if(guess(m) == 1){
			return _guessNumber(m+1, h);
		}else{
			return _guessNumber(l, m-1);
		}
	}
}
