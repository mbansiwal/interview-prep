package arr;

/**
 * Given an array of integers and a number x, find the smallest subarray with
 * sum greater than the given value.
 * 
 * Examples: arr[] = {1, 4, 45, 6, 0, 19} x = 51 Output: 3 Minimum length
 * subarray is {4, 45, 6}
 * 
 * arr[] = {1, 10, 5, 2, 7} x = 9 Output: 1 Minimum length subarray is {10}
 * 
 * arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250} x = 280 Output: 4 Minimum
 * length subarray is {100, 1, 0, 200}
 * 
 * arr[] = {1, 2, 4} x = 8 Output : Not Possible Whole array sum is smaller than
 * 8.
 * 
 * @author mbansiwal
 *
 */
public class SmallestSubarrayWithSumGreaterThanGivenValue
{
	// Returns length of smallest subarray with sum greater than x.
	// If there is no subarray with given sum, then returns n+1
	static int smallestSubWithSum(int arr[], int n, int x)
	{
		// Initilize length of smallest subarray as n+1
		int min_len = n + 1;

		// Pick every element as starting point
		for (int start = 0; start < n; start++)
		{
			// Initialize sum starting with current start
			int curr_sum = arr[start];

			// If first element itself is greater
			if (curr_sum > x)
				return 1;

			// Try different ending points for curremt start
			for (int end = start + 1; end < n; end++)
			{
				// add last element to current sum
				curr_sum += arr[end];

				// If sum becomes more than x and length of
				// this subarray is smaller than current smallest
				// length, update the smallest length (or result)
				if (curr_sum > x && (end - start + 1) < min_len)
					min_len = (end - start + 1);
			}
		}
		return min_len;
	}

	static int smallestSubWithSum2(int arr[], int n, int x)
	{
		int currentSum = 0;
		int minLength = n + 1;
		int start = 0;
		int end = 0;
		while (end < n)
		{
			while (end < n && currentSum <= x)
			{
				if (currentSum <= 0 && x > 0)
				{
					start = end;
					currentSum = 0;
				}
				currentSum += arr[end++];
			}

			while (currentSum > x && start < n)
			{
				if (minLength > (end - start))
				{
					minLength = end - start;
				}
				currentSum -= arr[start++];
			}
		}

		return minLength;
	}

	static int smallestSubWithSum3(int arr[], int n, int x)
	{
		// Initialize current
		// sum and minimum length
		int curr_sum = 0, min_len = n + 1;

		// Initialize starting
		// and ending indexes
		int start = 0, end = 0;
		while (end < n)
		{
			// Keep adding array
			// elements while current
			// sum is smaller than x
			while (curr_sum <= x && end < n)
			{
				// Ignore subarrays with
				// negative sum if x is
				// positive.
				if (curr_sum <= 0 && x > 0)
				{
					start = end;
					curr_sum = 0;
				}

				curr_sum += arr[end++];
			}

			// If current sum becomes
			// greater than x.
			while (curr_sum > x && start < n)
			{
				// Update minimum
				// length if needed
				if (end - start < min_len)
					min_len = end - start;

				// remove starting elements
				curr_sum -= arr[start++];
			}
		}
		return min_len;
	}
	// Driver program to test above functions
	public static void main(String[] args)
	{
		int arr3[] =
		{
				1, 11, 100, 1, 0, 200, 3, 2, 1, 250
		};
		int n3 = arr3.length;
		int x = 280;
		int res3 = smallestSubWithSum2(arr3, n3, x);
		if (res3 == n3 + 1)
			System.out.println("Not Possible");
		else
			System.out.println(res3);

		int arr1[] =
		{
				3, 4, 45, 7, 10, 19
		};
		x = 51;
		int n1 = arr1.length;
		int res1 = smallestSubWithSum2(arr1, n1, x);
		if (res1 == n1 + 1)
			System.out.println("Not Possible");
		else
			System.out.println(res1);

		int arr2[] =
		{
				1, 10, 5, 2, 7
		};
		int n2 = arr2.length;
		x = 9;
		int res2 = smallestSubWithSum2(arr2, n2, x);
		if (res2 == n2 + 1)
			System.out.println("Not Possible");
		else
			System.out.println(res2);


	}
}
