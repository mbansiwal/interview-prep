package arr;

public class LongestTurbulentArray
{
	public int maxTurbulenceSize(int[] arr)
	{
		int ans = 1;
		int startIndex = 0;
		int n = arr.length;
		for (int i = 1; i < arr.length; i++)
		{
			int comparision = Integer.compare(arr[i - 1], arr[i]);
			if (comparision == 0)
			{
				startIndex = i;
			}
			if (i == n - 1 || (comparision * Integer.compare(arr[i], arr[i + 1]) != -1))
			{
				ans = Math.max(ans, i - startIndex + 1);
				startIndex = i;
			}
		}
		return ans;
	}

	public static void main(String[] args)
	{
		int arr[] =
		{
				9, 4, 2, 10, 7, 8, 8, 1, 9
		};
		System.out.println(new LongestTurbulentArray().maxTurbulenceSize(arr));

		int arr1[] = {2,1,4,7,3,2,5};
		System.out.println(new LongestTurbulentArray().maxTurbulenceSize(arr1));
	}
}
