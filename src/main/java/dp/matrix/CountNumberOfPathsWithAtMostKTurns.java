package dp.matrix;

/**
 * Given a “m x n” matrix, count number of paths to reach bottom right from top
 * left with maximum k turns allowed.
 * 
 * What is a turn? A movement is considered turn, if we were moving along row
 * and now move along column. OR we were moving along column and now move along
 * row.
 * 
 * There are two possible scenarios when a turn can occur at point (i, j):
 * 
 * Turns Right: (i-1, j) -> (i, j) -> (i, j+1) Down Right
 * 
 * Turns Down: (i, j-1) -> (i, j) -> (i+1, j) Right Down Examples:
 * 
 * Input: m = 3, n = 3, k = 2 Output: 4 See below diagram for four paths with
 * maximum 2 turns.
 * 
 * Input: m = 3, n = 3, k = 1 Output: 2
 * 
 * 
 * @author mbansiwal
 *
 */
public class CountNumberOfPathsWithAtMostKTurns {
	static final int ROW_DIR = 0;
	static final int COLUMN_DIR = 1;

	public static void countPaths(int row, int column, int k) {
		int[][][][] table = new int[row + 1][column + 1][k + 1][2];

		int paths = countPathsUtil(table, ROW_DIR, row, column - 1, k)
				+ countPathsUtil(table, COLUMN_DIR, row - 1, column, k);
		System.out.println(paths);
	}

	public static int countPathsUtil(int[][][][] table, int direction, int row, int column, int k) {
		if (row < 0 || column < 0) {
			return 0;
		}
		if (row == 0 && column == 0) {
			return 1;
		}
		if (k == 0) {
			if (direction == ROW_DIR && row == 0) {
				return 1;
			}
			if (direction == COLUMN_DIR && column == 0) {
				return 1;
			}
			return 0;
		}

		if (table[row][column][k][direction] != 0) {
			return table[row][column][k][direction];
		}

		if (direction == ROW_DIR) {
			table[row][column][k][direction] = countPathsUtil(table, direction, row, column - 1, k)
					+ countPathsUtil(table, COLUMN_DIR, row - 1, column, k - 1);
		} else if (direction == COLUMN_DIR) {
			table[row][column][k][direction] = countPathsUtil(table, direction, row - 1, column, k)
					+ countPathsUtil(table, ROW_DIR, row, column - 1, k - 1);
		}
		return table[row][column][k][direction];
	}

	public static void main(String[] args) {
		int row = 3, column = 3, k = 2;
		countPaths(row - 1, column - 1, k);
	}
}
