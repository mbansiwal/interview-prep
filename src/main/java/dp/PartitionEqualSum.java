/**
 * 
 */
package dp;

/**
 * @author mbansiwal
 *
 */
public class PartitionEqualSum 
{
	private static boolean isSumExist(int arr[])
	{
		int sum =0;
		for (int i : arr) {
			sum+=i;
		}
		if (sum%2 != 0)
		{
			return false;
		}
		sum = sum/2;
		System.out.println(sum);
		return SubSetSum.isSumExist(sum, arr);
	}
	
	public static void main(String[] args) 
	{
		int arr[] = {1, 5, 11, 5};
		System.out.println(isSumExist(arr));
		
		int arr2[] = {1, 5, 3};
		System.out.println(isSumExist(arr2));
	}
}
