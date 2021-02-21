package google;

/**
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 * 
 * Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
Example:
Input:
[[0,1,1,0],
 [0,1,1,0],
 [0,0,0,1]]
Output: 3
 * 
 * @author Administrator
 *
 */
public class LongestLine {
	public int longestLine(int[][] matrix) {
        int ROWS = matrix.length;
        if(ROWS == 0){
            return 0;
        }
        int COLS = matrix[0].length;
        int[][][] dp = new int[ROWS][COLS][4];
        int ones = 0;
        for(int i=0; i < ROWS; ++i){
            for(int j=0; j < COLS; ++j){
                if(matrix[i][j] == 1){
                    dp[i][j][0] = ( j > 0) ? dp[i][j-1][0] + 1:1;
                    dp[i][j][1] = ( i > 0) ? dp[i-1][j][1] + 1:1;
                    dp[i][j][2] = ( i > 0 && j > 0) ? dp[i-1][j-1][2] + 1:1;
                    dp[i][j][3] = ( i > 0 && j < COLS-1) ? dp[i-1][j+1][3] + 1:1;
                    ones = Math.max(ones, Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
                }
            }
        }
        return ones;
    }
}
