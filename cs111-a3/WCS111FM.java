/*************************************************************************
 *  Compilation:  javac WCS111FM.java
 *  Execution:    java WCS111FM 53
 *
 *  The program takes the number of hours the listener spends
 *  programming as an int argument. Based on the number of hours spent
 *  programming, display the listener prize
 *
 *  @author: William Wang
 *
 *  % java WCS111FM 3
 *  T-shirt
 *
 *  % java WCS111FM 9
 *  Laptop
 *  TV
 * 
 *  % java WCS111FM 0
 *  Nothing
 *************************************************************************/

public class WCS111FM {

    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
    	int n = Integer.parseInt(args[0]);
    	String display = "";
    	if (n == 0)
    	{
    		display = "Nothing";
    	}
    	else if (n >= 1 && n <= 5)
    	{
    		display = "T-shirt";
    	}
    	else if (n >= 6 && n <= 400)
    	{
    		if (n % 10 == 9)
    		{
    			display = "Laptop\n";
    		}
    		if (n % 2 == 0)
    		{
    			display = display + "Hat\n";
    		}
    		if (n % 3 == 0)
    		{
    			display = display + "TV\n";
    		}
    	}
    	System.out.println(display);
    }
}