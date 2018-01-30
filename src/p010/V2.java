package p010;

public class V2 {

    /**
     * 递归方式
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        
        if(p.length()==0){
            return s.length()==0;
        }
        if(p.length()==1) {
            return s.length()==1 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.');
        }
        
        if(p.charAt(1) != '*') {
            if(s.length()==0)
                return false;
            if(p.charAt(0) != s.charAt(0) && p.charAt(0)!='.') {
                return false;
            }
            return isMatch(s.substring(1), p.substring(1));
        }
        
        if(isMatch(s, p.substring(2)))
            return true;
        
        while(s.length()>0 && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')){
            if(isMatch(s.substring(1), p.substring(2)))
                return true;
            s = s.substring(1);
        }
        return false;
    }
    
    public static void main(String[] args) {
        V2 v = new V2();
//        System.out.println(v.isMatch("aab", "c*a*b"));
        System.out.println(v.isMatch("a", ".*..a*"));
    }
}
