package arr;

public class BinarySearchInArray 
{
	private static int search(int[] arr, int dataKey, int low, int high)
	{
		int mid = low + (high-low)/2;
		
		if(arr[mid] == dataKey)
		{
			return mid;
		}
		else if(arr[mid] > dataKey)
		{
			return search(arr, dataKey, low, mid-1);
		}
		if(arr[mid] < dataKey)
		{
			return search(arr, dataKey, mid+1, high);
		}
		return -1;
	}
	
	private static int search(int[] arr, int dataKey)
	{
		int low =0;
		int high = arr.length-1;
		
		while(low<=high)
		{
			int mid = low + (high-low)/2;
			if(arr[mid] == dataKey)
			{
				return mid;
			}
			else if(arr[mid] > dataKey)
			{
				high = mid-1;
			}
			if(arr[mid] < dataKey)
			{
				low = mid+1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) 
	{
		int[] arr = {-1, 2, 3, 5, 6, 8, 9, 10};
		System.out.println(search(arr, 7, 0, arr.length - 1));
		System.out.println(search(arr, 7));
	}
}
