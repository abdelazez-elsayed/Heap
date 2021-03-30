package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Double,Double> fun= new HashMap<>();
    public static ArrayList<Double> test = new ArrayList<>();
   public static ArrayList<String> printed = new ArrayList<>();
   public static ArrayList<Double> bs = new ArrayList<>();
    public static void main (String[] args){
        // Write your function here -->
       fun.put(0.1,0.1003);
        fun.put(0.2,0.2027);
        fun.put(0.4,0.4228);
        fun.put(0.8,1.0296);
        fun.put(1.0,1.5574);

        //............................................
        for(Double key : fun.keySet())
            test.add(key);
        Collections.sort(test);
        System.out.println("b0 = "+fun.get(test.get(0)));
        bs.add(fun.get(test.get(0)));
        dividedDifference(test);
        printFun();


    }

    public static double dividedDifference(ArrayList<Double> f){
        if(f.size()==2){

            double dom=fun.get(f.get(0))-fun.get(f.get(1));
            double nom = f.get(0)-f.get(1);
            String s = "F["+f.get(0)+","+f.get(1)+"] : ";
            if(!printed.contains(s)) {
                System.out.print(s);
                System.out.println(dom/nom);
                printed.add(s);
                if(f.get(0)==test.get(0)) {
                    bs.add(dom/nom);
                    System.out.println("b1 = " + dom / nom);
                }
            }

            return dom/nom;
        }
        ArrayList<Double> f1 = new ArrayList<>();
        ArrayList<Double> f2 = new ArrayList<>();
        for(int i =0; i<f.size()-1;i++)f1.add(f.get(i));
        for (int i=1;i<f.size();i++)f2.add(f.get(i));
        double dom = dividedDifference(f1)-dividedDifference(f2);
        double nom = f.get(0)-f.get(f.size()-1);
        String s = "F[";

        for (int i=0;i<f.size();i++)
            s += String.valueOf(f.get(i))+",";
        s += "] : "+String.valueOf(dom/nom);
        if(!printed.contains(s)) {
            System.out.println(s);
            if(f.get(0)==test.get(0)) {
                bs.add(dom/nom);
                System.out.println("b"+(f.size()-1)+" = "+dom/nom);
            }
            printed.add(s);
        }
        return dom/nom;

    }
    public static void printFun(){
        for(int i=0;i<bs.size();i++){
            System.out.print(bs.get(i));
            for(int j=0;j<i;j++){
                System.out.print("(X-"+test.get(j)+")");
            }
            if(i!=bs.size()-1)
            System.out.print("+");
        }
    }
}
