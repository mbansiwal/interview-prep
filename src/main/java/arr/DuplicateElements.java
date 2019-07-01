package arr;

public class DuplicateElements
{

	public static void main(String[] args)
	{
		int[] arr = { 1, 2, 3, 1, 3, 6, 6 };
		findDuplicate(arr);
	}
	
	
	public static void findDuplicate(int[] arr)
	{
		int n = arr.length;
		for (int a : arr) 
		{
			int index = a%n;
			arr[index]+=n;
		}
		
		for (int i = 0; i < n; i++) 
		{
			if(arr[i]/n > 1)
			{
				System.out.println(i+","+arr[i]/n);
			}
		}
	}

}
