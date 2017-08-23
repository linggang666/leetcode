package p495;

public class V1 {

    public static void main(String[] args) {
        V1 v1 = new V1();
        int[] a = {1,3,7, 7};
        System.out.println(v1.findPoisonedDuration(a, 3));
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        
        int len = timeSeries.length;
        for (int i = 0; i < len; i++) {
            if(i==len-1){
                res += duration;
            }else{
                res += Math.min(duration, timeSeries[i+1]-timeSeries[i]);
            }
        }
        return res;
    }
}
