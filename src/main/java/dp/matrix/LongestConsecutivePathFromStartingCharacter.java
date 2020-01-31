package dp.matrix;

/**
 * http://www.geeksforgeeks.org/find-length-of-the-longest-consecutive-path-in-a
 * -character-matrix/
 * 
 * Find length of the longest consecutive path from a given starting character
 * Given a matrix of characters. Find length of the longest path from a given
 * character, such that all characters in the path are consecutive to each
 * other, i.e., every character in path is next to previous in alphabetical
 * order. It is allowed to move in all 8 directions from a cell.
 * 
 * matrix
 * 
 * Example
 * 
 * Input: mat[][] = { 
 * 						{a, c, d}, 
 * 						{h, b, e}, 
 * 						{i, g, f}} 
 * Starting Point = 'e'
 * 
 * Output: 5 If starting point is 'e', then longest path with consecutive
 * characters is "e f g h i".
 * 
 * Input: mat[R][C] = { {b, e, f}, {h, d, a}, {i, c, a}}; Starting Point = 'b'
 * 
 * Output: 1 'c' is not present in all adjacent cells of 'b'
 * 
 * 
 * @author mbansiwal
 *
 */
public class LongestConsecutivePathFromStartingCharacter
{
	// tool matrices to recur for adjacent cells.
	static int x[] =
	{
			0, 1, 1, -1, 1, 0, -1, -1
	};
	static int y[] =
	{
			1, 0, 1, 1, -1, -1, 0, -1
	};
	static int R = 3;
	static int C = 3;
	// dp[i][j] Stores length of longest consecutive path
	// starting at arr[i][j].
	static int dp[][] = new int[R][C];

	// check whether mat[i][j] is a valid cell or not.
	static boolean isvalid(int i, int j)
	{
		if (i < 0 || j < 0 || i >= R || j >= C)
			return false;
		return true;
	}

	// Check whether current character is adjacent to previous
	// character (character processed in parent call) or not.
	static boolean isadjacent(char prev, char curr)
	{
		return ((curr - prev) == 1);
	}

	// i, j are the indices of the current cell and prev is the
	// character processed in the parent call.. also mat[i][j]
	// is our current character.
	static int getLenUtil(char mat[][], int i, int j, char prev)
	{
		// If this cell is not valid or current character is not
		// adjacent to previous one (e.g. d is not adjacent to b )
		// or if this cell is already included in the path than return 0.
		if (!isvalid(i, j) || !isadjacent(prev, mat[i][j]))
			return 0;

		// If this subproblem is already solved , return the answer
		if (dp[i][j] != -1)
			return dp[i][j];

		int ans = 0; // Initialize answer

		// recur for paths with differnt adjacent cells and store
		// the length of longest path.
		for (int k = 0; k < 8; k++)
		{
			ans = Math.max(ans, 1 + getLenUtil(mat, i + x[k], j + y[k], mat[i][j]));
		}

		// save the answer and return
		return dp[i][j] = ans;
	}

	// Returns length of the longest path with all characters consecutive
	// to each other. This function first initializes dp array that
	// is used to store results of subproblems, then it calls
	// recursive DFS based function getLenUtil() to find max length path
	static int getLen(char mat[][], char s)
	{
		// assigning all dp values to -1
		for (int i = 0; i < R; ++i)
			for (int j = 0; j < C; ++j)
				dp[i][j] = -1;

		int ans = 0;

		for (int i = 0; i < R; i++)
		{
			for (int j = 0; j < C; j++)
			{
				// check for each possible starting point
				if (mat[i][j] == s)
				{

					// recur for all eight adjacent cells
					for (int k = 0; k < 8; k++)
						ans = Math.max(ans, 1 + getLenUtil(mat, i + x[k], j + y[k], s));
				}
			}
		}
		return ans;
	}

	public static void main(String args[])
	{
		char mat[][] =
		{
				{
						'a', 'c', 'd'
				},
				{
						'h', 'b', 'a'
				},
				{
						'i', 'g', 'f'
				}
		};

		System.out.println(getLen(mat, 'a'));
		System.out.println(getLen(mat, 'e'));
		System.out.println(getLen(mat, 'b'));
		System.out.println(getLen(mat, 'f'));
		System.out.println(getLen(mat, 'i'));
	}
}
