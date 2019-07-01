package dp.string;

public class NumberOfTimesStringAsSubsequence
{
	public static void count(char[] s1, char[] s2)
	{
		int m = s1.length;
		int n = s2.length;
		int[][] table = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++)
		{
			table[i][0] = 1;
		}
		
		for (int i = 1; i <= m; i++)
		{
			int row = i - 1;
			for (int j = 1; j <= n; j++)
			{
				int col = j - 1;
				if(s1[row] == s2[col])
				{
					table[i][j] = table[i-1][j-1] + table[i-1][j];
				}
				else
				{
					table[i][j] = table[i-1][j];
				}
			}
		}
		
		System.out.println(table[m][n]);
	}
	
	public static void main(String[] args)
	{
		String a = "GeeksforGeeks";
	    String b = "Gks";
	    
	    count(a.toCharArray(), b.toCharArray());
	}
}
