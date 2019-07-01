package dp.string;

public class StringInterleaving {
	public static void main(String args[]) {
		char str1[] = {'a',	'a',	'b'};
		char str2[] = {'a',	'x',	'y'};
		char str3[] = {'a',	'a',	'x',	'a',	'b', 'y'};
		
		boolean ls[][] = isInterleaving(str1, str2, str3);
		for (int i = 0; i < ls.length; i++) {
			for (boolean is1 : ls[i]) {
				System.out.print(is1+",");
			}
			System.out.println();
		}
		
		System.out.println(ls[str1.length][str1.length]);

	}
	
	private static boolean[][] match(char[] str1, char[] str2, char[] str3)
	{
		boolean[][] T = new boolean[str1.length + 1][str2.length + 1];
		T[0][0] = true;
		
		for (int j = 1; j <= str1.length; j++) 
		{
			if (str3[j - 1] == str1[j - 1] && T[0][j - 1])
			{
				T[0][j] = true; 
			}
		}
		
		for (int i = 1; i <= str2.length; i++) 
		{
			if (str3[i - 1] == str2[i - 1] && T[i - 1][0])
			{
				T[i][0] = true; 
			}
		}
		
		for (int i = 1; i <= str2.length; i++)
		{
			System.out.println(i);
			for (int j = 1; j <= str1.length; j++)
			{
				char c3 = str3[i+j-1];
				char c1 = str1[j - 1];
				char c2 = str2[i - 1];
				
				if(c3 == c1)
				{
					T[i][j] = T[i][j-1];
				}
				else if(c3 == c2)
				{
					T[i][j] = T[i-1][j];
				}
			}
		}
		
		return T;
	}

	private static boolean[][] isInterleaving(char[] str1, char[] str2, char[] str3)
	{
		boolean[][] table = new boolean[str2.length + 1][str1.length + 1];
		table[0][0] = true;
		for (int j = 1; j <= str1.length; j++)
		{
			if (table[0][j - 1] && str1[j - 1] == str3[j - 1])
			{
				table[0][j] = true;
			}
		}
		for (int i = 1; i <= str2.length; i++)
		{
			if (table[i - 1][0] && str2[i - 1] == str3[i - 1])
			{
				table[i][0] = true;
			}
		}

		for (int i = 1; i <= str2.length; i++)
		{
			for (int j = 1; j <= str1.length; j++)
			{
				char c1 = str1[j - 1];
				char c2 = str2[i - 1];
				char c3 = str3[i + j - 1];
				if (c1 == c3)
				{
					table[i][j] = table[i][j - 1];
				}

				if (c2 == c3)
				{
					table[i][j] = table[i - 1][j];
				}
			}
		}

		return table;
	}
}
