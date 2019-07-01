package dp.matrix;

import java.util.Arrays;

/**
 * Given a matrix of integers where every element represents weight of the cell.
 * Find the path having the maximum weight in matrix [N X N]. Path Traversal
 * Rules are:
 * 
 * It should begin from top left element. The path can end at any element of
 * last row. We can move to following two cells from a cell (i, j). Down Move :
 * (i+1, j) Diagonal Move : (i+1, j+1) Examples:
 * 
 * Input : N = 5 mat[5][5] = { { 4, 1, 3 ,4 ,1 }, { 2, 9, 1 ,10 ,5 }, {15, 1, 3,
 * 0 ,20 }, {16, 92, 41, 44 ,1}, {8, 142, 6, 4, 8} };
 * 
 * Output : 255 Path with max weight : 4 + 2 +15 + 92 + 142 = 255
 * 
 */
public class MaximumCostPath
{
	public static void maximumCost(int[][] matrix)
	{
		int n = matrix.length;
		int[][] table = new int[n][n];

		table[0][0] = matrix[0][0];
		for (int i = 1; i < n; i++)
		{
			table[i][0] = table[i - 1][0] + matrix[i][0];
		}

		for (int i = 1; i < n; i++)
		{
			for (int j = 1; j < i + 1; j++)
			{
				table[i][j] = matrix[i][j] + Math.max(table[i - 1][j], table[i - 1][j - 1]);
			}
		}
		System.out.println(Arrays.toString(table[n - 1]));
	}

	public static void main(String[] args)
	{
		int mat[][] =
		{
				{
						4, 2, 3, 4, 1
				},
				{
						2, 9, 1, 10, 5
				},
				{
						15, 1, 3, 0, 20
				},
				{
						16, 92, 41, 44, 1
				},
				{
						8, 142, 6, 4, 8
				}
		};

		maximumCost(mat);

		int tri[][] =
		{
				{
						1, 0, 0
				},
				{
						4, 8, 0
				},
				{
						1, 5, 3
				}
		};

		maximumCost(tri);
	}
}
