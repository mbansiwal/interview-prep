package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraysWithKDistinct
{
	public int subarraysWithKDistinct(char[] A, int K)
	{
		Window window1 = new Window();
		int maxLength = -1, left1 = 0;

		for (int right = 0; right < A.length; ++right)
		{
			char x = A[right];
			window1.add(x);

			while (window1.different() > K)
				window1.remove(A[left1++]);
			if (window1.different() == K)
			{
				maxLength = Math.max(maxLength, right - left1 + 1);
			}
		}

		return maxLength;
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestSubarraysWithKDistinct().subarraysWithKDistinct("aabacbebebe".toCharArray(), 3));
		System.out.println(new LongestSubarraysWithKDistinct().subarraysWithKDistinct("aabbcc".toCharArray(), 1));
		System.out.println(new LongestSubarraysWithKDistinct().subarraysWithKDistinct("aabbcc".toCharArray(), 2));
		System.out.println(new LongestSubarraysWithKDistinct().subarraysWithKDistinct("aabbcc".toCharArray(), 3));
		System.out.println(new LongestSubarraysWithKDistinct().subarraysWithKDistinct("aaabbb".toCharArray(), 3));
	}
}

class Window
{
	int distinctChars = 0;
	Map<Character, Integer> countMap = new HashMap<>();

	public int different()
	{
		return distinctChars;
	}

	public void add(char x)
	{
		countMap.put(x, countMap.getOrDefault(x, 0) + 1);
		if (countMap.get(x) == 1)
		{
			distinctChars++;
		}
	}

	public void remove(char x)
	{
		countMap.put(x, countMap.getOrDefault(x, 0) - 1);
		if (countMap.get(x) == 0)
		{
			distinctChars--;
		}

	}
}
