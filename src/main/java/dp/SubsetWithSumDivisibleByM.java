package dp;

/**
 * Subset with sum divisible by m Given a set of non-negative distinct integers,
 * and a value m, determine if there is a subset of the given set with sum
 * divisible by m. Input Constraints Size of set i.e., n <= 1000000, m <= 1000
 * 
 * Examples:
 * 
 * Input : arr[] = {3, 1, 7, 5}; m = 6; Output : YES
 * 
 * Input : arr[] = {1, 6}; m = 5; Output : NO
 * 
 * @author mbansiwal
 *
 */
public class SubsetWithSumDivisibleByM
{
	public static boolean find(int[] arr, int m)
	{
		boolean[] table = new boolean[m + 1];
		for (int i = 0; i < arr.length; i++)
		{
			if (table[0])
			{
				return true;
			}

			boolean temp[] = new boolean[m];
			for (int j = 0; j <= m; j++)
			{
				if (table[j])
				{
					if (!table[(j + arr[i]) % m])
					{
						temp[(j + arr[i]) % m] = true;
					}
				}
			}

			for (int j = 0; j < temp.length; j++)
			{
				if (temp[j])
				{
					table[j] = true;
				}
			}

			table[arr[i] % m] = true;
		}
		return table[0];
	}

	public static void main(String arg[])
	{
		System.out.println(3 % 6);
		int arr[] =
		{
				1, 7
		};
		int n = arr.length;
		int m = 5;

		if (find(arr, m))
			System.out.print("YES\n");
		else
			System.out.print("NO\n");

		int arr2[] =
		{
				3, 1, 7, 5
		};
		if (find(arr2, 6))
			System.out.print("YES\n");
		else
			System.out.print("NO\n");

	}
}
