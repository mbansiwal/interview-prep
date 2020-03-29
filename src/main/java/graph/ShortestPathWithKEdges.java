package graph;

public class ShortestPathWithKEdges
{
	// Define number of vertices in the graph and inifinite value
	static final int V = 4;
	static final int INF = Integer.MAX_VALUE;
	static int[][][] shortestPath;
	
	// A naive recursive function to count walks from u to v
	// with k edges
	int shortestPath(int graph[][], int u, int v, int k)
	{
		if(shortestPath[u][v][k] != 0)
		{
			return shortestPath[u][v][k];
		}
		// Base cases
		if (k == 0 && u == v)
		{
			return 0;
		}
		if (k == 1 && graph[u][v] != INF)
		{	
			shortestPath[u][v][k] = graph[u][v];
			return graph[u][v];
		}
		if (k <= 0)
		{
			shortestPath[u][v][0] = INF;
			return INF;
		}

		// Initialize result
		int res = INF;

		// Go to all adjacents of u and recur
		for (int i = 0; i < V; i++)
		{
			if (graph[u][i] != INF && u != i && v != i)
			{
				int iToVDistance = shortestPath(graph, i, v, k - 1);
				shortestPath[i][v][k] = iToVDistance;
				if (iToVDistance != INF)
				{
					res = Math.min(res, graph[u][i] + iToVDistance);
				}
			}
		}
		shortestPath[u][v][k] = res;
		return res;
	}

	public static void main(String[] args)
	{
		/* Let us create the graph shown in above diagram */
		int graph[][] = new int[][]
		{
				{
						0, 10, 3, 2
				},
				{
						INF, 0, INF, 7
				},
				{
						INF, INF, 0, 6
				},
				{
						INF, INF, INF, 0
				}
		};
		ShortestPathWithKEdges t = new ShortestPathWithKEdges();
		int u = 0, v = 3, k = 2;
		shortestPath = new int[V][V][k+1];
		System.out.println("Weight of the shortest path is " + t.shortestPath(graph, u, v, k));
	}
}
