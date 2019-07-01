package arr;

public class GameOfLife
{
	private static final int ALIVE = 1;
	private static final int DEAD = 0;
	private static final int DEAD_TO_ALIVE = 2;
	private static final int ALIVE_TO_DEAD = 3;
	int directions[][] =
	{
			{
					0, 1
			},
			{
					0, -1
			},
			{
					-1, 0
			},
			{
					-1, -1
			},
			{
					-1, 1
			},
			{
					1, 0
			},
			{
					1, -1
			},
			{
					1, 1
			},

	};

	public void gameOfLife(int[][] board)
	{
		int rows = board.length;
		int columns = board[0].length;
		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				int aliveCells = aliveCells(i, j, board);
				if (board[i][j] == DEAD && aliveCells == 3)
				{
						board[i][j] = DEAD_TO_ALIVE;
				}

				if (board[i][j] == ALIVE && (aliveCells != 2 && aliveCells != 3))
				{
					board[i][j] = ALIVE_TO_DEAD;
				}
			}
		}

		for (int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				if (board[i][j] == DEAD_TO_ALIVE)
				{
					board[i][j] = ALIVE;
				}
				if (board[i][j] == ALIVE_TO_DEAD)
				{
					board[i][j] = DEAD;
				}
			}
		}

	}

	private int aliveCells(int i, int j, int[][] board)
	{
		int rows = board.length;
		int columns = board[0].length;
		int alive = 0;
		for (int k = 0; k < directions.length; k++)
		{
			int x = i + directions[k][0];
			int y = j + directions[k][1];

			if (x >= 0 && x < rows && y >= 0 && y < columns && (board[x][y] == ALIVE || board[x][y] == ALIVE_TO_DEAD))
			{
				alive += 1;
			}
		}
		return alive;
	}

}
