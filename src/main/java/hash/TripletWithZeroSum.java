package hash;

import java.util.HashSet;
import java.util.Set;

public class TripletWithZeroSum
{
	public static void find(int[] arr)
	{
		for (int i = 0; i < arr.length-1; i++)
		{
			Set<Integer> arrElements = new HashSet<>();
			int first = arr[i];
			for (int j = i+1; j < arr.length; j++)
			{
				int second = arr[j];
				
				int third = -(first+second);
				
				if(arrElements.contains(third))
				{
					System.out.println("third="+third + ", first = "+first+", second = "+second);
				}
				else
				{
					arrElements.add(second);
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		int arr[] = {0, -1, 2, -3, 1};
		find(arr);
	}
}
