package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
public class TopologicalSortWithCycleCheck
{
	static class Graph
	{
		List<Integer>[] vertexArray;
		Map<Integer, Boolean> visitorMap = new HashMap<>();

		public Graph(int size)
		{
			vertexArray = new List[size];
		}

		public void addEdge(int vertex, int edge)
		{
			if (vertexArray[vertex] == null)
			{
				vertexArray[vertex] = new ArrayList<>();
			}
			vertexArray[vertex].add(edge);
		}

		public void sort()
		{
			int[] indegrees = new int[vertexArray.length];

			for (int vertex = 0; vertex < vertexArray.length; vertex++)
			{
				if (vertexArray[vertex] != null)
				{
					for (Integer edge : vertexArray[vertex])
					{
						indegrees[edge]++;
					}
				}
			}

			Queue<Integer> queue = new LinkedList<Integer>();
			for (int i = 0; i < vertexArray.length; i++)
			{
				if (indegrees[i] == 0)
				{
					queue.add(i);
				}
			}
			
			int totalCount = 0;
			List<Integer> topologicalOrder = new ArrayList<>();
			while (!queue.isEmpty())
			{
				int vertex = queue.poll();
				topologicalOrder.add(vertex);
				if (vertexArray[vertex] != null)
				{
					for (Integer edge : vertexArray[vertex])
					{
						indegrees[edge]--;
						if (indegrees[edge] == 0)
						{
							queue.add(edge);
						}
					}
				}
				
				totalCount++;
			}
			
			if(totalCount != vertexArray.length){
				throw new IllegalArgumentException("Cycle exist");
			}

			for (Integer vertex : topologicalOrder)
			{
				System.out.print(vertex + ",");
			}
		}
	}

	public static void main(String[] args)
	{
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);

		System.out.println("Following is a Topological " + "sort of the given graph");
		g.sort();
	}
}
