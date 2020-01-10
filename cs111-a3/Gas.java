/*************************************************************************
 *  Compilation:  javac Gas.java
 *  Execution:    java Gas 3.40 15.0 true
 *
 *  @author:William Wang
 *
 * The program Gas computes and displays the price a
 * person will pay for gas at the gas station.
 *
 *  % java Gas 3.40 15.0 false
 *  56.1
 *
 *  % java Gas 3.40 15.0 true
 *  51.0
 *
 *************************************************************************/

public class Gas {

    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
    	double ppg = Double.parseDouble(args[0]);
    	double gal = Double.parseDouble(args[1]);
    	double price = 0;
    	boolean corc = Boolean.parseBoolean(args[2]);
        
    	if (ppg <= 0 || gal <= 0)
    	{
    		System.out.println("Illegal input");
    	}
    	else
    	{
    		if (corc == true)
    		{
    			price = ppg * gal;
    		}
    		else
    		{
    			price = ppg * gal * 1.1;
    		}
    		System.out.println(price);
    	}
    }
}
