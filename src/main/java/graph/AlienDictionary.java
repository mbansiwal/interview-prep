package graph;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters
 * are unknown to you. You receive a list of words from the dictionary, where words are sorted
 * lexicographically by the rules of this new language. Derive the order of letters in this language.
 *
 * https://leetcode.com/problems/alien-dictionary/
 */
public class AlienDictionary {
    Map<Integer, Boolean> vistedMap;
    class Graph{
        List<Integer>[] edges;
        public Graph(int vertices){
            edges = new LinkedList[vertices];
            for (int i =0; i < vertices; ++i){
                edges[i] = new LinkedList();
            }
        }

        private void addEdge(int u, int v){
            edges[u].add(v);
        }

        private List<Integer> getEdges(int vertex){
            return edges[vertex];
        }
    }

    private void topologicalSort(Graph graph, Stack<Integer> stack){
        vistedMap = new HashMap<>();
        for (int i=0; i < graph.edges.length; ++i){
            if(!vistedMap.getOrDefault(i, false)){
                topologicalSortUtil(i, graph, stack);
            }
        }
    }

    private void topologicalSortUtil(int vertex, Graph graph, Stack<Integer> stack){
        vistedMap.put(vertex, true);
        for (Integer edge:graph.getEdges(vertex)) {
            if(!vistedMap.getOrDefault(edge, false)){
                topologicalSortUtil(edge, graph, stack);
            }
        }
        stack.push(vertex);
    }

    private int computeVertices(String[] words){
        Set<Character> set = new HashSet<>();
        for (String word: words) {
            for (Character ch: word.toCharArray()) {
                set.add(ch);
            }
        }
        return set.size();
    }

    public void alienOrder(String[] words){
        int vertices = computeVertices(words);
        Graph graph = new Graph(vertices);
        for (int i=0; i < words.length-1; ++i){
            String str1 = words[i];
            String str2 = words[i+1];
            int minLength = Math.min(str1.length(), str2.length());
            for (int j=0; j < minLength; ++j){
                if(str1.charAt(j) != str2.charAt(j)){
                    graph.addEdge(str1.charAt(j) - 'a', str2.charAt(j) - 'a');
                    break;
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        topologicalSort(graph, stack);
        while(!stack.isEmpty()) {
            System.out.print((char)('a' + stack.pop())+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        AlienDictionary ad =  new AlienDictionary();
        String[] words = {"caa", "aaa", "aab"};
        ad.alienOrder(words);
        String[] words2 = {"baa", "abcd", "abca", "cab", "cad"};
        ad.alienOrder(words2);
    }
}
