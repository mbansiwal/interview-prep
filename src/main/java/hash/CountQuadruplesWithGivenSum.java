package hash;

import java.util.HashMap;
import java.util.Map;

public class CountQuadruplesWithGivenSum
{
	public static void count(int x, int[] arr1,int[] arr2,int[] arr3,int[] arr4)
	{
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < arr1.length; i++)
		{
			for (int j = 0; j < arr2.length; j++)
			{
				int sum = arr1[i]+arr2[j];
				map.put(sum, map.getOrDefault(sum, 0)+1);
			}
		}
		
		int count = 0;
		for (int i = 0; i < arr3.length; i++)
		{
			for (int j = 0; j < arr4.length; j++)
			{
				int sum = x-(arr3[i]+arr4[j]);
				count += map.getOrDefault(sum, 0);
			}
		}
		
		System.out.println(count);
	}
	
	public static void main(String[] args)
	{
		int[] arr1 =
		{
				1, 4, 5, 6
		};
		int[] arr2 =
		{
				2, 3, 7, 8
		};
		int[] arr3 =
		{
				1, 4, 6, 10
		};
		int[] arr4 =
		{
				2, 4, 7, 8
		};
		int n = 4, x = 30;
		
		count(x, arr1, arr2, arr3, arr4);
	}
}
