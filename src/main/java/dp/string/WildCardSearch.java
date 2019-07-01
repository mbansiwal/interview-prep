package dp.string;

public class WildCardSearch {
	public static void main(String args[]) {
		char pattern[] = {'x',	'?',	'y',	'*',	'z'};
		char text[] = {'x',	'a',	'y',	'l',	'm', 'z'};
		
		boolean ls[][] = match(pattern, text);
		for (int i = 0; i < ls.length; i++) {
			for (boolean is1 : ls[i]) {
				System.out.print(is1+",");
			}
			System.out.println();
		}
		
		System.out.println(ls[text.length][pattern.length]);
		System.out.println(isMatch("*".toCharArray(), "aa".toCharArray()));
	}
	
	private static boolean isMatch(char[] pattern, char[] text)
	{
		int textLength = text.length;
		int patternLength = pattern.length;
		boolean[][] table = new boolean[textLength + 1][patternLength + 1];
		table[0][0] = true;
		for (int j = 1; j <= patternLength; j++)
		{
			if (pattern[j - 1] == '*')
			{
				table[0][j] = table[0][j - 1];
			}
		}
		for (int i = 1; i <= textLength; i++)
		{
			for (int j = 1; j <= patternLength; j++)
			{
				if (text[i - 1] == pattern[j - 1] || pattern[j - 1] == '?')
				{
					table[i][j] = table[i - 1][j - 1];
				} else if (pattern[j - 1] == '*')
				{
					table[i][j] = table[i - 1][j] | table[i][j - 1];
				}
			}
		}
		return table[textLength][patternLength];
	}

	private static boolean[][] match(char[] pattern, char[] text)
	{
		boolean[][] T = new boolean[text.length+1][pattern.length+1];
		T[0][0] = true;
		for (int i = 1; i <= text.length; i++) 
		{
			char c = text[i-1];
			for (int j = 1; j <= pattern.length; j++) 
			{
				if(c == pattern[j-1] || pattern[j-1] == '?')
				{
					T[i][j] = T[i-1][j-1];
				}
				else if(pattern[j-1] == '*')
				{
					T[i][j] = T[i][j-1] | T[i-1][j];
				}
			}
		}
		
		return T;
	}
}
