package dp.string;

public class LongestCommonPrefix
{
	public static String longestCommonPrefix(String[] strs)
	{
		if (strs.length == 1)
		{
			return strs[0];
		}

		if (strs.length == 0)
		{
			return "";
		}

		int index = 0;
		boolean allMatch = true;
		String baseString = strs[0];
		for (; index < baseString.length() && allMatch;)
		{
			char currentChar = baseString.charAt(index);
			for (int i = 1; i < strs.length && allMatch; i++)
			{
				allMatch = index < strs[i].length() && currentChar == strs[i].charAt(index);
			}

			if (allMatch)
			{
				index++;
			}
		}

		return index > 0 ? strs[0].substring(0, index) : "";
	}

	public static void main(String[] args)
	{
		 System.out.println(longestCommonPrefix(new String[]
		 {
		 "flower", "flow", "flight"
		 }));
		
		 System.out.println(longestCommonPrefix(new String[]
		 {
		 "dog", "racecar", "car"
		 }));
		
		 System.out.println(longestCommonPrefix(new String[]
		 {
		 "c", "c"
		}));

		System.out.println(longestCommonPrefix(new String[]
		{
				"abca", "abc"
		}));

		System.out.println(longestCommonPrefix(new String[]
		{

		}));
	}
}
