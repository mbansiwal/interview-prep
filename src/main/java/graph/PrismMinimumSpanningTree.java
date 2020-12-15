package graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;



public class PrismMinimumSpanningTree {
	public Set<Edge<Integer>> primMST(Graph<Integer> graph){
		HeapMap heap = new HeapMap();
		for(Vertex<Integer> vertex: graph.getAllVertex()) {
			heap.add(new HeapMapNode(vertex, Integer.MAX_VALUE));
		}
		Vertex<Integer> first = graph.getAllVertex().iterator().next();
		heap.set(first, 0);
		
		Set<Edge<Integer>> list = new LinkedHashSet<>();
		Map<Vertex<Integer>, Edge<Integer>> vertexToEdge = new HashMap<>();
		while(heap.isNotEmpty()) {
			HeapMapNode currentNode = heap.extractMin();
			Vertex<Integer> currentVertex = currentNode.getVertex();
			if(vertexToEdge.containsKey(currentVertex)) {
				list.add(vertexToEdge.get(currentVertex));
			}
			
			for(Edge<Integer> edge : currentVertex.getEdges()) {
				Vertex<Integer> adjacentVertex = getAdjacentVertex(edge, currentVertex);
				if(heap.contains(adjacentVertex) && edge.getWeight() < heap.getWeight(adjacentVertex)) {
					heap.set(adjacentVertex, edge.getWeight());
					vertexToEdge.put(adjacentVertex, edge);
				}
			}
		}
		return list;
	}
	
	private Vertex<Integer> getAdjacentVertex(Edge<Integer> edge, Vertex<Integer> currentVertex){
		return edge.getVertex1().equals(currentVertex)?edge.getVertex2():edge.getVertex1();
	}
	
	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<>(false);
		graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 1, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 5, 6);
        graph.addEdge(5, 6, 2);
        graph.addEdge(3, 5, 5);
        graph.addEdge(3, 6, 4);

//		graph.addEdge( 0, 1, 4); 
//		graph.addEdge(0, 7, 8); 
//		graph.addEdge(1, 2, 8); 
//		graph.addEdge(1, 7, 11); 
//		graph.addEdge(2, 3, 7); 
//		graph.addEdge(2, 8, 2); 
//		graph.addEdge(2, 5, 4); 
//		graph.addEdge(3, 4, 9); 
//		graph.addEdge(3, 5, 14); 
//		graph.addEdge(4, 5, 10); 
//		graph.addEdge(5, 6, 2); 
//		graph.addEdge(6, 7, 1); 
//		graph.addEdge(6, 8, 6); 
//		graph.addEdge(7, 8, 7); 
        PrismMinimumSpanningTree prims = new PrismMinimumSpanningTree();
        Collection<Edge<Integer>> edges = prims.primMST(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge);
        }
	}
}
