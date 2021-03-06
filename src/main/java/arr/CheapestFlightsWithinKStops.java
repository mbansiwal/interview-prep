package arr;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops
 */
public class CheapestFlightsWithinKStops
{
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
	{
		int INF = Integer.MAX_VALUE;
		int[] minCost = new int[n];
		Arrays.fill(minCost, INF);
		minCost[src] = 0;
		int ans = minCost[dst];
		for (int i = 0; i <= K; i++)
		{
			int[] temp = new int[n];
			Arrays.fill(temp, INF);
			for (int[] flight : flights)
			{
				int sourceAirport = flight[0];
				int destinationAirport = flight[1];
				int costOfTransferFromSourceToDestination = flight[2];
				if (minCost[sourceAirport] != INF)
				{
					temp[destinationAirport] = Math.min(temp[destinationAirport], minCost[sourceAirport] + costOfTransferFromSourceToDestination);
				}
			}
			minCost = temp;
			ans = Math.min(ans, temp[dst]);
		}

		return ans == INF ? -1 : ans;
	}

	public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k)
	{
		int INF = 0x3F3F3F3F;
        int[] cost = new int[n];
        Arrays.fill(cost, INF);
        cost[src] = 0;
        int ans = cost[dst];
        for(int i = k; i >= 0; i--){
            int[] cur = new int[n];
            Arrays.fill(cur, INF);
            for(int[] flight : flights){
                cur[flight[1]] = Math.min(cur[flight[1]], cost[flight[0]] + flight[2]);
            }
            cost = cur;
            ans = Math.min(ans, cost[dst]);
			System.out.println(ans);
        }
        return ans == INF ? -1 : ans;
	}

	public static void main(String[] args)
	{
		int[][] flights = {
				{0,1,100},
				{1,2,100},
				{0,2,500}
				};
		System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(3, flights, 0, 2, 1));

		int[][] flights2 = {
				{0,1,100},
				{1,2,100},
				{2,3,50},
				{0,3,500}
		};
		System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(4, flights2, 0, 3, 2));
	}
}
