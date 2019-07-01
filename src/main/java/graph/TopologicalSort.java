package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologicalSort
{
	static class Graph
	{
		List<Integer>[] vertexArray;
		Map<Integer, Boolean> visitorMap = new HashMap<>();
		Stack<Integer> stack = new Stack<>();

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
			stack.push(vertex);
		}

		private boolean isVisited(int vertex)
		{
			return visitorMap.getOrDefault(vertex, false);
		}

		public void sort()
		{
			for (int vertex = 0; vertex < vertexArray.length; vertex++)
			{
				if (!isVisited(vertex))
				{
					dfsUtil(vertex);
				}
			}

			while (!stack.isEmpty())
			{
				System.out.print(stack.pop() + ",");
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
// 4 5 2 0 3 1