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

	public int findMedianOfSortedArrays(int[] arr1, int start1, int end1, int[] arr2, int start2, int end2)
	{
		if(arr1.length > arr2.length){
			return findMedianOfSortedArrays(arr2, start2, end2, arr1, start1, end1);
		}

		int n1 = arr1.length;
		int n2 = arr2.length;
		boolean isEven = (n1+n2)%2 == 0;
		int low = 0;
		int high = n1 - 1;
		while(low <= high){
			int x = (low+high)/2;
			int y = (n1+n2+1)/2 - x;

			int maxLeftX = x < 0?Integer.MIN_VALUE:arr1[x-1];
			int minRightX = x == n1?Integer.MAX_VALUE:arr1[x];

			int maxLeftY = y < 0?Integer.MIN_VALUE:arr2[y-1];
			int minRightY = y == n2?Integer.MAX_VALUE:arr2[y];

			if(maxLeftX <= minRightY && maxLeftY <= minRightX){
				if(isEven){
					return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))/2;
				} else{
					return Math.max(maxLeftX, maxLeftY);
				}
			} else if(maxLeftY > minRightX){
				low = x + 1;
			} else{
				high = x - 1;
			}
		}

		throw new IllegalArgumentException();
	}
	
	public static void main(String[] args) 
	{
		MedianOfTwoSortedArray medianOfArray = new MedianOfTwoSortedArray();
		int arr1[] = {1, 2, 3, 6};
	    int arr2[] = {4, 6, 8, 10};
	    
		System.out.println(medianOfArray.findMedianOfSortedArrays(arr1, arr2));
	    
	    int arr3[] = {1, 12, 15, 26, 38};
	    int arr4[] = {2, 13, 17, 30, 45};
	    
		System.out.println(medianOfArray.findMedianOfSortedArrays(arr3, arr4));

		int[] x = {1, 3,  8,  9,  15, 16};
		int[] y = {7, 11, 19, 21, 18, 25};
		System.out.println(medianOfArray.findMedianOfSortedArrays(x, y));
		int[] xy = {1, 3, 7, 8, 9, 11, 15, 16, 18, 19, 21, 25};
		System.out.println(medianOfArray.caculateMedian(xy, 0, xy.length-1));

	}
}
