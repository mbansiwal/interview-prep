package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/find-substrings-contain-vowels/
 * 
 * We have been given a string in lowercase alphabets. We need to print substrings that contain all the vowels at-least one time and there are no consonants (non-vowel characters) present in the substrings.
 * 
 * @author mbbansiw
 *
 */
public class FindSubstringsThatContainAllVowels {
    private static Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    private static boolean isVowel(char currentChar){
        return vowelSet.contains(currentChar);
    }

    public static void findSubstring(String str){
        Set<Character> charSet = new HashSet<>();
        int start = 0;
        for (int i = 0; i < str.length(); ++i){
            char currentChar = str.charAt(i);
            if(isVowel(currentChar)){
                charSet.add(currentChar);
                if(charSet.size() == 5){
                    System.out.println(str.substring(start, i+1));
                }
            } else{
                start = i + 1;
                charSet.clear();
            }
        }
    }
    // Driver Code
    public static void main(String[] args) {
        String str = "aeoibsddaeiouuadab";
        findSubstring(str);
    }
}
