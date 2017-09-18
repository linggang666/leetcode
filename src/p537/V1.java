package p537;

public class V1 {

    public String complexNumberMultiply(String sa, String sb) {

        int a = Integer.parseInt(sa.substring(0, sa.indexOf("+")));
        int b = Integer.parseInt(sa.substring(sa.indexOf("+")+1, sa.length()-1));
        int c = Integer.parseInt(sb.substring(0, sb.indexOf("+")));
        int d = Integer.parseInt(sb.substring(sb.indexOf("+")+1, sb.length()-1));
        
        int ra = a*c-b*d;
        int rb = b*c+a*d;
        return ra+"+"+rb+"i";
    }

    public static void main(String[] args) {
        V1 v = new V1();
        System.out.println(v.complexNumberMultiply("12+2i", "12+-1i"));

    }

}
