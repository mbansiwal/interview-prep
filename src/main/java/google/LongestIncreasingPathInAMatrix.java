package google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * 
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.

From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).

 

Example 1:


Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:


Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
Example 3:

Input: matrix = [[1]]
Output: 1
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 231 - 1

 * @author Administrator
 *
 */
public class LongestIncreasingPathInAMatrix {
	int[] dirX = {-1, 1, 0, 0};
	int[] dirY = {0, 0, -1, 1};
	public int longestIncreasingPath(int[][] matrix) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] outDegree = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				for (int dir = 0; dir < dirX.length; dir++) {
					int newRow = i + dirX[dir];
					int newCol = j + dirY[dir];
					if(isValid(rows, columns, newRow, newCol) && matrix[newRow][newCol] > matrix[i][j]) {
						outDegree[i][j]++;
					}
				}
			}
		}
        
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(outDegree[i][j] == 0) {
					queue.add(new int[] {i,j});
				}
			}
		}
		
        int level = 0;
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
				int[] elements = queue.poll();
				for (int dir = 0; dir < dirX.length; dir++) {
					int newRow = elements[0] + dirX[dir];
					int newCol = elements[1] + dirY[dir];
					if(isValid(rows, columns, newRow, newCol) && matrix[newRow][newCol] < matrix[elements[0]][elements[1]]) {
						outDegree[newRow][newCol]--;
						if(outDegree[newRow][newCol] == 0) {
							queue.add(new int[] {newRow, newCol});
						}
					}
				}
			}
        	level++;
        }
        return level;
    }
	
	private boolean isValid(int rows, int cols, int row, int col) {
		return row >=0 && row < rows && col >=0 && col < cols;
	}
}
