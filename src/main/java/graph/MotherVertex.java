package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MotherVertex
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

		private void dfsUtil(int vertex)
		{
			visitorMap.put(vertex, true);
			if (vertexArray[vertex] != null)
			{
				for (Integer edge : vertexArray[vertex])
				{
					if (!isVisited(edge))
					{
						dfsUtil(edge);
					}
				}
			}
		}

		private boolean isVisited(int vertex)
		{
			return visitorMap.getOrDefault(vertex, false);
		}
		public int findMother()
		{
			int v = 0;
			for (int vertex = 0; vertex < vertexArray.length; vertex++)
			{
				if (!isVisited(vertex))
				{
					dfsUtil(vertex);
					v = vertex;
				}
			}

			visitorMap.clear();
			dfsUtil(v);

			return visitorMap.containsValue(false) ? -1 : v;
		}
	}

	public static void main(String[] args)
	{
		Graph g = new Graph(7);
	    g.addEdge(0, 1); 
	    g.addEdge(0, 2); 
	    g.addEdge(1, 3); 
	    g.addEdge(4, 1); 
	    g.addEdge(6, 4); 
	    g.addEdge(5, 6); 
	    g.addEdge(5, 2); 
	    g.addEdge(6, 0); 
	  
		System.out.println("A mother vertex is " + g.findMother());
	}
}
