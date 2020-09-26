package graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Date 08/16/2015
 * @author Tushar Roy
 *
 * Find strongly connected components of directed graph.
 *
 * Time complexity is O(E + V)
 * Space complexity  is O(V)
 *
 * Reference - https://en.wikipedia.org/wiki/Tarjan%27s_strongly_connected_components_algorithm
 */
public class TarjanStronglyConnectedComponent {
    private Map<Vertex<Integer>, Integer> visitedTime;
    private Map<Vertex<Integer>, Integer> lowTime;
    private Set<Vertex<Integer>> onStack;
    private Deque<Vertex<Integer>> stack;
    private Set<Vertex<Integer>> visited;
    private List<Set<Vertex<Integer>>> result;
    private int time;

    public List<Set<Vertex<Integer>>> scc(Graph<Integer> graph) {
        visitedTime = new HashMap<>();
        lowTime = new HashMap<>();
        onStack = new HashSet<>();
        stack = new LinkedList<>();
        visited = new HashSet<>();
        result = new ArrayList<>();
        time = 0;

        for (Vertex<Integer> vertex: graph.getAllVertex()) {
            if(!visited.contains(vertex)){
                sccUtil(vertex);
            }
        }

        return result;
    }

    private void sccUtil(Vertex<Integer> vertex) {
        visited.add(vertex);
        onStack.add(vertex);
        stack.addFirst(vertex);
        visitedTime.put(vertex, time);
        lowTime.put(vertex, time);
        time++;
        for (Vertex<Integer> child: vertex.getAdjacentVertexes()) {
            if(!visited.contains(child)){
                sccUtil(child);
                lowTime.put(vertex, Math.min(lowTime.get(vertex), lowTime.get(child)));
            } else if(onStack.contains(child)) {
                lowTime.put(vertex, Math.min(lowTime.get(vertex), visitedTime.get(child)));
            }
        }

        if(lowTime.get(vertex) == visitedTime.get(vertex)){
            Set<Vertex<Integer>> stronglyConnectedComponents = new HashSet<>();
            Vertex<Integer> v;
            do{
                v = stack.pollFirst();
                onStack.remove(v);
                stronglyConnectedComponents.add(v);
            } while(!vertex.equals(v));
            result.add(stronglyConnectedComponents);
        }
    }

    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(6,4);
        graph.addEdge(7,6);
        graph.addEdge(7,8);
        graph.addEdge(8,7);

        TarjanStronglyConnectedComponent tarjanStronglyConnectedComponent = new TarjanStronglyConnectedComponent();
        List<Set<Vertex<Integer>>> result = tarjanStronglyConnectedComponent.scc(graph);

        result.forEach(scc -> {
            scc.forEach(vertex -> System.out.print(vertex + " "));
            System.out.println();
        });

    }
}
