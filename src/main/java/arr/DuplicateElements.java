package arr;

/**
 * This question is to find all duplicate elements within range of 1 to n.
 */
public class DuplicateElements
{

	public static void main(String[] args)
	{
		int[] arr = { 1, 2, 3, 1, 3, 6, 6 };
		findDuplicate(arr);
	}

	/**
	 * This method uses the count sort technique to find the duplicate numbers
	 * @param arr
	 */
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
