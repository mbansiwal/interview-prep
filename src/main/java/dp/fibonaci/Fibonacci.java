package dp.fibonaci;

import java.util.Arrays;

public class Fibonacci {
	public static void main(String[] args) {
		for (int number : find(6)) {
			System.out.print(number+",");
		}
		
		fibonaciNumber(6);
	}
	
	private static void fibonaciNumber(int n )
	{
		int a = 0;
		int b =1;
		int c =0;
		
		for (int i = 2; i <= n; i++)
		{
			c = a + b;
			a = b;
			b = c;
		}
		System.out.println();
		System.out.println(b);
	}
	
	private static int[] find(int n)
	{
		int[] numbers = null;
		if(n ==0)
		{
			numbers = new int[1];
			return numbers;
		}
		numbers = new int[n];
		numbers[0] =1;
		if(n ==1)
		{
			return numbers;
		}
		numbers[1] =1;
		
		for (int i = 2; i < n; i++) {
			numbers[i] = numbers[i-2]+numbers[i-1];
		}
		return numbers;
	}
	
	static int findNumber(int n)
	{
		if(n ==0)
		{
			return 0;
		}
		int[] numbers = new int[n+1];
		numbers[1] =2;
		numbers[2] =3;
		for (int i = 3; i <= n; i++) 
		{
			numbers[i] = numbers[i-1] + numbers[i-2];  
		}
		System.out.println(Arrays.toString(numbers));
		return numbers[n];
	}
	
	int f[] = new int[10000];
	int fib(int n)
	{
	    // Base cases
	    if (n == 0)
	        return 0;
	    if (n == 1 || n == 2)
	    {
	    	f[n] = 1;
	    	return f[n];
	    }
	 
	    // If fib(n) is already computed
	    if (f[n] > 0)
	    {
	    	return f[n];
	    }
	 
	    int k = (n % 2 != 0)? (n+1)/2 : n/2;
	 
	    // Applyting above formula [Note value n&1 is 1
	    // if n is odd, else 0.
	    f[n] = (n % 2 != 0)? (fib(k)*fib(k) + fib(k-1)*fib(k-1))
	           : (2*fib(k-1) + fib(k))*fib(k);
	 
	    return f[n];
	}
}
