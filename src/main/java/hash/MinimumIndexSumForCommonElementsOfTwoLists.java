package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumForCommonElementsOfTwoLists
{

	public static void findElements(String[] a, String[] b) 
	{
		Map<String, Integer> elementToIndexMap = new HashMap<String, Integer>();
		
		for (int i = 0; i < a.length; i++)
		{
			elementToIndexMap.put(a[i], i);
		}
		
		List<String> result = new ArrayList<>();
		int minimumIndexSum = Integer.MAX_VALUE;
		for (int j = 0; j < b.length; j++)
		{
			if(elementToIndexMap.containsKey(b[j]))
			{
				int sum = j + elementToIndexMap.get(b[j]);
				
				if(sum < minimumIndexSum)
				{
					result.clear();
					result.add(b[j]);
					minimumIndexSum = sum;
				}
				else if(sum == minimumIndexSum)
				{
					result.add(b[j]);
				}
			}
		}
		
		result.stream().forEach(System.out::println);
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		String[] a = {"GeeksforGeeks", "Udemy", "Coursera", "edX"};
		String[] b = {"Codecademy", "Khan Academy", "GeeksforGeeks"};
		
		findElements(a, b);

		String[] a2 = {"Udemy", "GeeksforGeeks", "Coursera", "edX"};
		String[] b2 = {"GeeksforGeeks", "Udemy", "Khan Academy", "Udacity"};
		
		findElements(a2, b2);

		String[] a3 =
		{
				"Udemy", "GeeksforGeeks", "Coursera", "edX"
		};
		String[] b3 =
		{
				"GeeksforGeeks", "Khan Academy", "Udemy", "Udacity"
		};

		findElements(a3, b3);
	}

}
