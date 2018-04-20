import java.text.DecimalFormat;

import math.RationalScalar;

public class tester {
    public static void main(String[] args) {
       // System.out.println(new RationalScalar("232/3"));
        //System.out.println(new RationalScalar("-2323"));
        //System.out.println(new RationalScalar("+232/7"));
       // System.out.println((new RationalScalar("+3/4")).add(new RationalScalar("18/24")));
    	//String a = "-32575.32523";
    	//double b = Double.parseDouble(a);
    	 //System.out.println(b);
    	String toSplit = "a+b-c*d/e=f";
    	String[] splitted = toSplit.split("[-+*/=]");
    	for (String split: splitted) {
    	    System.out.println(split);
    	}
    }
    
    

}
