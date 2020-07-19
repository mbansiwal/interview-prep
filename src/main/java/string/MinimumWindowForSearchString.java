package string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumWindowForSearchString {

    public String findMinimumWindow(String sentence, String pattern){
        int minimumWindow = Integer.MAX_VALUE;
        String[] words = sentence.split(" ");
        String[] patternWords = pattern.split(" ");

        Map<String, Integer> wordsMap = new HashMap<>();
        Map<String, Integer> patternWordsMap = new HashMap<>();

        for (String patternToken: patternWords){
            patternWordsMap.put(patternToken, patternWordsMap.getOrDefault(patternToken, 0)+1);
        }

        int start = 0;
        int count = 0;
        int startIndex = 0;
        for(int end=0; end < words.length; ++end){
            String currentWord = words[end];
            wordsMap.put(currentWord, wordsMap.getOrDefault(currentWord, 0)+1);
            if(patternWordsMap.containsKey(currentWord) && patternWordsMap.get(currentWord) >= wordsMap.get(currentWord)){
                count++;
            }

            if(count == patternWords.length){
                while(!patternWordsMap.containsKey(words[start]) || wordsMap.get(words[start]) > patternWordsMap.getOrDefault(words[start], 0)){
                    if(wordsMap.get(words[start]) > patternWordsMap.getOrDefault(words[start], 0))
                    {
                        wordsMap.put(words[start], wordsMap.get(words[start])-1);
                    }

                    ++start;
                }
                if(minimumWindow > (end - start + 1)){
                    minimumWindow = end - start + 1;
                    startIndex = start;
                }
            }
        }

        StringBuilder minimumWindowString = new StringBuilder();
        for(int i = startIndex; i < (startIndex + minimumWindow); ++i){
            minimumWindowString.append(words[i]);
            minimumWindowString.append(" ");
        }
        return minimumWindowString.toString().trim();
    }

    public static void main(String[] args){
        String sentence = "A test java to be taken question by test attending java question heros of java test question";
        String pattern = "java question test";

        System.out.println(new MinimumWindowForSearchString().findMinimumWindow(sentence, pattern));
    }
}
