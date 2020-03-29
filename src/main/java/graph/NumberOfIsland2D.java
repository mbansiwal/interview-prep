package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * https://www.programcreek.com/2014/04/leetcode-number-of-islands-java/
 *
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position (row, col) into a land.
 * Given a list of positions to operate, count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Time complexity O(k*log(m*n)), where k is the length of the positions.
 */
public class NumberOfIsland2D {
    int[] dx = {0,1,-1,0};
    int[] dy = {1,0,0,-1};
    public List<Integer> numIslands(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int[] parents = new int[m*n];
        Arrays.fill(parents, -1);
        int count = 0;
        for (int[] position: positions){
            count++;

            int x = position[0];
            int y = position[1];

            int idx = x*n + y;

            if(parents[idx] == -1){
                parents[idx] = idx;
            }

            for(int k =0; k < dx.length; ++k){
                int x1 = x + dx[k];
                int y1 = y + dy[k];
                int idxNeighbour = n*x1 + y1;

                if(x1 >=0 && x1 < m && y1 >= 0 && y1 < n && parents[idxNeighbour] != -1){
                    int p = getParent(parents, idxNeighbour);
                    if(parents[p] != idx){
                        parents[p] = idx;
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private int getParent(int[] parents, int idx) {
        while(parents[idx] != idx){
             idx = parents[idx];
        }
        return idx;
    }

    public static void main(String args[]) {
        NumberOfIsland2D nd = new NumberOfIsland2D();
        int[][] input = {{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}};
        System.out.print(nd.numIslands(3, 3, input));
    }
}
