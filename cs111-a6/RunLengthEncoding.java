/*************************************************************************
 *  Compilation:  javac RunLengthEncoding.java
 *  Execution:    java RunLengthEncoding
 *
 *  @author:William Wang
 *
 *************************************************************************/

public class RunLengthEncoding {

    /* 
     * Encode the original string by finding sequences in the string
     * where the same character repeats. Replace each such sequence
     * by a token consisting of: the number of characters in the sequence
     * followed by the repeating character.
     * Return the encoded string.
     */
    public static String encode (String original)  {

	// WRITE YOUR CODE HERE
        String s = "";
        int n = original.length();
        for (int i = 0; i < n; i ++)
        {
            int count = 1;
            while (i < n - 1 && original.charAt(i) == original.charAt(i + 1))
            {
                count++;
                i++;
            }
            if (count > 1)
            {
                s = s + "" + count + original.charAt(i);
            }
            else
            {
                s = s + " " + original.charAt(i);
            }
        }
        return s;
    }

    /*
     * Decodes the original string encoded with the encode method.
     * Returns the decoded string.
     *
     * YOUR decode METHOD MUST BE RECURSIVE, do not use while, do/while, 
     * or for loops
     */
    public static String decode (String original)  {
	
	// WRITE YOUR RECURSIVE CODE HERE
        if (original == null || original.isEmpty())
        {
            return "";
        }

        String s = "";
        char[] c = original.toCharArray();
        boolean tf = false;
        String d = "";
        for(char current: c)
        {
            if (!Character.isDigit(current))
            {
                if (tf)
                {
                    String m = new String(new char[Integer.valueOf(d)]).replace("\0" , current + "");
                    s = s + "" + m;
                    tf = false;
                    d = "";
                }
                else
                {
                    s = s + "" + current;
                }
            }
            else
            {
                d += current;
                tf = true;
            }
        }
        return s;
    }

    public static void main (String[] args) {

	// WRITE YOUR TEST CASES HERE to test your methods
    }
}
