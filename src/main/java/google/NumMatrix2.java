package google;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/solution/
 * 
 * @author Administrator
 *
 */
public class NumMatrix2 {
    int[][] table;

    public NumMatrix2(int[][] matrix) {
        
        if(matrix.length == 0 || matrix[0].length == 0) {
          return;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        table = new int[rows+1][cols+1];
        for(int i=1; i <= rows; ++i){
            for(int j=1; j <= cols; ++j){
                table[i][j]= matrix[i-1][j-1] + table[i][j-1] + table[i-1][j] - table[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return table[row2][col2] - table[row2][col1-1] - table[row1-1][col2] + table[row1-1][col1-1];
    }
}
