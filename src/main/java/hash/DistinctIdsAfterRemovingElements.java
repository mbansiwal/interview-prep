package hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Given an array of items, an i-th index element denotes the item id’s and
 * given a number m, the task is to remove m elements such that there should be
 * minimum distinct id’s left.Print the number of distinct id’s.
 * 
 * Examples:
 * 
 * Input : arr[] = { 2, 2, 1, 3, 3, 3} m = 3 Output : 1 Remove 1 and both
 * 2's.So, only 3 will be left that's why distinct id is 1.
 * 
 * Input : arr[] = { 2, 4, 1, 5, 3, 5, 1, 3} m = 2 Output : 3 Remove 2 and 4
 * completely. So, remaining ids are 1, 3 and 5 i.e. 3
 * 
 * @author mbansiwal
 *
 */
public class DistinctIdsAfterRemovingElements
{
	static int distinctIds(int arr[], int n, int mi)
	{

		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		int count = 0;
		int size = 0;

		// Store the occurrence of ids
		for (int i = 0; i < n; i++)
		{

			// If the key is not add it to map
			if (m.containsKey(arr[i]) == false)
			{
				m.put(arr[i], 1);
				size++;
			}

			// If it is present then increase the value by 1
			else
				m.put(arr[i], m.get(arr[i]) + 1);
		}

		// Start removing elements from the beginning
		for (Entry<Integer, Integer> mp : m.entrySet())
		{
			// Remove if current value is less than
			// or equal to mi
			if (mp.getKey() <= mi)
			{
				mi -= mp.getKey();
				count++;
			}
			// Return the remaining size
			else
				return size - count;
		}

		return size - count;
	}

	// Driver method to test above function
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int arr[] =
		{
				2, 3, 1, 2, 3, 3
		};
		int m = 3;

		System.out.println(distinctIds(arr, arr.length, m));
	}
}
