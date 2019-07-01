package arr;

public class DivideArrayIntoTwo
{
	public static void averageOfTwoArrayIsSame(int[] arr)
	{
		boolean isExist = false;
		int sum = 0;
		for (int data : arr) 
		{
			sum+=data;
		}
		int n = arr.length;
		int lsum = 0;
		int rsum =0;
		for (int i = 0; i < n-1; i++) 
		{
			lsum+=arr[i];
			rsum = sum - lsum;
			
			if(lsum*(n-i-1) == rsum*(i+1))
			{
				isExist = true;
				System.out.println("arr from "+0+".."+i+" and "+(i+1)+".."+(n-1));
			}
		}
		System.out.println(isExist?"Found Match":"Match not found");
	}
	
	public static void main(String[] args) 
	{
		int arr[] = {1, 5, 7, 2, 0};
		averageOfTwoArrayIsSame(arr);
		int arr2[] = {4, 3, 5, 9, 11};
		averageOfTwoArrayIsSame(arr2);
		
		System.out.println(20%8);
	}
}
