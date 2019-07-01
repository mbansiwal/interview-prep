package dp;

public class FindMaximumDotProductOfTwoArrays
{
	public static void dotProduct(int a[], int b[])
	{
		int aSize = a.length;
		int bSize = b.length;
		int[][] table = new int[bSize+1][aSize+1];
		
		for (int i = 1; i <= bSize; i++)
		{
			for (int j = 1; j <= aSize; j++)
			{
				table[i][j] = Math.max(table[i-1][j-1]+b[i-1]*a[j-1], table[i][j-1]);
			}
		}
		
		System.out.println(table[bSize][aSize]);
	}
	
	public static void main(String[] args)
	{
		int A[] = { 2, 3 , 1, 7, 8 } ;
	    int B[] = { 3, 6, 7 } ;
	    
	    dotProduct(A, B);
	}
}
