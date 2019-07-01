package arr;

import java.util.Arrays;

public class TrainStationShortestPath {
	static int INF = Integer.MAX_VALUE,N = 4;
    // A recursive function to find the shortest path from
    // source 's' to destination 'd'.
     
    // This function returns the smallest possible cost to
    // reach station N-1 from station 0.
    static int minCost(int cost[][])
    {
        // dist[i] stores minimum cost to reach station i
        // from station 0.
        int minCost[] = new int[N];
        for (int i=0; i<N; i++)
        {
        	minCost[i] = INF;
        }
        minCost[0] = 0;
      
        // Go through every station and check if using it
        // as an intermediate station gives better path
        for (int i=0; i<N; i++)
        {  
        	for (int j=i+1; j<N; j++)
        	{ 
        		minCost[j] = Math.min(minCost[i] + cost[i][j], minCost[j]);
        	}
        }
        System.out.println(Arrays.toString(minCost));
        return minCost[N-1];
    }
      
 
    public static void main(String args[])
    {
        int cost[][] = { 
        			  {0, 15, 80, 90},
                      {INF, 0, 40, 50},
                      {INF, INF, 0, 70},
                      {INF, INF, INF, 0}
                    };
        System.out.println("The Minimum cost to reach station "+ N+
				" is " + minCost(cost));
    }
}
