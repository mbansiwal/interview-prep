package dp;

/**
 * http://www.geeksforgeeks.org/longest-common-increasing-subsequence-lcs-lis/
 * 
 * Given two arrays, find length of the longest common increasing subsequence
 * [LCIS] and print one of such sequences (multiple sequences may exist)
 * 
 * Suppose we consider two arrays – arr1[] = {3, 4, 9, 1} and arr2[] = {5, 3, 8,
 * 9, 10, 2, 1}
 * 
 * Our answer would be {3, 9} as this is the longest common subsequence which is
 * increasing also.
 * 
 * 
 * 
 * @author mbansiwal
 *
 */
public class LongestCommonIncreasingSubsequence
{
	public static void lcsis(int[] arr1, int[] arr2)
	{
		int n = arr1.length;
		int m = arr2.length;
		// table[j] is going to store length of
		// LCIS ending with arr2[j]. We initialize
		// it as 0,
		int table[] = new int[m];
		for (int j = 0; j < m; j++)
			table[j] = 0;

		// Traverse all elements of arr1[]
		for (int i = 0; i < n; i++)
		{
			// Initialize current length of LCIS
			int current = 0;

			// For each element of arr1[], traverse
			// all elements of arr2[].
			for (int j = 0; j < m; j++)
			{
				// If both the array have same
				// elements. Note that we don't
				// break the loop here.
				if (arr1[i] == arr2[j])
				{
					table[j] = Math.max(current + 1, table[j]);
				}

				/*
				 * Now seek for previous smaller common element for current
				 * element of arr1
				 */
				if (arr1[i] > arr2[j])
				{
					current = Math.max(table[j], current);
				}
			}
		}

		// The maximum value in table[] is out
		// result
		int result = 0;
		for (int i = 0; i < m; i++)
			if (table[i] > result)
				result = table[i];

		System.out.println(result);
	}

	public static void main(String[] args)
	{
		int arr1[] =
		{
				3, 4, 9, 1
		};
		int arr2[] =
		{
				5, 3, 8, 9, 10, 2, 1
		};

		lcsis(arr1, arr2);
	}
}
