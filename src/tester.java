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
    	
    	double d = 2342.12874;
    	System.out.println(format(d));
    	
    }
    
    
	private static double format(double d) {
		
		DecimalFormat df = new DecimalFormat("#.###");
		return Double.parseDouble(df.format(d));
		
	}
}
