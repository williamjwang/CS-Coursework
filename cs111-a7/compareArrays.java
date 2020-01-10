public class compareArrays
{
	public static boolean compare(int[] a, int[] b)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j < 0; j < b.length; j++)
			{
				if (a[i] == b[j])
				{
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args)
	{
		int[] a = {1, 2, 3, 4};
		int[] b = {1, 2, 3, 4};
		System.out.println(compare(a, b));
	}
}