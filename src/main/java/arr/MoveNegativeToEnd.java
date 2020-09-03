package arr;

public class MoveNegativeToEnd
{
	static void moveNegativeToEvenAndPositiveToOdd(int arr[], int n)
	{
		int oddIndex = 0;
		int evenIndex = 1;
		while (true)
		{
			if (arr[oddIndex] >= 0 && oddIndex < n)
			{
				oddIndex += 2;
			}
			if (arr[evenIndex] < 0 && evenIndex < n)
			{
				evenIndex += 2;
			}

			if (oddIndex < n && evenIndex < n)
			{
				int temp = arr[evenIndex];
				arr[evenIndex] = arr[oddIndex];
				arr[oddIndex] = temp;
			} else
			{
				break;
			}
		}
	}

	static void moveNegativesToEnd(int arr[], int n)
	{
		for (int i = 1; i < arr.length; i++)
		{
			if(arr[i] < 0 && arr[i-1] > 0){
				int temp = arr[i-1];
				arr[i-1] = arr[i];
				arr[i] = temp;
			}
		}
	}

	static void moveZerosToEnd(int arr[], int n)
	{
		int negativeNumberIndex = 0;
		int positiveNumberIndex = 0;
		int positiveArr[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] < 0)
			{
				int temp = arr[negativeNumberIndex];
				arr[negativeNumberIndex] = arr[i];
				arr[i] = temp;
				negativeNumberIndex++;
			} else
			{
				positiveArr[positiveNumberIndex] = arr[i];
				positiveNumberIndex++;
			}
		}

		int j = negativeNumberIndex;
		for (int i = 0; i < positiveNumberIndex; i++)
		{
			arr[j] = positiveArr[i];
			j++;
		}
	}

	static void printArray(int arr[], int n)
	{
		for (int i = 0; i < n; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

	// Driver program to test above
	public static void main(String args[])
	{
		int arr[] =
		{
				-12, 11, -13, -5, 6, -7, 5, -3, -6
		};
		int n = arr.length;

		System.out.print("Original array: ");
		printArray(arr, n);

		moveZerosToEnd(arr, n);

		System.out.print("\nModified array: ");
		printArray(arr, n);
		
		System.out.println();
		int arr2[] =
		{
				1, -3, 5, 6, -3, 6, 7, -4, 9, 10
		};
		moveNegativeToEvenAndPositiveToOdd(arr2, arr2.length);
		printArray(arr2, arr2.length);
	}
}
