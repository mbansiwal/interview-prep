package google;

/**
 * https://leetcode.com/problems/range-sum-query-2d-mutable
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.

 * @author Administrator
 *
 */
public class NumMatrix {
	private int[][] matrix;
    private int[][] tree;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if (matrix.length == 0) return;
        tree = new int[matrix.length+1][matrix[0].length+1];
        for(int i=1; i <= matrix.length; ++i){
            for(int j=1; j <= matrix[0].length; ++j){
                updateTree(i, j, matrix[i-1][j-1]);
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int currentVal = sumRegion(row, col, row, col);
        updateTree(row+1, col+1, val - currentVal);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        row2++;
        col1++;
        col2++;
        return query(row2, col2) - query(row2, col1-1) - query(row1-1, col2) + query(row1-1, col1-1);
    }
    
    private int query(int row, int col){
       int sum = 0;
        for(int i=row; i > 0; i=parent(i)){
           for(int j =col; j > 0; j=parent(j)){
               sum += tree[i][j];
           }
       }
        return sum;
    }
    
    private void updateTree(int row, int col, int value){
        for(int i=row; i <= matrix.length; i=child(i)){
           for(int j =col; j <= matrix[0].length; j=child(j)){
               tree[i][j] += value;
           }
       }
    }
    
    private int child(int index){
        return index + (index & (-index));
    }
    
    private int parent(int index){
        return index - (index & (-index));
    }
}
