package graph;

/**
 * Each element is visited once only. So time is O(m*n)
 */
public class NumberOfIsland {
    private int[] dx = {0,0,-1,1};
    private int[] dy = {-1,1,0,0};

    public int numIslands(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for (int row=0; row<rows; ++row){
            for (int col=0; col<cols; ++col){
                if(grid[row][col] == 1){
                    count++;
                    merge(row, col, grid);
                }
            }
        }
        return count;
    }

    private void merge(int row, int col, int[][] grid){
        if(row >=0 && row < grid.length && col>=0 && col < grid[0].length &&
            grid[row][col] == 1){

            grid[row][col] = -1;

            for (int i = 0; i < dx.length; ++i){
                merge(row + dx[i], col + dy[i], grid);
            }

        }
        return;
    }

    public static void main(String args[]){

        int matrix[][] = {
                {1,1,0,1,0},
                {1,0,0,1,1},
                {0,0,0,0,0},
                {1,0,1,0,1},
                {1,0,0,0,0}
        };
        NumberOfIsland island = new NumberOfIsland();
        int count = island.numIslands(matrix);
        System.out.println(count);
    }
}
