package dp.string;

import java.util.*;

public class FindAllAnagramsInAString {
    public static void main(String[] args){
        String str1 = "cbaebabacd";
        String str2 = "abc";
        System.out.println(new FindAllAnagramsInAString().findAnagrams(str1, str2));
    }

    public List<Integer> findAnagrams(String str1, String patternStr) {
        int patternLength = patternStr.length();
        if(str1.length() < patternStr.length()){
            return Arrays.asList();
        }
        Map<Character, Integer> countMap1 = new HashMap<>();
        Map<Character, Integer> patternCountMap = new HashMap<>();
        for (Character ch: patternStr.toCharArray()){
            patternCountMap.put(ch, patternCountMap.getOrDefault(ch, 0)+1);
        }

        for (int i=0; i < patternLength;++i){
            countMap1.put(str1.charAt(i), countMap1.getOrDefault(str1.charAt(i), 0)+1);
        }

        List<Integer> result = new ArrayList<>();
        if(countMap1.equals(patternCountMap)){
            result.add(0);
        }

        for (int i=patternLength; i < str1.length();++i){
            Character ch = str1.charAt(i);
            countMap1.put(ch, countMap1.getOrDefault(ch, 0)+1);
            Character startChar = str1.charAt(i-patternLength);
            countMap1.put(startChar, countMap1.getOrDefault(startChar, 0)-1);
            if(countMap1.get(startChar) == 0){
                countMap1.remove(startChar);
            }
            if(patternCountMap.containsKey(ch) && countMap1.equals(patternCountMap)){
                result.add(i - patternLength + 1);
            }
        }
        return result;
    }

}
