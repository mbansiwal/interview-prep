package graph;

import java.util.Arrays;

/**
 * LeetCode – Paint House (Java)
 * 
 * There are a row of n houses, each house can be painted with one of the three
 * colors: red, blue or green. The cost of painting each house with a certain
 * color is different. You have to paint all the houses such that no two
 * adjacent houses have the same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color red; costs[1][2] is the cost of painting house 1 with color green, and
 * so on... Find the minimum cost to paint all houses.
 * 
 * https://www.programcreek.com/2014/05/leetcode-paint-house-java/
 * 
 * @author mbbansiw
 *
 */
public class PaintHouse {
	public int minCost(int[][] costs) {
		for (int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]); 
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
		}
		
		int m = costs.length - 1;
		return Math.min(costs[m][0], Math.min(costs[m][1], costs[m][2]));
	}
	
	public int minCost2(int[][] costs) {
		int m = costs.length;
		int n = costs[0].length;
		int previousIndex = -1;
		int previousMin = 0;
		int previousSecond = 0;
		for (int i = 0; i < m; i++) {
			int currentIndex = -1;
			int currentMin = Integer.MAX_VALUE;
			int currentSecond = Integer.MAX_VALUE;
			
			for (int j = 0; j < n; j++) {
				if(previousIndex == j) {
					costs[i][j] += previousSecond;
				} else {
					costs[i][j] += previousMin;
				}
				
				if(currentMin > costs[i][j]) {
					currentSecond = currentMin;
					currentMin = costs[i][j];
					currentIndex = j;
				} else if(currentSecond > costs[i][j] ) {
					currentSecond = costs[i][j];
				}
				
			}
			previousMin = currentMin;
			previousSecond = currentSecond;
			previousIndex = currentIndex;
		}
		
		return Arrays.stream(costs[costs.length - 1]).min().getAsInt();
	}
	public static void main(String[] args) {
		int[][] costs = {
				{2,1, 3},
				{5,1, 6},
				{7,8, 9}
		};
		
		System.out.println(new PaintHouse().minCost(costs));
		
		int[][] costs2 = {
				{2,1, 3},
				{5,1, 6},
				{7,8, 9}
		};
		System.out.println(new PaintHouse().minCost2(costs2));
	}
}
