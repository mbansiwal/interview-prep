package dp.maths;

public class CatalanNumber
{
	public static void printCatalanNumber(int n)
	{
		int[] table = new int[n+1];
		table[0] = 1;
		if(n >=1)
		{
			table[1] = 1;	
		}
		
		for (int i = 2; i <= n; i++)
		{
			table[i] = 0;
			for (int j = 0; j < i; j++)
			{
				table[i] += table[j]*table[i-j-1];				
			}
		}
		System.out.println(table[n]);
	}
	
	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			printCatalanNumber(i);
		}
	}
}
