package dp.matrix;

/**
 * https://www.geeksforgeeks.org/number-of-paths-with-exactly-k-coins/
 * 
 * Given a matrix where every cell has some number of coins. Count number of ways to reach bottom right from top left 
 * with exactly k coins. We can move to (i+1, j) and (i, j+1) from a cell (i, j).

Example: 

Input:  k = 12
        mat[][] = { {1, 2, 3},
                    {4, 6, 5},
                    {3, 2, 1}
                  };
Output:  2
There are two paths with 12 coins
1 -> 2 -> 6 -> 2 -> 1
1 -> 2 -> 3 -> 5 -> 1

 */
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
