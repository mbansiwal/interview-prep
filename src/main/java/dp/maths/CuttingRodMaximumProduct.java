package dp.maths;

public class CuttingRodMaximumProduct
{
	static void maxProd(int n)
	{
	   // n equals to 2 or 3 must be handled explicitly
	   if (n == 2 || n == 3) 
	   {
		   System.out.println(n-1);
		   return;
	   }
	 
	   // Keep removing parts of size 3 while n is greater than 4
	   int res = 1;
	   while (n > 4)
	   {
	       n -= 3;
	       res *= 3; // Keep multiplying 3 to res
	   }
	   System.out.println(n * res); // The last part multiplied by previous parts
	}
	
	static void maxProdDynamicProgramming(int n)
	{
		int val[] = new int[n+1];
		
		for (int i = 1; i <= n; i++)
		{
			int maxValue = 0;
			for (int j = 1; j <= i/2; j++)
			{
				maxValue = Math.max(maxValue, Math.max((i-j)*j, j*val[i-j]));
			}
			val[i] = maxValue;
		}
		
		System.out.println(val[n]);
	}
	
	public static void main(String[] args)
	{
		maxProd(10);
		maxProdDynamicProgramming(10);
	}
}
