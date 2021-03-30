package eg.edu.alexu.csd.filestructure.sort;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main1 {
    public Main1() {
    }

    public static void main(String[] args) {
        int c=26;
        Integer in = 1;
        in.hashCode();
        String  s=new String("sad");
        int t=s.hashCode();
   
        HashSet<Integer> hashSet = new HashSet<>();
        Map grades = new HashMap();
        grades.put("Martin", "A");
        grades.put("Nelson", "F");
        grades.put("Milhouse", "B");
// What grade did they get?
        System.out.println( grades.get("Nelson"));
        System.out.println( grades.get("Martin"));
        System.out.print("\n after test \n");
        grades.put("Nelson", "W"); grades.remove("Martin");
        System.out.println( grades.get("Nelson"));
        System.out.println( grades.get("Martin"));

        BigInteger a = new BigInteger("1");

        for(int i=0;i<10;i++){
            a=a.multiply(comb(c,2));
            c-=2;
        }
        a=a.divide(factorial(10));
      //  System.out.print(a);
    }
    public static BigInteger comb(int n,int r){
        return (factorial(n).divide(factorial(r).multiply(factorial(n-r))));
    }
    public static BigInteger factorial (int N) {
        BigInteger f = new BigInteger("1"); // Or BigInteger.ONE

        // Multiply f with 2, 3, ...N
        for (int i = 2; i <= N; i++)
            f = f.multiply(BigInteger.valueOf(i));

        return f;
    }
}
