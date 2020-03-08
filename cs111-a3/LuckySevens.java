/*************************************************************************
 *  Compilation:  javac LuckySevens.java
 *  Execution:    java LuckySevens 421
 *
 *  @author:William Wang
 *
 * LuckySevens takes an int as a command-line argument and displays
 * how many digits in the integer number are 7s.  
 *
 * Note: the number can be negative.
 *
 *  % java LuckySevens 3482
 *  0
 *
 *  % java LuckySevens 372777
 *  4
 * 
 *  % java LuckySevens -2378272
 *  2
 *************************************************************************/

public class LuckySevens
{
    public static void main(String[] args)
    {
	// WRITE YOUR CODE HERE
    	int n = Math.abs(Integer.parseInt(args[0]));
        int count = 0;
        while (n > 1)
        {
            if (n % 10 == 7)
            {
                count = count + 1;
            }
            n = n / 10;
        }
        System.out.println(count);
    }

}
