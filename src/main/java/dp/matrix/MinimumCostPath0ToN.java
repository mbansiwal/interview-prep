package dp.matrix;

import java.util.Arrays;

public class MinimumCostPath0ToN {
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int cost[][]= 
        	   { 
	        		{4, 2, 3, 4},
	                {2, 9, 1, 10},
	                {15, 1, 3, 0},
	                {16, 92, 41, 44} 
                };
        System.out.println("max cost to reach (3,3) = " +
                                         minCost3(cost,4,4));
    }
    
    private static int minCost3(int cost[][], int m, int n)
    {
    	int[][] T = new int[m][n+2];
    	 
    	for (int j = 0; j < n; j++) 
    	{
			T[0][j+1] = cost[0][j];
		}
    	
    	for (int i = 1; i < m; i++) 
    	{
    		for (int j = 1; j <= n; j++)
			{
				T[i][j] = cost[i][j-1] + Math.max(T[i-1][j-1],Math.max(T[i-1][j], T[i-1][j+1]));
			}
    		System.out.println(Arrays.toString(T[i]));
		}
    	return T[m-1][n+1];
    }
}
