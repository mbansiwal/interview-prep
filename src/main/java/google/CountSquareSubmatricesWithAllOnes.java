package google;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * 
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.

 * @author Administrator
 *
 */
public class CountSquareSubmatricesWithAllOnes {
	 public int countSquares(int[][] matrix) {
	    	if (matrix == null) return 0;
	    	
	    	int count = 0;
	    	for (int i=0; i<matrix.length; i++) {
	    		for (int j=0; j<matrix[i].length; j++) {
	    			if (matrix[i][j] == 0) {
	    				continue;
	    			}
	    			count++;
	    			count += countSubMax(matrix, i, j, i + 1, j + 1);
	    		}
	    	}
	    	return count;
	    }
	
	    public int countSubMax(int[][] matrix, int oRow, int oCol, int row, int col) {
	    	if (row >= matrix.length || col >= matrix[row].length) {
	    		return 0;
	    	}
	
	    	for (int i=row; i>=oRow; i--) {
	    		if (matrix[i][col] == 0) {
	    			return 0;
	    		}
	    	}
	    	
	    	for (int j=col; j>=oCol; j--) {
	    		if (matrix[row][j] == 0) {
	    			return 0;
	    		}
	    	}
	    	
	    	return 1 + countSubMax(matrix, oRow, oCol, row + 1, col + 1);
	    }
}
