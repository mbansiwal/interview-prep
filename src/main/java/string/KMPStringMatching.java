package string;

import java.util.Arrays;

public class KMPStringMatching 
{
	private int[] createLps(char[] patternArr)
	{
		int size = patternArr.length;
		int[] lps = new int[size];
		
		int i =1;
		int j =0;
		
		while(i < size)
		{
			if(patternArr[i] == patternArr[j])
			{
				j++;
				lps[i] = j;
				i++;
			}
			else
			{
				if(j != 0)
				{
					j = lps[j-1];
				}
				else
				{
					lps[i] = 0;
					i++;
				}
			}
		}
		System.out.println(Arrays.toString(lps));
		return lps;
	}
	
	public void matchPattern(char[] text, char[] pattern)
	{
		int[] kmpArray = createLps(pattern);
		int size = text.length;
		int patternSize = pattern.length;
		int textIndex = 0;
		int patternIndex = 0;
		boolean matchFound = false;
		int iterations = 0;
		while(textIndex < size)
		{
			iterations++;
			System.out.println(text[textIndex]+","+pattern[patternIndex]+"; "+textIndex+":"+patternIndex);
			
			if(text[textIndex] == pattern[patternIndex])
			{
				textIndex++;
				patternIndex++;
			}
			else
			{
				if(patternIndex !=0)
				{
					patternIndex = kmpArray[patternIndex-1];
				}
				else
				{
					textIndex++;
				}
			}
			if(patternSize == patternIndex)
			{
				matchFound = true;
				break;
			}
		}
		System.out.println(matchFound);
		System.out.println(iterations);
	}
	
	public static void main(String[] args) 
	{
		KMPStringMatching kmpStringMatching = new KMPStringMatching();
		char[] patternArr = "abcaby".toCharArray();
		char[] textArr = "abxabcabcaby".toCharArray();
		kmpStringMatching.matchPattern(textArr, patternArr);
		
		String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        kmpStringMatching.matchPattern(txt.toCharArray(), pat.toCharArray());
	}
}
