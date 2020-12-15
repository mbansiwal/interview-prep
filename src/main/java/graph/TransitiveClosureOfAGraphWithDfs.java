package graph;

/**
 * https://www.geeksforgeeks.org/transitive-closure-of-a-graph-using-dfs/
 * 
 * 
 * @author mbbansiw
 *
 */
public class TransitiveClosureOfAGraphWithDfs {
	public static void main(String[] args) {
		Graph<Integer> g = new Graph<>(true); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3);
        
        new TransitiveClosureOfAGraphWithDfs().transitiveClosure(g);
	}
	
	public void transitiveClosure(Graph<Integer> graph) {
		int size = graph.getAllVertex().size();
		boolean[][] result = new boolean[size][size];
		for (Vertex<Integer> vertex : graph.getAllVertex()) {
			dfs(vertex, vertex, result);
		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print((result[i][j]?1:0)+" "); 
			}
			System.out.println(); 
		}
	}
	
	private void dfs(Vertex<Integer> vertex1, Vertex<Integer> vertex2, boolean[][] result) {
		result[vertex1.getIdAsInt()][vertex2.getIdAsInt()] = true;
		
		for (Vertex<Integer> vertex3 : vertex2.getAdjacentVertexes()) {
			if(!result[vertex1.getIdAsInt()][vertex3.getIdAsInt()])
			{
				dfs(vertex1, vertex3, result);
			}
		}
	}
}
