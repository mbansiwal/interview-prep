package arr;

import java.util.Arrays;

public class TrainStationShortestPath {
    // This function returns the smallest possible cost to
    // reach station N-1 from station 0.
    static int minCost(int cost[][], int destinationStation)
    {
        // dist[i] stores minimum cost to reach station i
        // from station 0.
        int minCost[] = new int[destinationStation];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[0] = 0;
      
        // Go through every station and check if using it
        // as an intermediate station gives better path
        for (int i=0; i < destinationStation; i++)
        {  
        	for (int j=i+1; j < destinationStation; j++)
        	{ 
        		minCost[j] = Math.min(minCost[i] + cost[i][j], minCost[j]);
        	}
        }
        return minCost[destinationStation-1];
    }

    static int minCost(int cost[][], int srcStation, int destinationStation)
    {
        // dist[i] stores minimum cost to reach station i
        // from station 0.
        int minCost[] = new int[destinationStation];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[srcStation] = 0;

        // Go through every station and check if using it
        // as an intermediate station gives better path
        for (int i=srcStation; i < destinationStation; i++)
        {
            for (int j=i+1; j < destinationStation; j++)
            {
                minCost[j] = Math.min(minCost[i] + cost[i][j], minCost[j]);
            }
        }
        return minCost[destinationStation-1];
    }
 
    public static void main(String args[])
    {
        int INF = Integer.MAX_VALUE;
        int cost[][] = { 
        			  {0, 15, 80, 90},
                      {INF, 0, 40, 50},
                      {INF, INF, 0, 5},
                      {INF, INF, INF, 0}
                    };
        int n = 4;
        System.out.println("The Minimum cost to reach station "+ n +
				" is " + minCost(cost, n));
        n = 3;
        System.out.println("The Minimum cost to reach station "+ n +
                " is " + minCost(cost, n));

        System.out.println("The Minimum cost to reach station from 1 to 3 is " +
                minCost(cost, 1, 3));
        System.out.println("The Minimum cost to reach station from 1 to 4 is " +
                minCost(cost, 1, 4));
    }
}
