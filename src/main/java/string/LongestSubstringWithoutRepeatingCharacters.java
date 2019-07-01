package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters
{
	public int lengthOfLongestSubstring(String s)
	{
		Map<Character, Integer> dataMap = new HashMap<>();
		char[] str = s.toCharArray();

		int maxLength = 0;
		for (int i = 0, currentIndex = 0; i < str.length; i++)
		{
			if (dataMap.containsKey(str[i]))
			{
				currentIndex = Math.max(currentIndex, dataMap.get(str[i]));
			}
			dataMap.put(str[i], i + 1);
			maxLength = Math.max(maxLength, i - currentIndex + 1);
		}
		return maxLength;
	}

	public static void main(String[] args)
	{

	}
}
