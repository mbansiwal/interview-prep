package arr;

public class MoveZeroToEnd
{
	static void moveZerosToEnd(int arr[], int n)
	{
		int j = 0;
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] > 0)
			{
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				j++;
			}
		}
	}

	static void printArray(int arr[], int n)
	{
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	// Driver program to test above
	public static void main(String args[])
	{
		int arr[] =
		{
				1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9
		};
		int n = arr.length;

		System.out.print("Original array: ");
		printArray(arr, n);

		moveZerosToEnd(arr, n);

		System.out.print("\nModified array: ");
		printArray(arr, n);
	}
}
