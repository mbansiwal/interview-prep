package dp.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoStringsAreAnagram {

    public static void main(String args[])
    {
        char str1[] = { 't', 'e', 's', 't' };
        char str2[] = { 't', 't', 'e', 'w' };
        if (areAnagram("test".toCharArray(), "ttew".toCharArray()))
            System.out.println("The two strings are"
                    + " anagram of each other");
        else
            System.out.println("The two strings are not"
                    + " anagram of each other");
        if (areAnagram("listen".toCharArray(), "silent".toCharArray()))
            System.out.println("The two strings are"
                    + " anagram of each other");
        else
            System.out.println("The two strings are not"
                    + " anagram of each other");
    }

    private static boolean areAnagram(char[] str1, char[] str2) {
        Map<Character, Integer> countMap1 = new HashMap<>();
        Map<Character, Integer> countMap2 = new HashMap<>();

        for (Character ch: str1){
            countMap1.put(ch, countMap1.getOrDefault(ch, 0)+1);
        }
        for (Character ch: str2){
            countMap2.put(ch, countMap2.getOrDefault(ch, 0)+1);
        }

        return countMap1.equals(countMap2);
    }
}
