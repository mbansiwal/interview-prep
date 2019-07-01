package arr;

public class MedianOfTwoSortedArray 
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
	
	public int findMedianOfSortedArrays2(int[] arr1, int[] arr2)
	{
		return findMedianOfSortedArrays2(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
	}

	public int findMedianOfSortedArrays2(int[] arr1, int start, int end, int[] arr2, int start2, int end2)
	{
		int n1 = end - start + 1;
		int n2 = end2 - start2 + 1;

		if (n1 == 2 && n2 == 2)
		{
			return (Math.max(arr1[start], arr2[start2]) + Math.min(arr1[end], arr2[end2])) / 2;
		}

		int median1 = caculateMedian(arr1, start, end);
		int median2 = caculateMedian(arr2, start2, end2);
		int mid1 = (start + end) / 2;
		int mid2 = (start2 + end2) / 2;

		if (median1 == median2)
		{
			return median1;
		} else if (median1 > median2)
		{
			return findMedianOfSortedArrays2(arr1, start, mid1, arr2, mid2, end2);
		} else
		{
			return findMedianOfSortedArrays2(arr1, mid1, end, arr2, start2, mid2);
		}
	}

	public int findMedianOfSortedArrays(int[] arr1, int start, int end, int[] arr2, int start2, int end2)
	{
		int n = end - start + 1;
		if(n <=0)
		{
			return -1;
		}
		else if(n ==1)
		{
			return (arr1[start]+arr2[start2])/2;
		}
		else if(n ==2)
		{
			return (Math.max(arr1[start],arr2[start2]) + Math.min(arr1[end], arr2[end2]))/2;
		}
		
		int median1 = caculateMedian(arr1, start, end);
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
				return findMedianOfSortedArrays(arr2, start2, start2 + (n/2)+1, arr1, start + (n/2)-1, start + n-1);
			}
			else
			{
				return findMedianOfSortedArrays(arr2, start2, start2 + n/2, arr1, start + n/2, start + n-1);
			}
		}
		else
		{
			//median lies between arr1 0,median1 and arr2 median2,n
			if(n%2 == 0)
			{
				return findMedianOfSortedArrays(arr1, start, start + (n/2)+1, arr2, start2 + (n/2)-1, start2 + n-1);
			}
			else
			{
				return findMedianOfSortedArrays(arr1, start, start + n/2, arr2, start2 + n/2, start2 + n-1);
			}
		}
	}
	
	public static void main(String[] args) 
	{
		MedianOfTwoSortedArray medianOfArray = new MedianOfTwoSortedArray();
		int arr1[] = {1, 2, 3, 6};
	    int arr2[] = {4, 6, 8, 10};
	    
		System.out.println(medianOfArray.findMedianOfSortedArrays2(arr1, arr2));
	    
	    int arr3[] = {1, 12, 15, 26, 38};
	    int arr4[] = {2, 13, 17, 30, 45};
	    
		System.out.println(medianOfArray.findMedianOfSortedArrays2(arr3, arr4));

		System.out.println(medianOfArray.caculateMedian(new int[]
		{
				1, 2, 12, 13, 15, 17, 26, 30, 38, 45
		}, 0, 9));
	}
}
