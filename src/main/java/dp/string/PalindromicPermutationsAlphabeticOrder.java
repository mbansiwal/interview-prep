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
public class PalindromicPermutationsAlphabeticOrder {
    private int[] countFrequency(String input){
        int[] frequency = new int[26];
        for (Character ch : input.toCharArray()) {
            frequency[ch-'a']++;
        }
        return frequency;
    }

    private boolean isPallindrom(int[] countFrequencyMap){
        int oddCount = 0;
        int size = 0;

        for (int charCount: countFrequencyMap) {
            if(charCount > 0){
                size+=charCount;
                if(charCount % 2 != 0){
                    oddCount++;
                }
                if(oddCount > 1){
                    return false;
                }
            }
        }
        if(size % 2 == 0 && oddCount > 0){
            return false;
        }
        return true;
    }

    public Set<String> findAllPermutations(String input){
        int[] countFrequencyMap = countFrequency(input);

        if(!isPallindrom(countFrequencyMap)){
            return new HashSet<>();
        }

        char[] allChars = new char[input.length()];
        int frontIndex = 0;
//        int endIndex = input.length()-1;
        Character oddChar = null;
        StringBuilder halfInput = new StringBuilder();
        for (int i=0; i < countFrequencyMap.length; ++i) {
            int charCount = countFrequencyMap[i];
            if(charCount > 0){
                if(charCount % 2 != 0){
                    oddChar = (char)(i + 'a');
                } else {
                    for (int j=0; j < charCount/2; ++j){
                        halfInput.append( (char)(i + 'a'));
                    }
                }
            }
        }

        Set<String> permutations = new LinkedHashSet<>();
        List<String> allPermutations = findPermutations(halfInput.toString());
        for (int i = 0; i < allPermutations.size(); ++i ) {
            StringBuilder firstHalf = new StringBuilder(allPermutations.get(i));
            StringBuilder permutation = new StringBuilder(firstHalf);
            if(oddChar != null){
                permutation.append(oddChar);
            }
            permutation.append(firstHalf.reverse());
            permutations.add(permutation.toString());
        }

        return permutations;
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
        String input = "malayalam";
        System.out.println(new PalindromicPermutationsAlphabeticOrder().findAllPermutations(input));
    }
}
