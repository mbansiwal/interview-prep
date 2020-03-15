package dp.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Time Complexity : O(n^2n!)
 * Space Complexity: O(n!)
 */
public class StringPermutationsWithDup {
    public Set<String> findAllPermutations(String input){
        Set<String> permutations = new HashSet<>();
        Map<Character, Integer> countMap = countMap(input);
        compute(countMap, input.length(), permutations, "");
        return permutations;
    }

    private Map<Character, Integer> countMap(String input){
        Map<Character, Integer> countMap = new HashMap<>();
        for (Character ch: input.toCharArray()){
            countMap.put(ch, countMap.getOrDefault(ch, 0)+1);
        }
        return countMap;
    }

    private void compute(Map<Character, Integer> countMap, int remaining, Set<String> permutations, String current){
        if(remaining == 0){
            permutations.add(current);
            return;
        }
        for (Map.Entry<Character, Integer> chEntry: countMap.entrySet()) {
            int count = chEntry.getValue();
            if( count > 0){
                countMap.put(chEntry.getKey(), count - 1);
                compute(countMap, remaining-1, permutations, current+chEntry.getKey());
                countMap.put(chEntry.getKey(), count);
            }
        }
    }

    public static void main(String[] args){
        String input = "aabbbbc";
        System.out.println(new StringPermutationsWithDup().findAllPermutations(input));
        System.out.println(new StringPermutationsWithDup().findAllPermutations(""));
        System.out.println(new StringPermutationsWithDup().findAllPermutations("aaaab"));
    }
}
