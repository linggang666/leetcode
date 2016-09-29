package p374;

public class GuessGame {
	protected int guess(int num){
		int g = 1702766719;
		if(num < g){
			return 1;
		}else if(num > g){
			return -1;
		}else{
			return 0;
		}
	}
}
