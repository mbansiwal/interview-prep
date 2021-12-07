package dp.matrix;

import java.util.Iterator;

/**
 * https://www.geeksforgeeks.org/minimum-positive-points-to-reach-destination/
 * 
 * Given a grid with each cell consisting of positive, negative or no points i.e, zero points. We can move across a cell only if we have positive points ( > 0 ). Whenever we pass through a cell, points in that cell are added to our overall points. We need to find minimum initial points to reach cell (m-1, n-1) from (0, 0).

From a cell (i, j) we can move to (i+1, j) or (i, j+1).
We cannot move from (i, j) if your overall points at (i, j) is <= 0.


 * @author Administrator
 *
 */
public class MinimumInitialPointsToReachDestination
{
	public static void minimumStartingPoint2(int[][] matrix)
	{
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] table = new int[rows][cols];
		
		table[rows-1][cols-1] = matrix[rows-1][cols-1] < 1 ? Math.abs(matrix[rows-1][cols-1])+1:matrix[rows-1][cols-1];
		
		for (int i = rows-2; i >=0; i--) {
			table[i][cols-1] = Math.max(table[i+1][cols-1]-matrix[i][cols-1], 1);
		}
		for (int j = cols-2; j >=0; j--) {
			table[rows-1][j] = Math.max(table[rows-1][j+1]-matrix[rows-1][j], 1);
		}
		for (int i = rows-2; i >=0; i--) {
			for (int j = cols-2; j >=0; j--) {
				int min = Math.min(table[i][j+1], table[i+1][j]);
				table[i][j] = Math.max(min-matrix[i][j], 1);
			}
		}
		System.out.println(table[0][0]);
	}
	
	
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
        minimumStartingPoint2(points);  
	}
}
