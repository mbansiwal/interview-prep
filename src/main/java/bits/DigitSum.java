package bits;

import java.util.ArrayList;
import java.util.List;

public class DigitSum
{
	long dp[][] = new long[20][180];
	public void calculateDigits(int number, List<Integer> digits)
	{
		while(number > 0)
		{
			digits.add(number%10);
			number /= 10;
		}
	}
	
	public long findSum(int index, int sum, int tight, List<Integer> digits)
	{
		if(index == -1)
		{
			return sum;
		}
		if(dp[index][sum] != 0 && tight == 0)
		{
			return dp[index][sum];
		}
		
		int currentDigit = digits.get(index);
		int loopLimit = tight == 1? currentDigit: 9;
		
		long result = 0;
		for (int i = 0; i <= loopLimit; i++)
		{
			int newTight = (currentDigit == i)?tight:0; 
			result += findSum(index-1, sum+i, newTight, digits);
		}
		if(tight == 0)
		{
			dp[index][sum] = result;		
		}
		return result;
	}
	
	public void calculateSum(int a, int b)
	{
		List<Integer> digitsA = new ArrayList<Integer>();
		calculateDigits(a-1, digitsA);
		long sumA = findSum(digitsA.size() -1, 0, 1, digitsA);
		
		List<Integer> digitsB = new ArrayList<Integer>();
		calculateDigits(b, digitsB);
		long sumB = findSum(digitsB.size() -1, 0, 1, digitsB);
		
		System.out.println(sumB - sumA);
	}
	
	public static void main(String[] args)
	{
		DigitSum digitSum = new DigitSum();
		digitSum.calculateSum(123, 1024);
		
	}
}
