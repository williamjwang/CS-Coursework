/*************************************************************************
 *  Compilation:  javac RandomWalker.java
 *  Execution:    java RandomWalker 10
 *
 *  @author:William Wang
 *
 * The program RandomWalker that takes an int command-line argument n
 * and simulates the motion of a random walk for n steps. Print the
 * location at each step (including the starting point), treating the
 * starting point as the origin (0, 0). Also, print the square of the
 * final Euclidean distance from the origin.
 *
 *  % java RandomWalker 10
 * (0,0)
 * (-1,0)
 * (-1,-1)
 * (-1,-2)
 * (-1,-3)
 * (-1,-4)
 * (-1,-5)
 * (0,-5)
 * (-1,-5)
 * (-2,-5)
 * (-2,-4)
 * Squared distance = 20.0
 *
 *************************************************************************/

public class RandomWalker {

    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
    	int n = Integer.parseInt(args[0]);
    	int x = 0;
    	int y = 0;
    	for (int i = 0; i < n; i++)
    	{
    		double r = Math.random();
    		if (r < 0.25)
    		{
    			//North
    			y++;
    		}
    		else if (r < 0.5)
    		{
    			//East
    			x++;
    		}
    		else if (r < 0.75)
    		{
    			//south
    			y--;
    		}
    		else
    		{
    			//west
    			x--;
    		}
    		System.out.println("(" + x + ", " + y + ")");
    	}
    	double distance = Math.pow(x, 2) + Math.pow(y, 2);
    	System.out.println("Squared distance = " + distance);
    }
}
