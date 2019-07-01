package string;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoorHorsPoolAlgo {
	private Map<Character, Integer> createBadMatchTable(String pattern)
	{
		Map<Character, Integer> badMatchTable = new HashMap<>();
		char[] patternArray =  pattern.toCharArray();
		int patternLength = patternArray.length;
		for (int i = 0; i < patternLength-1; i++) 
		{
			badMatchTable.put(patternArray[i], patternLength - i - 1);
		}
		if(!badMatchTable.containsKey(patternArray[patternLength-1]))
		{
			badMatchTable.put(patternArray[patternLength-1], patternLength);
		}
		System.out.println(badMatchTable);
		return badMatchTable;
	}
	
	public boolean matches(String text, String pattern)
	{
		Map<Character, Integer> badMatchTable = createBadMatchTable(pattern);
		
		char[] patternArray = pattern.toCharArray();
		char[] textArray = text.toCharArray();
		int textLength = text.length();
		int textIndex = patternArray.length - 1;
		
		while(textIndex < textLength) 
		{
			int textCurrentIndex = textIndex;
			int patternCurrentIndex = patternArray.length - 1;

			while(patternArray[patternCurrentIndex] == textArray[textCurrentIndex])
			{
				if(patternCurrentIndex == 0)
				{
					return true;
				}
				patternCurrentIndex--;
				textCurrentIndex--;
			}
			
			if(badMatchTable.containsKey(textArray[textCurrentIndex]))
			{
				textIndex = textIndex + badMatchTable.get(textArray[textCurrentIndex]);
			}
			else
			{
				textIndex = textIndex + patternArray.length;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) 
	{
		String text = "ABAAABCD";
	    String pattern = "ABC";
	    BoyerMoorHorsPoolAlgo boyerMoorHorsPoolAlgo = new BoyerMoorHorsPoolAlgo();
	   
	    System.out.println(boyerMoorHorsPoolAlgo.matches(text, pattern));
	    
	}
}
