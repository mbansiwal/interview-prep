package google;

import java.util.Iterator;

/**
 * https://leetcode.com/problems/sentence-screen-fitting/
 * 
 * Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word is greater than 0 and won't exceed 10.
1 ≤ rows, cols ≤ 20,000.
Example 1:

Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output: 
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
Example 2:

Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

Output: 
2

Explanation:
a-bcd- 
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.
Example 3:

Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

Output: 
1

Explanation:
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.
 * @author Administrator
 *
 */
public class SentenceScreenFitting {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        
        int sLen = sentence.length;  
        
        // store the length of each word.
        int[] sentenceLength = new int[sLen];
        
        // given a starting word index on a given row, save what the starting word index of the next row will be.
        int[] nextWord = new int[sLen];
        
        // given a starting word index on a given row, save how many (if any) sentences are completed on the given row.
        int[] rowSentences = new int[sLen];
        
        // precompute the sentence length to save on the String.length call
        for(int i = 0; i < sLen; i++)
            sentenceLength[i] = sentence[i].length();
        
        // treat each word as a potential starting word for a row and compute what the next row's starting word will be and how
        // many sentences (if any) will be completed on the given row.
        for(int i = 0; i < sLen; i++){
            
            int currentWord = i;
            int len = 0; 
            int totalSentences = 0;
            
            // loop through every word in the sentence until we have reached the end of the row's length.
            while(len + sentenceLength[currentWord] <= cols){
                
                len += sentenceLength[currentWord] + 1;
                currentWord++;
                
                // every time the end of the sentence is reached, increment the count of completed setences for a given starting 
                // word on a given row.
                if(currentWord == sLen){
                    currentWord = 0;
                    totalSentences++;
                }
                
            }
            
            // save what the next rows starting word will be if the current row's starting word is at i.
            nextWord[i] = currentWord;
            
            // save how many sentences will be completed if the current row's starting word is at i.
            rowSentences[i] = totalSentences;
            
        }
      
        // count all the sentences completed in all rows.
        int totalSentencesInAllRows = 0;
        
        // the first row will start with the first word in the sentence.
        int startWord = 0;
        
        // for every row, add the total number of sentences completed in the current row (if any)
        // and grab the index of the starting word of the next row;
        for(int i = 0; i < rows; i++){
            totalSentencesInAllRows += rowSentences[startWord];
            startWord = nextWord[startWord];
        }
        
        return totalSentencesInAllRows;
    }
    
    public int wordsTyping2(String[] sentence, int rows, int cols) {
    	int currentWord = 0;
    	int currentLength = 0;
    	int sentences = 0;
    	for (int i = 0; i < sentence.length; i++) {
			currentLength=0;
			while(sentence[currentWord].length() + currentLength <= cols) {
				currentLength += sentence[currentWord].length() + 1;
				currentWord++;
				if(currentWord == rows) {
					currentWord = 0;
					sentences++;
				}
			}
		}
    	return sentences;
    }
    
    public static void main(String[] args) {
		System.out.println(new SentenceScreenFitting().wordsTyping2(new String[]{"hello", "world"}, 2, 8));
		System.out.println(new SentenceScreenFitting().wordsTyping2(new String[]{"a", "bcd", "e"}, 3, 6));
		System.out.println(new SentenceScreenFitting().wordsTyping2(new String[]{"I", "had", "apple", "pie"}, 4, 5));
	}
}
