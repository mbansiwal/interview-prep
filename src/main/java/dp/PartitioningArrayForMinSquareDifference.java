package dp;

public class PartitioningArrayForMinSquareDifference
{
	static int minCost(int a[], int n, int k)
	{
		// Create a dp[][] table and initialize
		// all values as infinite. dp[i][j] is
		// going to store optimal partition cost
		// for arr[0..i-1] and j partitions
		int dp[][] = new int[n + 1][k + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= k; j++)
				dp[i][j] = 100000;

		// Fill dp[][] in bottom up manner
		dp[0][0] = 0;

		// Current ending position (After i-th
		// iteration result for a[0..i-1] is computed.
		for (int i = 1; i <= n; i++)
			
			// j is number of partitions
			for (int j = 1; j <= k; j++)

				// Picking previous partition for
				// current i.
				for (int m = i - 1; m >= 0; m--)
					dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + (a[i - 1] - a[m]) * (a[i - 1] - a[m]));

		return dp[n][k];
	}

	public static void main(String[] args)
	{
		int k = 2;
		int a[] =
		{
				1, 5, 8, 10
		};
		System.out.println(minCost(a, a.length, k));
	}
}
