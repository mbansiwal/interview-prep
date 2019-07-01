package dp.lis;

public class MinimumTimeToFinishTasksWithoutSkippingTwoConsecutive
{
	public static void minimumSum(int[] arr)
	{
		int excl = 0;
		int incl = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			int temp = incl;
			incl = arr[i] + Math.min(incl, excl);
			excl = temp;
		}
		System.out.println(Math.min(incl, excl));
	}

	public static void min(int[] arr)
	{
		int incl = arr[0];
		int excl = 0;
		
		for (int i = 1; i < arr.length; i++)
		{
			int newIncl = arr[i] + Math.min(excl, incl);
			
			excl = incl;
			incl = newIncl;
		}
		
		System.out.println(Math.min(incl, excl));
	}
	
	public static void main(String[] args)
	{
		int arr1[] =
		{
				10, 5, 7, 10
		};
		min(arr1);
		minimumSum(arr1);
	}
}
