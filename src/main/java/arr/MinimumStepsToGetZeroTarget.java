package arr;

public class MinimumStepsToGetZeroTarget 
{
	public static int findZeroTarget(int[] arr)
	{
		int result = 0;
		int n = arr.length;
		
		while(true)
		{
			int i = 0;
			int zeroCount = 0;
			
			
			for (;i < arr.length; i++) 
			{
				if(arr[i]%2 == 1)
				{
					break;
				}
				else if(arr[i] == 0)
				{
					zeroCount++;
				}
			}
			
			if(zeroCount == n)
			{
				return result;
			}
			if (i == n)
			{
				for (int j = 0; j < n; j++) 
				{
					arr[j] = arr[j]/2;
				}
				result++;
			}
			
			for (int j = i; j < n; j++) 
			{
				if (arr[j] % 2 == 1)
				{
					arr[j]--;
					result++;
				}
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int arr[] = new int[]{16, 16, 16} ;
		System.out.println("Minimum number of steps required to \n" + 
                "get the given target array is "+
                findZeroTarget(arr));
	}
}
