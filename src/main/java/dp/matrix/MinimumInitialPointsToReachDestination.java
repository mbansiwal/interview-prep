package dp.matrix;

public class MinimumInitialPointsToReachDestination
{
	public static void minimumStartingPoint(int[][] matrix)
	{
		int rows = matrix.length;
		int columns = matrix[0].length;
		
		int[][] table = new int[rows][columns];
		table[rows-1][columns-1] = matrix[rows-1][columns-1] > 0?matrix[rows-1][columns-1]: Math.abs(matrix[rows-1][columns-1])+1;
		
		int lastColumn = columns-1;
		for (int i = rows-2; i >=0; i--)
		{
			table[i][lastColumn] = Math.max(table[i+1][lastColumn] - matrix[i][lastColumn],1); 
		}
		
		int lastRow = rows-1;
		for (int j = columns-2; j >=0; j--)
		{
			table[lastRow][j] = Math.max(table[lastRow][j+1] - matrix[lastRow][j],1); 
		}
		
		for (int i = rows-2; i >=0; i--)
		{
			for (int j = columns-2; j >=0; j--)
			{
				int minimumPoints = Math.min(table[i][j+1], table[i+1][j]);
				table[i][j] = Math.max(minimumPoints - matrix[i][j],1);
			}
		}
		
		System.out.println(table[0][0]);
	}
	
	public static void main(String[] args)
	{
		int points[][] = 
			{ 	{-2,-3,3},
                {-5,-10,1},
                {10,30,-5}
            };
        minimumStartingPoint(points);        
	}
}
