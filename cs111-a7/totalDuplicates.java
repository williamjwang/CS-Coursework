public class totalDuplicates
{
	public static int duplicates(String a)
	{
		int finalCounter = 0;
        int counter = 0;
        Boolean[] e = new Boolean [a.length()];
        for (int i = 0; i < a.length(); i++) {
            e[i] = true;
        }
        for (int i = 0; i < a.length(); i++) {
            if (e[i] != true)
            {
                continue;
            }
            else
            {
                e[i] = false;
                counter = 1;
            }
            for (int j = 1; j < a.length(); j++)
            {
                if (e[j] == false)
                {
                    continue;
                }
                else if (a.charAt(i) == a.charAt(j))
                {
                    counter++;
                    e[j] = false;
                }
            }
            if (counter > 1)
            {
                finalCounter += counter;
            }
        }
        return finalCounter;
	}

	public static void main(String[] args)
	{
		System.out.println(duplicates("gigi the gato"));
	}
}