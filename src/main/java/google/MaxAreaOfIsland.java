package google;

/**
 * https://leetcode.com/problems/max-area-of-island/
 * 
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:

[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50
 * @author Administrator
 *
 */

class Area{
    int sum=0;
}
public class MaxAreaOfIsland {
	int[] dx = {0, 0,  1, -1};
    int[] dy = {1, -1, 0, 0};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0; i < grid.length; ++i){
            for(int j=0; j < grid[0].length; ++j){
                if(grid[i][j] == 1){
                    Area count = new Area();
                    merge(grid, i, j, count);
                    max = Math.max(max, count.sum);
                }
            }
        }
        return max;
    }
    
    private void merge(int[][] grid, int row, int col, Area area){
        if(row >= 0 && row < grid.length
          && col >=0 && col < grid[0].length && grid[row][col] == 1){
            area.sum++;
            grid[row][col] = -1;
            for(int i=0; i < 4; ++i){
                merge(grid, row + dx[i], col + dy[i], area);
            }
        }
    }
}
