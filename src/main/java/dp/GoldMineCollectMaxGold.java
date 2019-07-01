package dp;

/**
 * Given a gold mine of n*m dimensions. Each field in this mine contains a
 * positive integer which is the amount of gold in tons. Initially the miner is
 * at first column but can be at any row. He can move only (right->,right up
 * /,right down\) that is from a given cell, the miner can move to the cell
 * diagonally up towards the right or right or diagonally down toward"s the
 * right. Find out maximum amount of gold he can collect.
 * 
 * Examples:
 * 
 * Input : mat[][] = {{1, 3, 3}, {2, 1, 4}, {0, 6, 4}}; Output : 12
 * {(1,0)->(2,1)->(2,2)}
 * 
 * Input: mat[][] = { {1, 3, 1, 5}, {2, 2, 4, 1}, {5, 0, 2, 3}, {0, 6, 1, 2}};
 * Output : 16 (2,0) -> (1,1) -> (1,2) -> (0,3) OR (2,0) -> (3,1) -> (2,2) ->
 * (2,3)
 * 
 * Input : mat[][] = {{10, 33, 13, 15}, {22, 21, 04, 1}, {5, 0, 2, 3}, {0, 6,
 * 14, 2}}; Output : 83
 * 
 */
public class GoldMineCollectMaxGold
{
	public static void maximumCost(int[][] matrix)
	{
		int n = matrix.length;
		int[][] table = new int[n + 1][n + 1];

		for (int j = 1; j <= n; j++)
		{
			for (int i = 1; i <= n; i++)
			{
				int col = j - 1;
				int row = i - 1;
				table[i][j] = matrix[row][col]
						+ Math.max(i == n ? 0 : table[i + 1][j - 1], Math.max(table[i - 1][j - 1], table[i][j - 1]));
			}
		}

		int maxVal = table[1][n];
		for (int i = 2; i < table.length; i++)
		{
			maxVal = Math.max(maxVal, table[i][n]);
		}
		System.out.println(maxVal);
	}

	public static void main(String[] args)
	{
		int mat[][] =
		{
				{
						1, 3, 1, 5
				},
				{
						2, 2, 4, 1
				},
				{
						5, 0, 2, 3
				},
				{
						0, 6, 1, 2
				}
		};

		maximumCost(mat);
	}
}
