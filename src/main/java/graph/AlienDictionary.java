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
    public String alienOrder(String[] words){
        StringBuilder result = new StringBuilder("");
        Map<Character, Integer> degrees = new HashMap<>();
        Map<Character, Set<Character>> graph = buildGraph(words, degrees);

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry: degrees.entrySet()) {
            if(entry.getValue() == 0){
                queue.offer(entry.getKey());
            }
        }

        while(!queue.isEmpty()){
            Character ch = queue.poll();
            result.append(ch);
            for (Character child: graph.getOrDefault(ch, new HashSet<>())) {
                degrees.put(child, degrees.get(child)-1);
                if(degrees.get(child) == 0){
                    queue.offer(child);
                }
            }
            graph.remove(ch);
        }
        return result.toString();
    }

    private Map<Character, Set<Character>> buildGraph(String[] strings, Map<Character, Integer> degrees){
        Set<Character> allCharacters = buildCharacters(strings, degrees);
        Map<Character, Set<Character>> graph = new HashMap<>();
        for(int i =0; i < strings.length -1; ++i){
            String str1 = strings[i];
            String str2 = strings[i+1];
            for(int k =0; k < Math.min(str1.length(), str2.length()); ++k){
                Character ch1 = str1.charAt(k);
                Character ch2 = str2.charAt(k);
                if(ch1 != ch2){
                    allCharacters.remove(ch1);

                    graph.putIfAbsent(ch1, new HashSet<>());
                    graph.get(ch1).add(ch2);
                    degrees.put(ch2, degrees.getOrDefault(ch2, 0)+1);
                    break;
                }
            }
        }

        for (Character character: allCharacters) {
            graph.remove(character);
        }
        return graph;
    }

    private Set<Character> buildCharacters(String[] strings, Map<Character, Integer> degree){
        Set<Character> allCharacters = new HashSet<>();
        for (String str: strings) {
            for (Character ch: str.toCharArray()) {
                allCharacters.add(ch);
                degree.computeIfAbsent(ch, key -> 0);
            }
        }
        return allCharacters;
    }

    public static void main(String args[]) {
        AlienDictionary ad =  new AlienDictionary();
        String[] words1 = {"zy","zx"};
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        String[] words2 = {"wrtkj","wrt"};
        System.out.println(ad.alienOrder(words));
        System.out.println(ad.alienOrder(words1));
        System.out.println(ad.alienOrder(words2));

        /**
         wertf
         yzx
         rtwjk
         */
        //w -> e
        // e -> r
        //t -> f
        //r -> t
        //
    }
}
