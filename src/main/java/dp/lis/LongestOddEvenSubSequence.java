package dp.lis;

/**
 * The longest Zig-Zag subsequence problem is to find length of the longest subsequence of given sequence such that all elements of this are alternating.
If a sequence {x1, x2, .. xn} is alternating sequence then its element satisfy one of the following relation :

  x1 < x2 > x3 < x4 > x5 < …. xn or 
  x1 > x2 < x3 > x4 < x5 > …. xn 
Examples:

Input: arr[] = {1, 5, 4}
Output: 3
The whole arrays is of the form  x1 < x2 > x3 

Input: arr[] = {1, 4, 5}
Output: 2
All subsequences of length 2 are either of the form 
x1 < x2; or x1 > x2

Input: arr[] = {10, 22, 9, 33, 49, 50, 31, 60}
Output: 6
The subsequences {10, 22, 9, 33, 31, 60} or
{10, 22, 9, 49, 31, 60} or {10, 22, 9, 50, 31, 60}
are longest Zig-Zag of length 6.
 * @author mbansiwal
 *
 */
public class LongestOddEvenSubSequence
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
				if (arr[i] > arr[j] && (arr[i] + arr[j]) % 2 != 0)
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
				1, 12, 2, 22, 5, 30, 31, 14, 17, 11
		};
		System.out.println(sequence(arr));
		System.out.println(sequence2(arr));
	}
	
}
