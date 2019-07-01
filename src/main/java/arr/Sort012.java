package arr;

import java.util.Arrays;

public class Sort012 {
	static void sort(int[] arr)
	{
		int low = 0;
		int high = arr.length -1;
		int mid=0;
		
		int count = 0;
		while(mid<=high)
		{
			++count;
			if(arr[mid] == 0)
			{
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid] = temp;
				mid++;
				low++;
			}
			else if(arr[mid] == 1)
			{
				mid++;
			}
			else if(arr[mid] == 2)
			{
				int temp = arr[high];
				arr[high] = arr[mid];
				arr[mid] = temp;
				high--;
			}
		}
		System.out.println(count);
	}
	//1,0
	public static void main(String[] args) {
		int arr[] =
		{
				2, 2, 2, 0, 1, 2, 1, 2, 2, 2, 2, 1
		};
//		int arr[] = {2,1, 1,1, 1,0};
        sort(arr);
        System.out.println("Array after seggregation "+Arrays.toString(arr));
	}
}
