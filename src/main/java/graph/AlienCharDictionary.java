package graph;

import java.util.*;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters
 * are unknown to you. You receive a list of words from the dictionary, where words are sorted
 * lexicographically by the rules of this new language. Derive the order of letters in this language.
 *
 * https://leetcode.com/problems/alien-dictionary/
 */
public class AlienCharDictionary {
    Map<Character, Boolean> vistedMap;

    class CharGraph{
        private Map<Character, List<Character>> edgesMap;
        CharGraph(){
            vistedMap = new HashMap<>();
            edgesMap = new HashMap<>();
        }

        public void addEdges(Character ch1, Character ch2){
            if(!edgesMap.containsKey(ch1)){
                edgesMap.put(ch1, new LinkedList<>());
            }
            edgesMap.get(ch1).add(ch2);
        }

        public List<Character> getEdges(Character ch){
            return edgesMap.getOrDefault(ch, new LinkedList<>());
        }

        public void topologicalSort(){
            Stack<Character> stack = new Stack<>();
            for (Character vertex: edgesMap.keySet()) {
                if(!vistedMap.getOrDefault(vertex, false))
                {
                    topologicalSortUtil(vertex, stack);
                }
            }
            while(!stack.isEmpty()) {
                System.out.print(stack.pop()+" ");
            }
            System.out.println();
        }

        private void topologicalSortUtil(Character vertex, Stack<Character> stack){
            vistedMap.put(vertex, true);
            for (Character edge: getEdges(vertex)) {
                if(!vistedMap.getOrDefault(edge, false)){
                    topologicalSortUtil(edge,  stack);
                }
            }
            stack.add(vertex);
        }
    }



    public static void main(String args[]) {
        AlienCharDictionary ad =  new AlienCharDictionary();
        String[] words = {"caa", "aaa", "aab"};
        ad.alienOrder(words);
        String[] words2 = {"baa", "abcd", "abca", "cab", "cad"};
        ad.alienOrder(words2);
    }



    private void alienOrder(String[] words) {
        CharGraph graph = new CharGraph();
        for (int i = 0; i < words.length - 1; ++i){
            String str1 = words[i];
            String str2 = words[i+1];

            int minLength = Math.min(str1.length(), str2.length());

            for (int j = 0; j < minLength; ++j){
                Character ch1 = str1.charAt(j);
                Character ch2 = str2.charAt(j);
                if(ch1 != ch2){
                    graph.addEdges(ch1, ch2);
                    break;
                }
            }
        }

        graph.topologicalSort();
    }
}
