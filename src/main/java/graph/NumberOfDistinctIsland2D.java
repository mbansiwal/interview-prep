package graph;

import java.util.*;


/**
 * https://www.geeksforgeeks.org/find-the-number-of-distinct-islands-in-a-2d-matrix/
 *
 * Given a boolean 2D matrix. The task is to find the number of distinct islands where a group of
 * connected 1s (horizontally or vertically) forms an island.
 * Two islands are considered to be distinct if and only if one island is equal to another
 * (not rotated or reflected).
 *
 * Input: grid[][] =
 * {{1, 1, 0, 0, 0},
 * 1, 1, 0, 0, 0},
 * 0, 0, 0, 1, 1},
 * 0, 0, 0, 1, 1}}
 *
 * Output: 1
 * Island 1, 1 at the top left corner is same as island 1, 1 at the bottom right corner
 *
 * Input: grid[][] =
 * {{1, 1, 0, 1, 1},
 * 1, 0, 0, 0, 0},
 * 0, 0, 0, 0, 1},
 * 1, 1, 0, 1, 1}}
 *
 * Output: 3
 * Distinct islands in the example above are: 1, 1 at the top left corner; 1, 1 at the top right corner and 1 at the bottom right corner. We ignore the island 1, 1 at the bottom left corner since 1, 1 it is identical to the top right corner.
 */
public class NumberOfDistinctIsland2D {
    int[] dx = {0,1,-1,0};
    int[] dy = {1,0,0,-1};


    public static void main(String args[]) {
        NumberOfDistinctIsland2D nd = new NumberOfDistinctIsland2D();
        int[][] grid = { 
			        		{ 1, 1, 0, 1, 1 },
			                { 1, 0, 0, 0, 0 },
			                { 0, 0, 0, 0, 1 },
			                { 1, 1, 0, 1, 1 } 
                	   };

        System.out.println("Number of distinct islands is " + nd.countDistinctIslands(grid));

    }

    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            return 1;
        }

        @Override
        public boolean equals(Object obj) {
            Pair pair2 = (Pair)obj;
            return i == pair2.i && j == pair2.j;
        }
    }

    private int countDistinctIslands(int[][] grid) {
        Set<Set<Pair>> pairs = new HashSet<>();
        for (int i =0; i < grid.length; ++i){
            for (int j =0; j < grid[0].length; ++j){
                if(grid[i][j] == 1){
                    Set<Pair> sets = new HashSet<>();
                    merge(sets, grid, i, j, i, j);
                    pairs.add(sets);
                }
            }
        }

        return pairs.size();
    }

    private void merge(Set<Pair> pairs, int[][] grid, int x0, int y0, int i, int j){
        int rows = grid.length;
        int cols = grid[0].length;

        if(i >= 0 && i < rows &&  j >=0 && j < cols && grid[i][j] == 1){
            grid[i][j] *= -1;
            pairs.add(new Pair(i - x0, j - y0));
            for (int x = 0; x < dx.length; ++x){
                merge(pairs, grid, x0, y0, i + dx[x], j + dy[x]);
            }
        }
    }

}
