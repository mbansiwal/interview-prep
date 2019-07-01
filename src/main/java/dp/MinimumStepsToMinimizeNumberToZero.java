package dp;

import java.util.Arrays;

/**
 * Given a number n, count minimum steps to minimize it to 1 according to the following criteria:

If n is divisible by 2 then we may reduce n to n/2.
If n is divisible by 3 then you may reduce n to n/3.
Decrement n by 1.
Examples:

Input : n = 10
Output : 3

Input : 6
Output : 2

 * @author mbansiwal
 *
 */
public class MinimumStepsToMinimizeNumberToZero {
	public static void breakSum(int sum)
	{
		int table[] = new int[sum+1];
		table[1] = 1;
		table[2] = 1;
		table[3] = 1;
		
		for (int i = 4; i <= sum; i++) 
		{
			int part1 = i;
			if(i%3 == 0)
			{
				part1 = table[i/3];
			}
			else if(i%2 == 0)
			{
				part1 = table[i/2];
			}
			
			table[i] = 1 + Math.min(part1, table[i-1]);
		}
		
		System.out.println(Arrays.toString(table));
	}
	
	public static void main(String[] args) {
		breakSum(10);
		breakSum(6);
	}
}
