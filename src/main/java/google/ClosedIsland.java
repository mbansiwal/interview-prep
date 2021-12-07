package google;

/**
 * https://leetcode.com/problems/number-of-closed-islands/
 * 
 * Given a 2D grid consists of 0s (land) and 1s (water). An island is a maximal
 * 4-directionally connected group of 0s and a closed island is an island
 * totally (all left, top, right, bottom) surrounded by 1s.
 * 
 * Return the number of closed islands.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: grid =
 * [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2 Explanation: Islands in gray are closed because they are completely
 * surrounded by water (group of 1s). Example 2:
 * 
 * 
 * 
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]] Output: 1 Example 3:
 * 
 * Input: grid = [[1,1,1,1,1,1,1], [1,0,0,0,0,0,1], [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1], [1,0,1,1,1,0,1], [1,0,0,0,0,0,1], [1,1,1,1,1,1,1]] Output: 2
 * 
 * @author Administrator
 *
 */
public class ClosedIsland {
	int[][] arr;

	public int closedIsland(int[][] grid) {
		this.arr = grid;
		int numberOfIslands = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					continue;
				}
				numberOfIslands += getIsland(i, j);
			}
		}
		return numberOfIslands;
	}

	public int getIsland(int x, int y) {
		if (x >= arr.length || x < 0)
			return 0;
		if (y >= arr[0].length || y < 0)
			return 0;
		if (arr[x][y] == 1) {
			return 1;
		}

		arr[x][y] = 1;

		// to check if all surroundings are 1 and not overflowing
		if (getIsland(x + 1, y) + getIsland(x - 1, y) + getIsland(x, y + 1) + getIsland(x, y - 1) == 4) {
			return 1;
		}
		return 0;
	}
}
