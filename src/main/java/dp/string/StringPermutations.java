package dp.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity : O(n^2n!)
 * Space Complexity: O(n!)
 */
public class StringPermutations {
    public Set<String> findAllPermutations(String input){
        Set<String> permutations = new HashSet<>();
        findPermutations(input, "", permutations);
        return permutations;
    }

    //array
    // take one
    private void findPermutations(String input, String temp, Set<String> permutations){
        if(input.length() == 0){
            permutations.add(temp);
            return;
        }

        for(int i=0; i < input.length(); ++i){
            char ch = input.charAt(i);
            findPermutations(new StringBuilder(input).deleteCharAt(i).toString(), temp+ch, permutations);
        }
    }


    public static void main(String[] args){
        String input = "abc";
        System.out.println(new StringPermutations().findAllPermutations(input));
        System.out.println(new StringPermutationsWithDup().findAllPermutations(""));
        System.out.println(new StringPermutations().findAllPermutations("aaaab"));
    }
}
