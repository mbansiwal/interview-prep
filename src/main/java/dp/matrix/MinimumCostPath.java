package dp.matrix;

public class MinimumCostPath {
	/* A utility function that returns minimum of 3 integers */
    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }
 
    private static int minCost(int cost[][], int m, int n)
    {
        int i, j;
        int tc[][]=new int[m+1][n+1];
 
        tc[0][0] = cost[0][0];
 
        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];
 
        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];
 
        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = min(tc[i-1][j-1], 
                               tc[i-1][j],
                               tc[i][j-1]) + cost[i][j];
 
        return tc[m][n];
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        System.out.println("minimum cost to reach (2,2) = " +
                                         minCost3(cost,2,2));
        
        System.out.println("minimum cost via recursion to reach (2,2) = " +
        		minCostRecursion(cost,2,2));
    }
    
    static int minCostRecursion(int cost[][], int m, int n)
    {
       if (n < 0 || m < 0)
          return Integer.MAX_VALUE;
       else if (m == 0 && n == 0)
          return cost[m][n];
       else
          return cost[m][n] + min( minCost(cost, m-1, n-1),
                                   minCost(cost, m-1, n), 
                                   minCost(cost, m, n-1) );
    }
    
    private static int minCost2(int cost[][], int m, int n)
    {
    	int[][] table = new int[m+1][n+1];
    	table[0][0] = cost[0][0];
    	
    	for (int i = 1; i <= m; i++) 
    	{
			table[i][0] = table[i-1][0] + cost[i][0];
		}
    	
    	for (int j = 1; j <= m; j++) 
    	{
			table[0][j] = table[0][j-1] + cost[0][j];
		}
    	
    	for (int i = 1; i <= m; i++) {
    		for (int j = 1; j <= n; j++) {
    			table[i][j] = Math.min(table[i-1][j-1],Math.min(table[i][j-1],table[i-1][j] )) + cost[i][j];
    		}
		}
    	
    	return table[m][n];
    }
    
    private static int minCost3(int cost[][], int m, int n)
    {
    	int[][] T = new int[m+1][n+1];
    	T[0][0] = cost[0][0];
    	 
    	for (int i = 1; i <= m; i++) {
			T[i][0] = T[i-1][0] + cost[i][0];
		}
    	for (int j = 1; j <= n; j++) {
			T[0][j] = T[0][j-1] + cost[0][j];
		}
    	for (int i = 1; i <= m; i++) 
    	{
    		for (int j = 1; j <= n; j++) 
			{
				T[i][j] = cost[i][j] + Math.min(T[i-1][j-1],Math.min(T[i][j-1], T[i-1][j]));
			}
		}
    	return T[m][n];
    }
}
