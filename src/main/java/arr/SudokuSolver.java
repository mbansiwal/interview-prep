package arr;

public class SudokuSolver
{
	public void solveSudoku(char[][] board)
	{
		if (board == null || board.length == 0)
		{
			return;
		}
		solve(board);
	}

	public boolean solve(char[][] board)
	{
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] == '.')
				{
					for (char c = '0'; c <= '9'; c++)
					{
						if (isValid(board, i, j, c))
						{
							board[i][j] = c;
							if (solve(board))
							{
								return true;
							} else
							{
								board[i][j] = '.';
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
		for (int k = 0; k < board.length; k++)
		{
			if (board[k][col] != '.' && board[k][col] == c)
			{
				return false;
			}
			if (board[row][k] != '.' && board[row][k] == c)
			{
				return false;
			}
			if (board[3 * (row / 3) + k / 3][3 * (col / 3) + k % 3] != '.'
					&& board[3 * (row / 3) + k / 3][3 * (col / 3) + k % 3] == c)
			{
				return false;
			}
		}
		return true;
	}
}
