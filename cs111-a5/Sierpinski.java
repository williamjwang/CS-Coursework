/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author:William Wang
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {

	// WRITE YOUR CODE HERE
        double height = length * 0.5 * Math.sqrt(3.0);
        return height;
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {

	// WRITE YOUR CODE HERE
        double[] a = new double[3];
        double[] b = new double[3];
        a[0] = x - length/2;
        a[1] = x + length/2;
        a[2] = x;
        b[0] = height(length) + y;
        b[1] = b[0];
        b[2] = y;
        StdDraw.filledPolygon(a, b);
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {

	// WRITE YOUR CODE HERE
        if (n == 0)
        {
            return;
        }
        filledTriangle(x, y, length);
        sierpinski(n - 1, x - length/2, y, length/2);
        sierpinski(n - 1, x + length/2, y, length/2);
        sierpinski(n - 1, x, y + length * Math.sqrt(3.0) / 2, length/2);
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {

	// WRITE YOUR CODE HERE 
        int n = Integer.parseInt(args[0]);
        StdDraw.line(0, 0, 1, 0);
        StdDraw.line(1, 0, 0.5, Math.sqrt(3.0) / 2);
        StdDraw.line(0.5, Math.sqrt(3.0) / 2, 0, 0);
        sierpinski(n, 0.5, 0, 0.5);
    }
}