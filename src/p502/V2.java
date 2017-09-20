package p502;

import java.util.Comparator;
import java.util.PriorityQueue;

public class V2 {

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if(k<=0) 
            return 0;
        
        Comparator<Pair> comparator = new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                return o2.profit-o1.profit;
            }
        };
        PriorityQueue<Pair> p1 = new PriorityQueue<>(comparator);
        PriorityQueue<Pair> p2 = new PriorityQueue<>(comparator);
        
        for (int i = 0; i < Profits.length; i++) {
            p1.add(new Pair(Profits[i], Capital[i]));
        }
        while (k-->0 && !p1.isEmpty()) {
            while (!p1.isEmpty()) {
                Pair p = p1.poll();
                if(p.capital <= W){
                    W += p.profit;
                    break;
                }else{
                    p2.add(p);
                }
            }
            p1.addAll(p2);
            p2.clear();
        }
        return W;
    }
    
    
    class Pair{
        int profit;
        int capital;
        public Pair(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }
    
    
    public static void main(String[] args) {
        V2 v = new V2();
        int[] Profits = {1,2,3};
        int[] Capital = {0,1,1};
        System.out.println(v.findMaximizedCapital(2, 0, Profits, Capital));
    }

}
