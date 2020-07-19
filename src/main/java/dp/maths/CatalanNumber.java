package dp.maths;

/**
 * Catalan formula = 2nCn/(n+1)
 * Time Complexity: Time complexity of implementation is O(n).
 * https://www.geeksforgeeks.org/applications-of-catalan-numbers/
 */
public class CatalanNumber
{
	public static int printCatalanNumber(int n)
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
		return table[n];
	}

	private static long binomialCoeficient(int n, int k){
		if(k > (n-k)){
			k = n -k;
		}

		long coeficient = 1;
		for(int i = 0; i < k; ++i){
			coeficient *= (n-i);
			coeficient /= (i+1);
		}
		return coeficient;
	}

	/**
	 * https://www.geeksforgeeks.org/program-nth-catalan-number/
	 *
	 * @param n
	 * @return
	 */
	public static long catalanNumberFormula(int n){
		return binomialCoeficient(2*n, n)/(n+1);
	}
	
	public static void main(String[] args)
	{
		for (int i = 1; i < 10; i++)
		{
			System.out.println("For n == "+i+" is "+printCatalanNumber(i )+" and by catalan formula "+ catalanNumberFormula(i));
		}
	}
}
