/*************************************************************************
 *  Compilation:  javac HadamardMatrix.java
 *  Execution:    java HadamardMatrix 2
 *
 *  @author:William Wang
 *
 * The program HadamardMatrix prints H(n)
 *
 *  % java HadamardMatrix 2
 *  T T
 *  T F
 *
 *************************************************************************/

public class HadamardMatrix {

    public static void printMatrix(boolean[][]a, int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (a[i][j])
                {
                    System.out.print("T ");
                }
                else
                {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
    	int n = Integer.parseInt(args[0]);
    	boolean[][] a = new boolean[n][n];

    	a[0][0] = true;

    	for (int i = 1; i < n; i += i)
    	{
    		for (int j = 0; j < i; j++)
    		{
    			for (int k = 0; k < i; k++)
    			{
    				a[j + i][k] = a[j][k];
    				a[j][k + i] = a[j][k];
    				a[j + i][k + i] = !a[j][k];
    			}
    		}
    	}
        printMatrix(a, n);
    }
}
