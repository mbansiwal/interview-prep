package dp.string;

public class RegexPatternSearch {
	public static void main(String args[]) {
		// char pattern[] = {'x', 'b', 'a', '*', 'b', '.', 'c'};
		// char text[] = {'x', 'b', 'a', 'a', 'b', 'y', 'c'};

		char text[] = "mississippi".toCharArray();
		char pattern[] = "mis*is*ip*.".toCharArray();
		
		boolean ls[][] = match(pattern, text);
		for (int i = 0; i < ls.length; i++) {
			for (boolean is1 : ls[i]) {
				System.out.print(is1+",");
			}
			System.out.println();
		}
		
		System.out.println(ls[text.length][pattern.length]);



		System.out.println(isMatch("mississippi", "mis*is*ip*."));
		System.out.println(isMatch("cb", "ca*b"));
	}
	
	private static boolean[][] match(char[] pattern, char[] text)
	{
		boolean[][] T = new boolean[text.length+1][pattern.length+1];
		T[0][0] = true;
		for (int j = 1; j <= pattern.length; j++)
		{
			if (pattern[j - 1] == '*')
			{
				T[0][j] = j == 1 ? true : T[0][j - 2];
			}
		}
		for (int i = 1; i <= text.length; i++) 
		{
			char c = text[i-1];
			for (int j = 1; j <= pattern.length; j++) 
			{
				char patternChar = pattern[j-1];
				char patternPrevChar = j>=2?pattern[j-2]: '\0';
				if(c == patternChar || patternChar == '.')
				{
					T[i][j] = T[i-1][j-1];
				}
				else if(patternChar == '*')
				{
					T[i][j] = T[i][j-2];
					if(patternPrevChar == '.' || patternPrevChar == c)
					{
						T[i][j] = T[i][j] | T[i - 1][j];
					}
				}
			}
		}
		
		return T;
	}

	public static boolean isMatch(String s, String p)
	{
		char[] str = s.toCharArray();
		char[] pattern = p.toCharArray();
		int strLength = str.length;
		int patternLength = pattern.length;
		boolean[][] table = new boolean[strLength + 1][patternLength + 1];
		table[0][0] = true;
		for (int j = 1; j <= patternLength; j++)
		{
			if (pattern[j - 1] == '*')
			{
				table[0][j] = j == 1 ? true : table[0][j - 2];
			}
		}
		for (int i = 1; i <= strLength; i++)
		{
			for (int j = 1; j <= patternLength; j++)
			{
				char prevChar = j >= 2 ? pattern[j - 2] : '\0';
				char patternChar = pattern[j - 1];
				char textChar = str[i - 1];
				if (textChar == patternChar || patternChar == '.')
				{
					table[i][j] = table[i - 1][j - 1];
				} else if (patternChar == '*')
				{
					table[i][j] = table[i][j - 2];
					if (prevChar == '.' || prevChar == textChar)
					{
						table[i][j] = table[i - 1][j] | table[i][j - 2];
					}
				}
			}
		}

		return table[strLength][patternLength];
	}
}
