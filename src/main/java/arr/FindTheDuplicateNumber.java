package arr;

public class FindTheDuplicateNumber
{
	public int findDuplicate(int[] nums)
	{
		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < n; ++i)
		{
			sum += nums[i];
		}

		int expectedSum = (n - 1) * (n) / 2;

		return sum - expectedSum;
	}

	public int findDuplicate2(int[] nums)
	{
		int tortoise = nums[0];
		int hare = nums[0];

		do
		{
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		} while (hare != tortoise);

		int ptr1 = tortoise;
		int ptr2 = nums[0];
		while (ptr1 != ptr2)
		{
			ptr1 = nums[ptr1];
			ptr2 = nums[ptr2];
		}
		return ptr1;
	}

	public static void main(String[] args)
	{
		int nums[] =
		{
				2, 2, 2, 2, 2
		};
		System.out.println(new FindTheDuplicateNumber().findDuplicate(nums));
		System.out.println(new FindTheDuplicateNumber().findDuplicate2(nums));

		int[] nums2 =
		{
				2, 5, 9, 6, 9, 3, 8, 9, 7, 1
		};
		System.out.println(new FindTheDuplicateNumber().findDuplicate2(nums2));
	}
}
