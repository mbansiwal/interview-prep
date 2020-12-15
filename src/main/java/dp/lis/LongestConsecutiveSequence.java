package dp.lis;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/longest-increasing-consecutive-subsequence/
 * 
 * @author mbansiwal
 *
 */
public class LongestConsecutiveSequence
{
	public static int sequence(int[] arr)
	{
		int[] table = new int[arr.length];
		int result = 1;

		for (int i = 0; i < arr.length; i++)
		{
			table[i] = 1;
		}
		for (int i = 1; i < arr.length; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr[i] > arr[j] && (arr[i] - arr[j]) == 1)
				{
						table[i] = Math.max(table[i], table[j] + 1);
				}
			}
			result = Math.max(result, table[i]);
		}

		return result;
	}
	
	public static int solution2(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(arr[0], 1);
		for (int i = 1; i < arr.length; i++) {
			if(map.containsKey(arr[i] -1)) {
				map.put(arr[i], map.get(arr[i] - 1)+1);
				map.remove(arr[i] -1 );
			} else {
				map.put(arr[i], 1);
			}
		}
		return Collections.max(map.values());
	}

	public static void main(String[] args)
	{
		int arr[] =
		{
				6, 7, 8, 3, 4, 5, 9, 10
		};
		System.out.println(sequence(arr));
		System.out.println(solution2(arr));
	}
	
}
