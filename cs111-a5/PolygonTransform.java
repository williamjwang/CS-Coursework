/*************************************************************************
 *  Compilation:  javac PolygonTransform.java
 *  Execution:    java PolygonTransform
 *
 *  @author:William Wang
 *
 *************************************************************************/

public class PolygonTransform {


    // Returns a new array that is an exact copy of the given array. 
    // The given array is not mutated. 
    public static double[] copy(double[] array) {

	// WRITE YOUR CODE HERE
        return array;
    }
    
    // Scales the given polygon by the factor alpha. 
    public static void scale(double[] x, double[] y, double alpha) {

	// WRITE YOUR CODE HERE
        for (int i = 0; i < x.length; i++)
        {
            x[i] = alpha * x[i];
        }
        for (int i = 0; i < y.length; i++)
        {
            y[i] = alpha * y[i];
        }
    }
    
    // Translates the given polygon by (dx, dy). 
    public static void translate(double[] x, double[] y, double dx, double dy) {

	// WRITE YOUR CODE HERE
        for (int i = 0; i < x.length; i++)
        {
            x[i] = x[i] + dx;
        }
        for (int i = 0; i < y.length; i++)
        {
            y[i] = y[i] + dy;
        }
    }
    
    // Rotates the given polygon theta degrees counterclockwise, about the origin. 
    public static void rotate(double[] x, double[] y, double theta) {

	// WRITE YOUR CODE HERE
        copy(x);
        copy(y);

        for (int i = 0; i < x.length; i++)
        { 
            x[i] = x[i] * Math.cos(Math.toRadians(theta)) - y[i] * Math.sin(Math.toRadians(theta));
            y[i] = y[i] * Math.cos(Math.toRadians(theta)) + ((x[i] + y[i] * Math.sin(Math.toRadians(theta))) / Math.cos(Math.toRadians(theta))) * Math.sin(Math.toRadians(theta));
        }
    }

    // Tests each of the API methods by directly calling them. 
    public static void main(String[] args) {

	// WRITE YOUR CODE HERE
    }
}