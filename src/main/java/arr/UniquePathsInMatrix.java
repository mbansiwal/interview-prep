package arr;

public class UniquePathsInMatrix
{
	int targetX = 0;
	int targetY = 0;
	int R = 0;
	int C = 0;
	int[][] MOVES =
	{
			{
					0, 1
			},
			{
					1, 0
			},
			{
					0, -1
			},
			{
					-1, 0
			}
	};
	int ans = 0;

	public int uniquePathsIII(int[][] grid)
	{
		int srcX = 0;
		int srcY = 0;
		int toDo = 0;
		R = grid.length;
		C = grid[0].length;
		for (int i = 0; i < R; i++)
		{
			for (int j = 0; j < C; j++)
			{
				if (grid[i][j] == 2)
				{
					targetX = i;
					targetY = j;
				}
				if (grid[i][j] == 1)
				{
					srcX = i;
					srcY = j;
				}
				if (grid[i][j] != -1)
				{
					toDo++;
				}
			}
		}
		ans = 0;
		dfs(grid, srcX, srcY, toDo);
		return ans;
	}

	private void dfs(int[][] grid, int row, int col, int toDo)
	{
		--toDo;

		if (toDo < 0)
		{
			return;
		}
		if (row == targetX && col == targetY)
		{
			if (toDo == 0)
			{
				ans++;
			}
			return;
		}
		
		int temp = grid[row][col];
		grid[row][col] = 3;

		for (int i = 0; i < 4; i++)
		{
			int x = row + MOVES[i][0];
			int y = col + MOVES[i][1];
			if (x >= 0 && x < R && y >= 0 && y < C)
			{
				if (grid[x][y] % 2 == 0)
				{
					dfs(grid, x, y, toDo);
				}
			}
		}
		grid[row][col] = temp;
	}
	
	public static void main(String[] args)
	{
		int[][]grid = {
				{1,0,0,0},
				{0,0,0,0},
				{0,0,2,-1}
		};
		System.out.println(new UniquePathsInMatrix().uniquePathsIII(grid));

		int[][] grid2 =
		{
				{
						0, 1
				},
				{
						2, 0
				}
		};
		System.out.println(new UniquePathsInMatrix().uniquePathsIII(grid2));
		
		int[][] grid3 = {
				{1,0,0,0},{0,0,0,0},{0,0,0,2}
				};

		System.out.println(new UniquePathsInMatrix().uniquePathsIII(grid3));
	}
}

