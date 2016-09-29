package p223;

public class V1 {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int blx = Math.max(A, E);  
        int bly = Math.max(B, F);  
        int rtx = Math.min(C, G);  
        int rty = Math.min(D, H);  
        int res = (C-A) * (D-B) + (G-E) * (H-F);  
        if(blx >= rtx || bly >= rty) return res;  
        return res - (rtx - blx) * (rty - bly);  
	}
}
