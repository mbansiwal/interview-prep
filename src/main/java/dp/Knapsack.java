package dp;

import java.util.Arrays;

/**
 * Dynamic Programming | Set 10 ( 0-1 Knapsack Problem) Given weights and values
 * of n items, put these items in a knapsack of capacity W to get the maximum
 * total value in the knapsack. In other words, given two integer arrays
 * val[0..n-1] and wt[0..n-1] which represent values and weights associated with
 * n items respectively. Also given an integer W which represents knapsack
 * capacity, find out the maximum value subset of val[] such that sum of the
 * weights of this subset is smaller than or equal to W. You cannot break an
 * item, either pick the complete item, or don’t pick it (0-1 property).
 * 
 * @author mbansiwal
 *
 */
public class Knapsack {
	public static void main(String[] args) {
		int wts[] = {0,1,3,4,5};
		int val[] = {0,1,4,5,7};
		
		int maxWt = 7;
		int[][] table = new int[wts.length][maxWt+1];
		
		for (int row = 1; row < wts.length; row++) {
			for (int col = 1; col <= maxWt; col++) {
				if(col< wts[row])
				{
					table[row][col] = table[row-1][col];
				}
				else
				{
					table[row][col] = Math.max(val[row]+table[row-1][col-wts[row]],table[row-1][col]);
				}
			}
		}
		
		
		System.out.println(table[wts.length-1][maxWt]);
		
		int weights[] ={1,3,4,5};
		int values[] ={1,4,5,7};
		System.out.println(knapsack(values, weights, maxWt));
		
		System.out.println("New Optimal Solution ");
		knapsackOptimal(values, weights, maxWt);
		
		// int val2[] = {7, 8, 4}, wt2[] = {3, 8, 6}, W2 = 10;
		// knapsackOptimal(val2, wt2, W2);
		//
		// int val3[] = {20, 10, 4, 50, 100}, wt3[] = {1,2,3,4,5}, weight = 5;
		// knapsackMinimumCost(val3, wt3, weight);
		// System.out.println(knapsackMinimum(val3, wt3, weight));
	}
	
	
	private static int knapsack(int[] values, int wts[], int maxWt)
	{
		int m = wts.length;
		int[][] table = new int[m+1][maxWt+1];
		for (int i = 1; i <= m; i++) 
		{
			int wt = wts[i-1];
			int value = values[i-1];
			for (int j = wt; j <= maxWt; j++) 
			{
//				if(j < wt)
//				{
//					table[i][j] = table[i-1][j];
//				}
//				else
				{
					table[i][j] = Math.max(table[i-1][j], table[i-1][j-wt]+value);
				}
			}
		}
		System.out.println("My Solution");
		for (int[] vals : table) {
			for (int i : vals) {
				System.out.print(i+",");
			}
			System.out.println();
		}
		return table[m][maxWt];
	}
	
	private static void knapsackOptimal(int[] values, int wts[], int maxWt)
	{
		int[] table = new int[maxWt+1];
		
		for (int i = 0; i < wts.length; i++) 
		{
			int wt = wts[i];
			int value = values[i];
			for (int j = wt; j <= maxWt; j++)
			{
				if (j >= wt)
				{
					table[j] = Math.max(table[j], value+table[j-wt]);
				}
			}
			System.out.println(Arrays.toString(table));	
		}
		System.out.println(Arrays.toString(table));
		System.out.println(table[maxWt]);
	}
	
	private static void knapsackMinimumCost(int[] values, int wts[], int maxWt)
	{
		int[] table = new int[maxWt+1];
		
		// fill 0th row with infinity
	    for (int i=0; i<=maxWt; i++)
	    {
	    	table[i] = 100000;
	    }
	    table[0] = 0;
//	    // fill 0'th column with 0
//	    for (int i=1; i<=n; i++)
//	        min_cost[i][0] = 0;
	    
		for (int i = 0; i < wts.length; i++) 
		{
			int wt = wts[i];
			int value = values[i];
			for (int j = maxWt; j >= wt; j--) 
			{
				if(j >= wt)
				{
					table[j] = Math.min(table[j], value+table[j-wt]);
				}
			}
			System.out.println(Arrays.toString(table));	
		}
		System.out.println(Arrays.toString(table));
		System.out.println(table[maxWt]);
	}
	
	private static int knapsackMinimum(int[] values, int wts[], int maxWt)
	{
		int m = wts.length;
		int[][] table = new int[m+1][maxWt+1];
		
		for (int j=0; j<=maxWt; j++)
	    {
	    	table[0][j] = 100000;
	    }
	    table[0][0] = 0;
//	    // fill 0'th column with 0
//	    for (int i=1; i<=n; i++)
//	    {
//	    	min_cost[i][0] = 0;
//	    }
	    
		for (int i = 1; i <= m; i++) 
		{
			int wt = wts[i-1];
			int value = values[i-1];
			for (int j = 1; j <= maxWt; j++) 
			{
				if(j < wt)
				{
					table[i][j] = table[i-1][j];
				}
				else
				{
					table[i][j] = Math.min(table[i-1][j], table[i-1][j-wt]+value);
				}
			}
		}
		System.out.println("My Solution");
		for (int[] vals : table) {
			for (int i : vals) {
				System.out.print(i+",");
			}
			System.out.println();
		}
		return table[m][maxWt];
	}
}
