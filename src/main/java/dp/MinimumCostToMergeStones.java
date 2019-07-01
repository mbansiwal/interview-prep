package dp;

import java.util.Arrays;

public class MinimumCostToMergeStones
{
	public int mergeStones(int[] stones, int K)
	{
		int noOfStones = stones.length;
		if (!isValid(noOfStones, K))
		{
			return -1;
		}
		int[] presum = new int[noOfStones + 1];
		for (int i = 1; i <= noOfStones; i++)
		{
			presum[i] = presum[i - 1] + stones[i - 1];
		}
		int table[][] = new int[noOfStones][noOfStones];
		for (int i = 0; i < noOfStones; i++)
		{
			Arrays.fill(table[i], Integer.MAX_VALUE);
			table[i][i] = 0;
		}

		for (int l = 2; l <= noOfStones; l++)
		{
			for (int i = 0; i < noOfStones - l + 1; i++)
			{
				int j = i + l - 1;
				for (int pivot = i; pivot < j; pivot += (K - 1))
				{
					table[i][j] = Math.min(table[i][j], table[i][pivot] + table[pivot + 1][j]);
				}
				table[i][j] += (l - 1) % (K - 1) == 0 ? (presum[j + 1] - presum[i]) : 0;
			}
		}
		return table[0][noOfStones - 1];
	}

	private boolean isValid(int length, int partition)
	{
		return (length - 1) % (partition - 1) == 0;
	}

	public static void main(String[] args)
	{
		int[] stones =
		{
				3, 2, 4, 1
		};
		System.out.println(new MinimumCostToMergeStones().mergeStones(stones, 2));
	}
}
