package dp.matrix;

/**
 * Given a character matrix where every cell has one of the following values.

'C' -->  This cell has coin

'#' -->  This cell is a blocking cell. 
         We can not go anywhere from this.

'E' -->  This cell is empty. We don't get
         a coin, but we can move from here.  
Initial position is cell (0, 0) and initial direction is right.

Following are rules for movements across cells.

If face is Right, then we can move to below cells

Move one step ahead, i.e., cell (i, j+1) and direction remains right.
Move one step down and face left, i.e., cell (i+1, j) and direction becomes left.
If face is Left, then we can move to below cells

Move one step ahead, i.e., cell (i, j-1) and direction remains left.
Move one step down and face right, i.e., cell (i+1, j) and direction becomes right.
Final position can be anywhere and final direction can also be anything. The target is to collect maximum coins.

http://www.geeksforgeeks.org/collect-maximum-coins-before-hitting-a-dead-end/
 * @author mbansiwal
 *
 */
public class CollectMaximumCoinsBeforeHittingDeadEnd
{
	static int RIGHT_DIRECTION = 1;
	static int LEFT_DIRECTION = 0;
	
	public static int collectCoins(char[][] matrix)
	{
		int table[][][] = new int[matrix.length][matrix[0].length][2];
		return collectCoins(table, matrix, 0, 0, RIGHT_DIRECTION);
	}
	
	public static int collectCoins(int table[][][], char[][] matrix, int row, int column, int direction)
	{
		if(row<0 || column <0 || row >= matrix.length || column>= matrix[0].length || matrix[row][column] == '#')
		{
			return 0;
		}
		if(table[row][column][direction] != 0)
		{
			return table[row][column][direction];
		}
		
		table[row][column][direction] = matrix[row][column] == 'C' ? 1:0;
		if (direction == RIGHT_DIRECTION)
		{
			table[row][column][direction] += Math.max(collectCoins(table, matrix, row, 
					column+1, RIGHT_DIRECTION), collectCoins(table, matrix, row+1, column, LEFT_DIRECTION));
		}
		else
		{
			table[row][column][direction] += Math.max(collectCoins(table, matrix, row, column-1, LEFT_DIRECTION)
					, collectCoins(table, matrix, row+1, column, RIGHT_DIRECTION));
		}
		
		return table[row][column][direction];
	}
	
	public static void main(String[] args)
	{
		char matrix[][] = { 
				{'E', 'C', 'C', 'C', 'C'},
                {'C', '#', 'C', '#', 'E'},
                {'#', 'C', 'C', '#', 'C'},
                {'C', 'E', 'E', 'C', 'E'},
                {'C', 'E', '#', 'C', 'E'}
              };
		
		System.out.println(collectCoins(matrix));
	}
}
