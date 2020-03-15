package dp.string;

import java.util.*;

/**
 *
 * https://www.geeksforgeeks.org/print-palindromic-permutations-given-string-alphabetic-order/
 *
 * Print all the palindromic permutations of given string in alphabetic order
 * Given a string str of size n. The problem is to print all the palindromic permutations of str in alphabetic order if possible else print “-1”.
 *
 * Examples :
 *
 * Input : str = "aabb"
 * Output :
 * abba
 * baab
 *
 * Input : malayalam
 * Output :
 * aalmymlaa
 * aamlylmaa
 * alamymala
 * almayamla
 * amalylama
 * amlayalma
 * laamymaal
 * lamayamal
 * lmaayaaml
 * maalylaam
 * malayalam
 * mlaayaalm
 *
 * Time Complexity : O(n^2n!)
 * Space Complexity: O(n!)
 */
public class PalindromicPermutations {
    private Map<Character, Integer> countFrequency(String input){
        Map<Character, Integer> countFrequencyMap = new HashMap<>();
        for (Character ch : input.toCharArray()) {
            countFrequencyMap.put(ch, countFrequencyMap.getOrDefault(ch, 0)+1);
        }
        return countFrequencyMap;
    }

    private boolean isPallindrom(Map<Character, Integer> countFrequencyMap){
        int oddCount = 0;
        boolean evenString = countFrequencyMap.size()%2 == 0;
        for (Map.Entry<Character, Integer> entry: countFrequencyMap.entrySet()) {
            if(entry.getValue() % 2 != 0){
                oddCount++;
            }
            if((evenString && oddCount > 0)  || (oddCount > 1)){
                return false;
            }
        }
        return true;
    }

    public List<String> findAllPermutations(String input){
        Map<Character, Integer> countFrequencyMap = countFrequency(input);

        if(!isPallindrom(countFrequencyMap)){
            return Arrays.asList();
        }

        boolean evenString = countFrequencyMap.size()%2 == 0;
        Character oddChar = null;
        StringBuilder halfInput = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: countFrequencyMap.entrySet()) {
            if(!evenString && entry.getValue() % 2 != 0){
                oddChar = entry.getKey();
            } else {
                for (int i=0; i < entry.getValue()/2; ++i){
                    halfInput.append(entry.getKey());
                }
            }
        }

        List<String> allPermutations = findPermutations(halfInput.toString());
        for (int i = 0; i < allPermutations.size(); ++i ) {
            StringBuilder firstHalf = new StringBuilder(allPermutations.get(i));
            StringBuilder permutation = new StringBuilder(firstHalf);
            if(!evenString){
                permutation.append(oddChar);
            }
            permutation.append(firstHalf.reverse());
            allPermutations.set(i, permutation.toString());
        }

        return allPermutations;
    }

    private List<String> findPermutations(String input){
        List<String> permutations = new ArrayList<>();
        computePermutations(permutations, input, "");
        return permutations;
    }

    private void computePermutations(List<String> permutations, String input, String temp){
        if(input.length() == 0){
            permutations.add(temp);
            return;
        }
        for (int i =0; i < input.length(); ++i){
            computePermutations(permutations, new StringBuffer(input).deleteCharAt(i).toString(), temp+input.charAt(i));
        }
    }

    public static void main(String[] args){
        String input = "aabcb";
        System.out.println(new PalindromicPermutations().findAllPermutations(input));
    }
}
