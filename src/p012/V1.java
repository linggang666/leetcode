package p012;

public class V1 {
    public String intToRoman(int num) {
        String[] map1 = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] map2 = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] map3 = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        
        StringBuilder res = new StringBuilder();
        if(num/1000 > 0){
            for (int i = 0; i < num/1000; i++) {
                res.append("M");
            }
            num = num % 1000;
        }
        
        res.append(map1[num/100]);
        num = num%100;
        res.append(map2[num/10]);
        num = num%10;
        res.append(map3[num]);
        
        return res.toString();
    }
    
    public static void main(String[] args) {
        V1 v = new V1();
        System.out.println(v.intToRoman(3990));
    }
}
