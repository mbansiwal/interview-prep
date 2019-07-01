package dp.lis;

/**
 * The longest Zig-Zag subsequence problem is to find length of the longest subsequence of given sequence such that all elements of this are alternating.
If a sequence {x1, x2, .. xn} is alternating sequence then its element satisfy one of the following relation :

  x1 < x2 > x3 < x4 > x5 < …. xn or 
  x1 > x2 < x3 > x4 < x5 > …. xn 
Examples:

Input: arr[] = {1, 5, 4}
Output: 3
The whole arrays is of the form  x1 < x2 > x3 

Input: arr[] = {1, 4, 5}
Output: 2
All subsequences of length 2 are either of the form 
x1 < x2; or x1 > x2

Input: arr[] = {10, 22, 9, 33, 49, 50, 31, 60}
Output: 6
The subsequences {10, 22, 9, 33, 31, 60} or
{10, 22, 9, 49, 31, 60} or {10, 22, 9, 50, 31, 60}
are longest Zig-Zag of length 6.
 * @author mbansiwal
 *
 */
public class LongestZigZagSubSequence
{
	public static void sequence(int[] arr)
	{
		int zigZagSequence[][] = new int[arr.length][2];
		

		for (int i = 0; i < arr.length; i++)
		{
			zigZagSequence[i][0] = 1;
			zigZagSequence[i][1] = 1;
		}
		
		int result = 1;
		for (int i = 1; i < arr.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr[i] > arr[j])
				{
					zigZagSequence[i][0] = Math.max(zigZagSequence[i][0], zigZagSequence[j][1] + 1);
				}
				
				if (arr[j] > arr[i])
				{
					zigZagSequence[i][1] = Math.max(zigZagSequence[i][1], zigZagSequence[j][0] + 1);
				}
			}
			result = Math.max(Math.max(result, zigZagSequence[i][0]),zigZagSequence[i][1]); 
		}
		
		System.out.println(result);
	}
	
	public static void main(String[] args)
	{
		int arr[] = { 10, 22, 9, 33, 49, 50, 31, 60 };
		sequence(arr);
	}
	
}
