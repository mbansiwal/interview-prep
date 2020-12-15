package graph;

/**
 * 
 * https://www.geeksforgeeks.org/transitive-closure-of-a-graph/
 * 
 * Time Complexity: O(V3) where V is number of vertices in the given graph.
 * @author mbbansiw
 *
 */
public class TransitiveClosureOfAGraph {
	void transitiveClosure(int graph[][]) 
    {
		int n = graph.length;
		boolean[][] result = new boolean[n][n];
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				result[i][j] = graph[i][j] == 1;
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				for (int k = 0; k < result.length; k++) {
					result[i][j] = result[i][j] || (result[i][k] & result[k][j]);	
				}
			}
		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				System.out.print((result[i][j]?1:0)+" "); 
			}
			System.out.println(); 
		}
    }
	
	public static void main(String[] args) {
		int graph[][] = new int[][]{ {1, 1, 0, 1}, 
            {0, 1, 1, 0}, 
            {0, 0, 1, 1}, 
            {0, 0, 0, 1} 
          }; 
        new TransitiveClosureOfAGraph().transitiveClosure(graph);  
	}
}
