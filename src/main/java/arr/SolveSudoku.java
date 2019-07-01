package arr;

public class SolveSudoku
{
	public boolean solveSudoku(char[][] board)
	{
		if (board == null || board.length == '.')
		{
			return false;
		}

		return solve(board);
	}

	public boolean solve(char[][] matrix)
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[0].length; j++)
			{
				if (matrix[i][j] == '.')
				{
					for (char k = '1'; k <= '9'; k++)
					{
						if (isValid(matrix, i, j, k))
						{
							matrix[i][j] = k;
							if (solve(matrix))
							{
								return true;
							} else
							{
								matrix[i][j] = '.';
							}
						}
							
					}
					return false;
				}
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char c)
	{
		for (int i = 0; i < 9; i++)
		{
			int newRow = 3 * (row / 3) + i / 3;
			int newCol = 3 * (col / 3) + i % 3;
			if (board[row][i] == c)
			{
				return false;
			}
			if (board[i][col] == c)
			{
				return false;
			}
			if (board[newRow][newCol] == c)
			{
				return false;
			}
		}
		return true;
	}

	private boolean isValid2(char[][] board, int row, int col, char c)
	{
		for (int i = 0; i < 9; i++)
		{
			if (board[i][col] == c)
				return false; // check row
			if (board[row][i] == c)
				return false; // check column
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
				return false; // check 3*3 block
		}
		return true;
	}

	public static void main(String[] args)
	{
		char[][] matrix = new char[][]
		{
				{
						'3', '.', '6', '5', '.', '8', '4', '.', '.'
				},
				{
						'5', '2', '.', '.', '.', '.', '.', '.', '.'
				},
				{
						'.', '8', '7', '.', '.', '.', '.', '3', '1'
				},
				{
						'.', '.', '3', '.', '1', '.', '.', '8', '.'
				},
				{
						'9', '.', '.', '8', '6', '3', '.', '.', '5'
				},
				{
						'.', '5', '.', '.', '9', '.', '6', '.', '.'
				},
				{
						'1', '3', '.', '.', '.', '.', '2', '5', '.'
				},
				{
						'.', '.', '.', '.', '.', '.', '.', '7', '4'
				},
				{
						'.', '.', '5', '2', '.', '6', '3', '.', '.'
				}
		};

		System.out.println(new SolveSudoku().solve(matrix));
		System.out.println(matrix);
	}
}
