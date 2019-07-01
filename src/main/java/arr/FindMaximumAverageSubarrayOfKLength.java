package arr;

public class FindMaximumAverageSubarrayOfKLength
{
	public static void main(String[] args)
	{
		int arr[] =
		{
				1, 12, -5, -6, 50, 3
		};
		int k = 4;
		int n = arr.length;
		System.out.println(
				"The maximum average subarray of " + "length " + k + " begins at index " + findMaxAverage(arr, n, k));
	}

	private static int findMaxAverage(int[] arr, int n, int k)
	{
		if (k > n || n ==0)
		{
			return -1;
		}

		int sum = arr[0];
		for (int i = 1; i < k; i++)
		{
			sum += arr[i];
		}
		int maxSum = sum;
		int maxEnd = k;
		for (int i = k; i < n; i++)
		{
			sum = sum + arr[i] - arr[i - k];
			if (sum > maxSum)
			{
				maxSum = sum;
				maxEnd = i;
			}
		}
		return maxEnd - k + 1;
	}
}
