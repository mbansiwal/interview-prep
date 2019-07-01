package dp;

/**
 * Remove minimum elements from either side such that 2*min becomes more than
 * max Given an unsorted array, trim the array such that twice of minimum is
 * greater than maximum in the trimmed array. Elements should be removed either
 * end of the array.
 * 
 * Number of removals should be minimum.
 * 
 * Examples:
 * 
 * arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200} Output: 4 We need to remove 4
 * elements (4, 5, 100, 200) so that 2*min becomes more than max.
 * 
 * 
 * arr[] = {4, 7, 5, 6} Output: 0 We don't need to remove any element as 4*2 > 7
 * (Note that min = 4, max = 8)
 * 
 * arr[] = {20, 7, 5, 6} Output: 1 We need to remove 20 so that 2*min becomes
 * more than max
 * 
 * arr[] = {20, 4, 1, 3} Output: 3 We need to remove any three elements from
 * ends like 20, 4, 1 or 4, 1, 3 or 20, 3, 1 or 20, 4, 1
 * 
 * @author mbansiwal
 *
 */
public class RemoveMinimumElements
{
	static int minRemovalsDP(int arr[], int n)
	{
		// Initialize starting and ending indexes of the maximum
		// sized subarray with property 2*min > max
		int longest_start = -1, longest_end = 0;

		// Choose different elements as starting point
		for (int i = 0; i < n; i++)
		{
			// Initialize min and max for the current start
			int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

			// Choose different ending points for current start
			for (int j = i; j < n; j++)
			{
				// Update min and max if necessary
				int val = arr[j];
				if (val < min)
					min = val;
				if (val > max)
					max = val;

				// If the property is violated, then no
				// point to continue for a bigger array
				if (2 * min <= max)
					break;

				// Update longest_start and longest_end if needed
				if (j - i > longest_end - longest_start || longest_start == -1)
				{
					longest_start = i;
					longest_end = j;
				}
			}
		}

		// If not even a single element follow the property,
		// then return n
		if (longest_start == -1)
			return n;

		// Return the number of elements to be removed
		return (n - (longest_end - longest_start + 1));
	}

	static int minRemovalsDP2(int arr[], int n)
	{
		// Create a table to store solutions of subproblems
		int table[][] = new int[n + 1][n + 1], gap, i, j, mn, mx;

		// Fill table using above recursive formula. Note that the table
		// is filled in diagonal fashion (similar to http://goo.gl/PQqoS),
		// from diagonal elements to table[0][n-1] which is the result.
		for (gap = 0; gap < n; ++gap)
		{
			for (i = 0, j = gap; j < n; ++i, ++j)
			{
				mn = min(arr, i, j);
				mx = max(arr, i, j);
				table[i][j] = (2 * mn > mx) ? 0 : min(table[i][j - 1] + 1, table[i + 1][j] + 1);
			}
		}
		return table[0][n - 1];
	}

	// A utility function to find minimum of two numbers
	static int min(int a, int b)
	{
		return (a < b) ? a : b;
	}

	// A utility function to find minimum in arr[l..h]
	static int min(int arr[], int l, int h)
	{
		int mn = arr[l];
		for (int i = l + 1; i <= h; i++)
			if (mn > arr[i])
				mn = arr[i];
		return mn;
	}

	// A utility function to find maximum in arr[l..h]
	static int max(int arr[], int l, int h)
	{
		int mx = arr[l];
		for (int i = l + 1; i <= h; i++)
			if (mx < arr[i])
				mx = arr[i];
		return mx;
	}

	// Driver program to test above functions
	public static void main(String[] args)
	{
		int arr[] =
		{
				4, 5, 100, 9, 10, 11, 12, 15, 200
		};
		System.out.println(minRemovalsDP(arr, arr.length));

		int arr2[] =
		{
				20, 7, 5, 6
		};
		System.out.println(minRemovalsDP(arr2, arr2.length));
	}
}
