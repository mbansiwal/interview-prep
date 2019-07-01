package dp.lis;

/**
 * https://www.geeksforgeeks.org/longest-increasing-consecutive-subsequence/
 * 
 * @author mbansiwal
 *
 */
public class LongestConsecutiveSequence
{
	public static int sequence(int[] arr)
	{
		int[][] table = new int[arr.length][2];
		int result = 1;

		for (int i = 0; i < arr.length; i++)
		{
			table[i][0] = 1;
			table[i][1] = 1;
		}
		for (int i = 1; i < arr.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr[i] > arr[j])
				{
					if (arr[i] % 2 == 0)
					{
						table[i][0] = Math.max(table[i][0], table[j][1] + 1);
					} else
					{
						table[i][1] = Math.max(table[i][1], table[j][0] + 1);
					}
				}
			}
			result = Math.max(result, Math.max(table[i][0], table[i][1]));
		}

		return result;
	}
	
	public static int sequence2(int[] arr)
	{
		int[] table = new int[arr.length];
		int result = 1;

		for (int i = 0; i < arr.length; i++)
		{
			table[i] = 1;
		}
		for (int i = 1; i < arr.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr[i] > arr[j] && (arr[i] - arr[j]) == 1)
				{
						table[i] = Math.max(table[i], table[j] + 1);
				}
			}
			result = Math.max(result, table[i]);
		}

		return result;
	}

	public static void main(String[] args)
	{
		int arr[] =
		{
				6, 7, 8, 3, 4, 5, 9, 10
		};
		System.out.println(sequence(arr));
		System.out.println(sequence2(arr));
	}
	
}
