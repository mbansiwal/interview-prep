package string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowString
{
	public void findMinimumWindow(String text, String pattern)
	{
		char[] patternChars = pattern.toCharArray();
		int patternLength = pattern.length();

		char[] textChars = text.toCharArray();
		int textLength = textChars.length;

		int startIndex = -1;

		Map<Character, Integer> patternMap = new HashMap<>();
		Map<Character, Integer> textMap = new HashMap<>();
		for (char patternChar: patternChars) {
			patternMap.put(patternChar, patternMap.getOrDefault(patternChar, 0)+1);
		}

		int minimumWindow = Integer.MAX_VALUE;
		int minimumStartIndex = Integer.MAX_VALUE;
		int textMatchLength = 0;
		for (int index = 0; index < textLength; index++){
			char textChar = textChars[index];
			textMap.put(textChar, textMap.getOrDefault(textChar, 0)+1);
			if(patternMap.containsKey(textChar)){
				if(startIndex == -1){
					startIndex = index;
				}

				if(textMap.get(textChar) <= patternMap.get(textChar)){
					textMatchLength++;
				}
			}

			if(patternLength == textMatchLength){
				char firstChar = textChars[startIndex];
				while(textMap.getOrDefault(firstChar, 0) > patternMap.getOrDefault(firstChar,0)){
					textMap.put(firstChar, textMap.get(firstChar) - 1);
					startIndex++;
					firstChar = textChars[startIndex];
				}

				int tempWindow = index - startIndex + 1;
				if(tempWindow < minimumWindow){
					minimumWindow = tempWindow;
					minimumStartIndex = startIndex;
				}
			}
		}

		System.out.println("Minimum Window "+minimumWindow+", minimumStart: "+minimumStartIndex+ ":::String is "+text.substring(minimumStartIndex, minimumStartIndex+minimumWindow));
	}

	public static void main(String[] args)
	{
		MinimumWindowString minimumWindowString = new MinimumWindowString();
		System.out.println(minimumWindowString.findMinimumWindowTest("Tsuaosyogrlmnsluuorjkoruost", "soor"));
		minimumWindowString.findMinimumWindow("Tsuaosyogrlmnsluuorjkoruost", "soor");
	}

	public String findMinimumWindowTest(String input, String pattern)
	{
		int inputLength = input.length();
		char[] inputArr = input.toCharArray();
		int patternLength = pattern.length();
		char[] patternArr = pattern.toCharArray();

		Map<Character, Integer> patternMap = new HashMap<>();
		Map<Character, Integer> inputMap = new HashMap<>();

		for (char c : patternArr)
		{
			patternMap.put(c, patternMap.getOrDefault(c, 0) + 1);
		}

		int inputMatchLength = 0;
		int start = -1;
		int minStart = 0;
		int minWindow = Integer.MAX_VALUE;
		for (int i = 0; i < inputLength; i++)
		{
			char c = inputArr[i];

			inputMap.put(c, inputMap.getOrDefault(c, 0) + 1);
			if (patternMap.containsKey(c))
			{
				if (start == -1)
				{
					start = i;
				}
				if (patternMap.get(c) >= inputMap.get(c))
				{
					inputMatchLength++;
				}
			}

			if (patternLength == inputMatchLength)
			{
				while (inputMap.getOrDefault(inputArr[start], 0) > patternMap.getOrDefault(inputArr[start], 0))
				{
					inputMap.put(inputArr[start], inputMap.get(inputArr[start]) - 1);
					start++;
				}

				int temp = i - start + 1;
				if (temp < minWindow)
				{
					minWindow = temp;
					minStart = start;
				}
				System.out.println(inputMatchLength + ", " + start);
			}
		}

		return minWindow < Integer.MAX_VALUE ? input.substring(minStart, minStart + minWindow) : "";
	}

}
