package arr;

public class MaximumArraySumAfterRepeatedSubtraction {
	public static int gcd(int a, int b)
	{
		if(b==0)
		{
			return a;
		}
		return gcd(b, a%b);
	}
	
	static int findMaxSumUtil(int arr[], int n)
	{
	    int finalGCD = arr[0];
	    for (int i = 1; i < n; i++)
	    {
	    	finalGCD = gcd(arr[i], finalGCD);
	    }
	 
	    return finalGCD;
	}
	 
	
	public static void main(String[] args) 
	{
		int arr[] = {8, 20, 12, 36};
		int n = arr.length;
		System.out.println(findMaxSumUtil(arr, n) * n);
	}
}
