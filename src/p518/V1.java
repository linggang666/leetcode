package p518;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class V1 {
    
    /**
     * Time Limit Exceeded
     * 500 [1,2,5]
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        if(amount == 0){
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        return this._change(amount, coins, list, set);
    }
    
    private int _change(int amount, int[] coins, List<Integer> list, Set<String> set){
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            if(coins[i] == amount){
                list.add(coins[i]);
                if(set.add(this.buildStr(list))){
                    res += 1;
                    System.out.println(this.buildStr(list));
                }
                list.remove(list.size()-1);
                break;
            }else if(coins[i] < amount){
                list.add(coins[i]);
                res += _change(amount-coins[i], coins, list, set);
                list.remove(list.size()-1);
            }
        }
        return res;
    }
    
    private String buildStr(List<Integer> list){
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        Arrays.sort(arr);
        return Arrays.toString(arr);
    }
    
    public static void main(String[] args) {
        V1 v = new V1();
        int[] coins = new int[]{1,2,5};
        System.out.println(v.change(500, coins));
    }
}
