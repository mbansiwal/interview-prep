package arr;

import java.util.Arrays;

public class CountNumberOfPossibleTriangles 
{
	public static int findNumberOfTriangles(int[] arr)
	{
		Arrays.sort(arr);
		int count = 0;
		for (int i = 2; i < arr.length; i++) 
		{
			int left = 0;
			int right = i-1;
			
			while(left < right)
			{
				if ((arr[left] + arr[right]) > arr[i])
				{
					count+= right-left;
					right--;
				}
				else
				{
					left++;
				}
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) 
	{
		int arr[] = {10, 21, 22, 100, 101, 200, 300};
        System.out.println("Total number of triangles is " +
                            findNumberOfTriangles(arr));
        
        int arr2[] = {1,2,3,4,4,3,1,3,2,34,243535,6,523,423,413,432,21,312,312,312,312,323,543453,645,76,7};
        System.out.println("Total number of triangles is " +
                findNumberOfTriangles(arr2));

		int arr3[] =
		{
				4, 6, 3, 7
		};
		System.out.println("Total number of triangles is " + findNumberOfTriangles(arr3));

		int arr4[] =
		{
				2, 3, 4, 5, 6, 7
		};
		System.out.println("Total number of triangles is " + findNumberOfTriangles(arr4));

	}
}
