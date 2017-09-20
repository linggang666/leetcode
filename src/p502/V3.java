package p502;

import java.util.PriorityQueue;

public class V3 {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if(k<=0)  return 0;
        
        PriorityQueue<int[]> capP = new PriorityQueue<int[]>((a, b)-> a[0]-b[0]);
        PriorityQueue<int[]> proP = new PriorityQueue<int[]>((a, b)-> b[1]-a[1]);
        for (int i = 0; i < Capital.length; i++) {
            capP.add(new int[]{Capital[i], Profits[i]});
        }
        
        while (k-->0) {
            while(!capP.isEmpty() && capP.peek()[0]<=W){
                proP.add(capP.poll());
            }
            
            if(proP.isEmpty())
                break;
            
            W += proP.poll()[1];
        }
        return W;
    }
    
    
    public static void main(String[] args) {
        V3 v = new V3();
        int[] Profits = {1,2,3};
        int[] Capital = {0,1,1};
        System.out.println(v.findMaximizedCapital(2, 0, Profits, Capital));
    }

}
