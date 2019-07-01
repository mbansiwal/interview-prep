package dp.matrix;

public class NumberOfPathsWithExactlyKcoins
{
	public static int noOfPaths(int[][] matrix, int sum)
	{
		int[][][] table = new int[matrix.length][matrix[0].length][sum+1];
		return noOfPaths(table, matrix, matrix.length-1, matrix[0].length-1, sum);
	}
	public static int noOfPaths(int[][][] table, int[][] matrix, int row, int col, int sum)
	{
		if(row< 0 || col < 0) return 0;
		
		if(row == 0 && col == 0)
		{
			return matrix[row][col] == sum?1:0;
		}
		
		if(table[row][col][sum] != 0)
		{
			return table[row][col][sum];
		}
		table[row][col][sum] = noOfPaths(table,matrix, row-1, col, sum - matrix[row][col]) + 
				noOfPaths(table,matrix, row, col-1, sum - matrix[row][col]);
		
		return table[row][col][sum];
	}
	
	public static void main(String[] args)
	{
		int mat[][] = { 
				{1, 2, 3},
                {4, 6, 5},
                {3, 2, 1}
            };
		
		System.out.println(noOfPaths(mat, 12));
	}
}
