package arr;

public class MedianOfArray 
{
	private int caculateMedian(int[] arr,int start, int end)
	{
		int n = end - start + 1;
		if(n%2 == 0)
		{
			int middle = n/2;
			return (arr[start + middle-1] + arr[start + middle])/2;
		}
		else
		{
			int middle = (n+1)/2;
			return arr[start + middle-1];
		}
	}
	
	public int findMedianOfSortedArrays(int[] arr1, int[] arr2)
	{
		return findMedianOfSortedArrays(arr1, 0, arr1.length-1, arr2, 0, arr2.length-1);
	}
	
	public int findMedianOfSortedArrays(int[] arr1, int start1, int end, int[] arr2, int start2, int end2)
	{
		int n = end - start1 + 1;
		if(n <=0)
		{
			return -1;
		}
		else if(n ==1)
		{
			return (arr1[start1]+arr2[start2])/2;
		}
		else if(n ==2)
		{
			return (Math.max(arr1[start1],arr2[start2]) + Math.min(arr1[end], arr2[end2]))/2;
		}
		
		int median1 = caculateMedian(arr1, start1, end);
		int median2 = caculateMedian(arr2, start2, end2);
		
		if(median1 == median2) 
		{
			return median1;
		}
		if(median1 < median2)
		{
			//median lies between arr2 0,media2 and arr1 media1,n
			if(n%2 == 0)
			{
				return findMedianOfSortedArrays(arr2, start2, start2 + (n/2)-1, arr1, start1 + (n/2), start1 + n-1);
			}
			else
			{
				return findMedianOfSortedArrays(arr2, start2, start2 + n/2, arr1, start1 + n/2, start1 + n-1);
			}
		}
		else
		{
			//median lies between arr1 0,median1 and arr2 median2,n
			if(n%2 == 0)
			{
				return findMedianOfSortedArrays(arr1, start1, start1 + (n/2)-1, arr2, start2 + (n/2), start2 + n-1);
			}
			else
			{
				return findMedianOfSortedArrays(arr1, start1, start1 + n/2, arr2, start2 + n/2, start2 + n-1);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		MedianOfArray medianOfArray = new MedianOfArray();
		int arr1[] = {1, 2, 3, 6};
	    int arr2[] = {4, 6, 8, 10};
	    
		System.out.println(medianOfArray.findMedianOfSortedArrays(arr1, arr2));
	    
	    int arr3[] = {1, 12, 15, 26, 38};
	    int arr4[] = {2, 13, 17, 30, 45};
	    
	    System.out.println(medianOfArray.findMedianOfSortedArrays(arr3, arr4));

		int[] x = {1, 3,  8,  9,  15, 16};
		int[] y = {7, 11, 19, 21, 18, 25};
		System.out.println(medianOfArray.findMedianOfSortedArrays(x, y));
	}
}
