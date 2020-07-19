package bits;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/find-two-missing-numbers-set-1-an-interesting-linear-time-solution/
 * https://www.geeksforgeeks.org/find-two-missing-numbers-set-2-xor-based-solution/
 */
public class
TwoMissingElements
{
	public void findTwoMissingElements(int[] arr)
	{
		int n = arr.length + 2;
		int xor = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			xor = xor ^ arr[i];
		}

		for (int i = 1; i <= n; i++)
		{
			xor = xor ^ i;
		}

		int setBit = xor & ~(xor - 1);

		int x = 0;
		int y = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if ((arr[i] & setBit) > 0)
			{
				x = x ^ arr[i];
			} else
			{
				y = y ^ arr[i];
			}
		}


		for (int i = 1; i <= n; i++)
		{
			if ((i & setBit) > 0)
			{
				x = x ^ i;
			} else
			{
				y = y ^ i;
			}
		}

		System.out.println("Two elements are x = " + x + ", y = " + y);
	}

	public void findTwoMissingElements1(int[] arr)
	{
		int n = arr.length+2;
		int totalSum = n*(n+1)/2;

		int arrSum = Arrays.stream(arr).sum();
		int sumOfMissingElements = totalSum - arrSum;

		int avg = sumOfMissingElements/2;

		int sumOfAvgNumbers = avg*(avg+1)/2;

		int avgSum = 0;
		for(int i=0; arr[i] <= avg; ++i){
			avgSum += arr[i];
		}
		int firstMissingNumber = sumOfAvgNumbers - avgSum;
		int secondMissingNumber = sumOfMissingElements - firstMissingNumber;
		System.out.println("Two elements are firstMissingNumber = " + firstMissingNumber + ", secondMissingNumber = " + secondMissingNumber);
	}


	public static void main(String[] args)
	{
		int arr[] =
		{
				1, 3, 5, 6
		};
		new TwoMissingElements().findTwoMissingElements(arr);
		new TwoMissingElements().findTwoMissingElements1(arr);


		int arr2[] =
		{
				1, 3, 4, 5, 6, 7, 9
		};
		new TwoMissingElements().findTwoMissingElements(arr2);
		new TwoMissingElements().findTwoMissingElements1(arr2);
	}
}
