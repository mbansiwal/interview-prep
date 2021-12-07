package arr;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 * 
 * Largest subarray with equal number of 0s and 1s
Difficulty Level : Hard
Last Updated : 18 Jun, 2021
Given an array containing only 0s and 1s, find the largest subarray which contains equal no of 0s and 1s. 
The expected time complexity is O(n). 

Examples: 

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6 
(Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4

 * @author Administrator
 *
 */
public class LargestSubArrayWithMaxOneAndZero 
{
	private static void printSubArrayIndexes(int[] arr)
	{
		int n = arr.length;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		int maxLength = -1;
		int endIndex = -1;
		for (int i = 0; i < n; i++) 
		{
			sum = sum + (arr[i]==0?-1:arr[i]);
			if(sum == 0)
			{
				endIndex = i;
				maxLength = i+1;
			}
			else if(map.containsKey(sum))
			{
				int diff = i - map.get(sum);
				if(diff > maxLength)
				{
					maxLength = diff;
					endIndex = i;
				}
			}
			else
			{
				map.put(sum, i);
			}
		}
		int startIndex = endIndex - maxLength + 1;
		if(endIndex == -1)
		{
			System.out.println("No such subarray");
		}
		else
		{
			System.out.println("array start from "+startIndex + " to "+endIndex);
		}
	}
	
	public static void main(String[] args) 
	{
		int arr[] = {1, 0, 0, 1, 0, 1,1,0};
        printSubArrayIndexes(arr);
        
		int arr1[] =
		{
				1, 0, 0, 1, 0, 1, 1
		};
        printSubArrayIndexes(arr1);
        
        int arr2[] = {1, 1, 1, 1};
        printSubArrayIndexes(arr2);
	}

}
