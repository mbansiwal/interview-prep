package dp;

public class BalloonBurst
{
	public int maxCoins(int[] nums)
	{
		int n = nums.length;
		if (n == 0)
		{
			return 0;
		}
		int[][] table = new int[n][n];
		for (int l = 1; l <= n; l++)
		{
			for (int i = 0; i < n - l + 1; i++)
			{
				int j = i + l - 1;

				int left = i > 0 ? nums[i - 1] : 1;
				int right = j < n - 1 ? nums[j + 1] : 1;

				for (int pivot = i; pivot <= j; pivot++)
				{
					int before = 0;
					int end = 0;
					if (i != pivot)
					{
						before = table[i][pivot - 1];
					}
					if (j != pivot)
					{
						end = table[pivot + 1][j];
					}

					table[i][j] = Math.max(table[i][j], before + (left * nums[pivot] * right) + end);
				}
			}

		}
		return table[0][n - 1];
	}

	public static void main(String args[])
	{
		BalloonBurst bb = new BalloonBurst();
		int input[] =
		{
				3, 1, 5, 8
		};
		System.out.print(bb.maxCoins(input));
	}
}
