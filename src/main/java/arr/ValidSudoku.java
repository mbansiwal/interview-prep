package arr;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku
{
	public boolean isValidSudoku(char[][] board)
	{
		Set<String> set = new HashSet<>();
		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				char number = board[i][j];
				if (number != '.')
				{
					if (!set.add("seen " + number + " in row " + i) || !set.add("seen " + number + " in column " + j)
							|| !set.add("seen " + number + " in box " + i / 3 + " - " + j / 3))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
}
