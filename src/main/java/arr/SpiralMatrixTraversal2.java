package arr;

public class SpiralMatrixTraversal2
{
	public int[][] generateMatrix(int n)
	{
		if (n == 0)
		{
			return null;
		}
		int[][] matrix = new int[n][n];
		int r1 =0;
		int r2 = n - 1;
		int c1 = 0;
		int c2 = n - 1;
		int counter = 1;
		while (r1 <= r2 && c1 <= c2)
		{
			for (int c = c1; c <= c2; c++)
			{
				matrix[r1][c] = counter++;
			}

			for (int r = r1 + 1; r <= r2; r++)
			{
				matrix[r][c2] = counter++;
			}
			if (r1 < r2 && c1 < c2)
			{
				for (int c = c2 - 1; c > c1; c--)
				{
					matrix[r2][c] = counter++;
				}

				for (int r = r2; r > r1; r--)
				{
					matrix[r][c1] = counter++;
				}
			}
			r1++;
			r2--;
			c1++;
			c2--;
		}
		return matrix;
    }

	public static void main(String[] args)
	{
		int[][] matrix = new SpiralMatrixTraversal2().generateMatrix(3);
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix.length; j++)
			{
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}

	}
}
