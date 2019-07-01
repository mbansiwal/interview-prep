package dp;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/count-binary-strings-k-times-appearing-adjacent-two-set-bits/
 * 
 * @author mbansiwal
 *
 */
public class CountBinaryKTimesAdjacentTwoBits
{
	public static void count(int n, int k)
	{
		int[][][] table = new int[n+1][k+1][2];
		table[1][0][0] = 1;
		table[1][0][1] = 1;
		
		for (int len = 2; len <=n; len++)
		{
			for (int j = 0; j <=k ; j++)
			{
				table[len][j][0] = table[len-1][j][0]+table[len-1][j][1];
				table[len][j][1] = table[len-1][j][0];
				
				if(j-1 >= 0)
				{
					table[len][j][1] += table[len-1][j-1][1];
				}
			}
		}
		
		System.out.println(Arrays.toString(table[n][k]));
		System.out.println(table[n][k][0] + table[n][k][1]);
	}
	
	public static void main(String[] args)
	{
		int n=5, k=2;
		count(n, k);
	}
}
