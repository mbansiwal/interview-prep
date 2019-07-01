package string;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoorHorsPoolAlgoPractice {

    public Map<Character, Integer> badMatchTable(String pattern){
        Map<Character, Integer> table = new HashMap<>();
        int length = pattern.length();
        char[] patternChars = pattern.toCharArray();
        for (int index=0; index < length-1; index++){
            table.put(patternChars[index], length-index-1);
        }
        System.out.println(table);
        return table;
    }

    public boolean search(String text, String pattern){
        Map<Character, Integer> badMatchTable = badMatchTable(pattern);
        char[] textChars = text.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int textIndex = pattern.length()-1;
        int patternIndex = pattern.length()-1;
        int textLength = text.length();
        int patternLength = pattern.length();
        while(textIndex < textLength && patternIndex >= 0){
            if(textChars[textIndex] == patternChars[patternIndex]){
                patternIndex--;
                textIndex--;
            } else {
                textIndex += badMatchTable.getOrDefault(textChars[textIndex], patternLength);
                patternIndex = patternLength -1;
            }
        }

        return patternIndex < 0;
    }

    public static void main(String[] args){
        BoyerMoorHorsPoolAlgoPractice boyerMoorHorsPoolAlgo = new BoyerMoorHorsPoolAlgoPractice();
        System.out.println(boyerMoorHorsPoolAlgo.search("WE HOLD THESE TRUTHS TO BE SELF-EVIDENT", "TUUTH"));
    }
}
