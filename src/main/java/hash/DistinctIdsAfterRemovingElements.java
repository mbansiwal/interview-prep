package hash;

import java.util.*;
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
		int size = arr.length;

		// Store the occurrence of ids
		for (int i = 0; i < n; i++)
		{
			m.put(arr[i], m.getOrDefault(arr[i], 0) + 1);
		}

		Comparator<Map.Entry<Integer, Integer>> comparator = (Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2)->
			m1.getValue().compareTo(m2.getValue());

		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue(comparator);
		queue.addAll(m.entrySet());

		int skippedElements = 0;
		while(!queue.isEmpty()){
			if(mi == 0){
				break;
			}
			Integer toRemoveSize = queue.poll().getValue();
			if(mi >= toRemoveSize){
				mi = mi - toRemoveSize;
			} else{
				skippedElements++;
			}
		}
		return skippedElements + queue.size();
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

		int arr2[] =
				{
						2, 4, 1, 5, 3, 5, 1, 3
				};
		int m2 = 2;

		System.out.println(distinctIds(arr2, arr2.length, m2));
	}
}
